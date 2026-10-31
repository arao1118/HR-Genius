package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="LEAVE_REQUESTS", indexes=@Index(name="IDX_LEAVE_STATUS",columnList="status"))
public class LeaveRequest {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="employee_id") private Employee employee;
 @ManyToOne(optional=false) @JoinColumn(name="leave_type_id") private LeaveType leaveType;
 @Column(nullable=false) private LocalDate fromDate;
 @Column(nullable=false) private LocalDate toDate;
 @Column(length=1000) private String reason;
 @Column(nullable=false,length=20) private String status="PENDING";
 @ManyToOne @JoinColumn(name="approved_by") private Employee approvedBy;
 @Column(length=1000) private String approvalComment;
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public LeaveType getLeaveType(){return leaveType;} public void setLeaveType(LeaveType v){leaveType=v;}
 public LocalDate getFromDate(){return fromDate;} public void setFromDate(LocalDate v){fromDate=v;}
 public LocalDate getToDate(){return toDate;} public void setToDate(LocalDate v){toDate=v;}
 public String getReason(){return reason;} public void setReason(String v){reason=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public Employee getApprovedBy(){return approvedBy;} public void setApprovedBy(Employee v){approvedBy=v;}
 public String getApprovalComment(){return approvalComment;} public void setApprovalComment(String v){approvalComment=v;}
}
