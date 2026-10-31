package com.hrgenius.service;
import com.hrgenius.domain.*; import com.hrgenius.repository.*;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate; import java.util.List;
@Service
public class LeaveService {
 private final LeaveRequestRepository requests; private final EmployeeRepository employees; private final LeaveTypeRepository types;
 public LeaveService(LeaveRequestRepository r,EmployeeRepository e,LeaveTypeRepository t){requests=r;employees=e;types=t;}
 public List<LeaveRequest> all(){return requests.findAll();}
 @Transactional public LeaveRequest apply(Long employeeId,Long typeId,LocalDate from,LocalDate to,String reason){
  if(from==null||to==null||to.isBefore(from))throw new IllegalArgumentException("ToDate must be on or after FromDate");
  Employee employee=employees.findById(employeeId).orElseThrow(); LeaveType type=types.findById(typeId).orElseThrow();
  boolean overlap=requests.findByEmployeeIdAndStatus(employeeId,"APPROVED").stream()
   .anyMatch(r->!to.isBefore(r.getFromDate())&&!from.isAfter(r.getToDate()));
  if(overlap)throw new IllegalArgumentException("Leave overlaps an already approved request");
  LeaveRequest r=new LeaveRequest();r.setEmployee(employee);r.setLeaveType(type);r.setFromDate(from);r.setToDate(to);r.setReason(reason);
  return requests.save(r);
 }
 @Transactional public LeaveRequest decide(Long id,Long approverId,boolean approve,String comment){
  LeaveRequest r=requests.findById(id).orElseThrow(); if(!"PENDING".equals(r.getStatus()))throw new IllegalStateException("Only pending requests can be decided");
  r.setApprovedBy(employees.findById(approverId).orElseThrow());r.setStatus(approve?"APPROVED":"REJECTED");r.setApprovalComment(comment);return r;
 }
}
