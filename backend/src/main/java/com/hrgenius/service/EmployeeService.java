package com.hrgenius.service;
import com.hrgenius.domain.*;
import com.hrgenius.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class EmployeeService {
 private final EmployeeRepository employees; private final DepartmentRepository departments; private final DesignationRepository designations;
 public EmployeeService(EmployeeRepository e, DepartmentRepository d, DesignationRepository g){employees=e;departments=d;designations=g;}
 public List<Employee> all(){return employees.findAll();}
 public Employee get(Long id){return employees.findById(id).orElseThrow(()->new IllegalArgumentException("Employee not found: "+id));}
 @Transactional public Employee create(Employee e){
  if(employees.existsByEmployeeCode(e.getEmployeeCode())) throw new IllegalArgumentException("Employee code already exists");
  if(employees.findByEmail(e.getEmail()).isPresent()) throw new IllegalArgumentException("Email already exists");
  if(e.getDepartment()!=null) e.setDepartment(departments.findById(e.getDepartment().getId()).orElseThrow());
  if(e.getDesignation()!=null) e.setDesignation(designations.findById(e.getDesignation().getId()).orElseThrow());
  if(e.getManager()!=null) e.setManager(get(e.getManager().getId()));
  return employees.save(e);
 }
 @Transactional public Employee update(Long id, Employee input){
  Employee e=get(id); e.setFirstName(input.getFirstName());e.setLastName(input.getLastName());e.setPhone(input.getPhone());
  e.setAddress(input.getAddress());e.setStatus(input.getStatus());e.setDateOfBirth(input.getDateOfBirth());
  if(input.getDepartment()!=null)e.setDepartment(departments.findById(input.getDepartment().getId()).orElseThrow());
  if(input.getDesignation()!=null)e.setDesignation(designations.findById(input.getDesignation().getId()).orElseThrow());
  return e;
 }
}
