package com.hrgenius.service;
import com.hrgenius.domain.*; import com.hrgenius.repository.*;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.math.*; import java.time.LocalDate; import java.util.*;
@Service
public class PayrollService {
 private final EmployeeRepository employees; private final EmployeeSalaryRepository salaries; private final PayrollRepository payrolls;
 public PayrollService(EmployeeRepository e,EmployeeSalaryRepository s,PayrollRepository p){employees=e;salaries=s;payrolls=p;}
 public List<Payroll> all(){return payrolls.findAll();}
 @Transactional public List<Payroll> run(String period){
  if(period==null||!period.matches("\\d{4}-\\d{2}"))throw new IllegalArgumentException("Pay period must be YYYY-MM");
  List<Payroll> result=new ArrayList<>();
  for(Employee e:employees.findAll()){
   if(payrolls.existsByPayPeriodAndEmployeeId(period,e.getId()))continue;
   List<EmployeeSalary> components=salaries.findAll().stream().filter(s->s.getEmployee().getId().equals(e.getId())).toList();
   BigDecimal gross=components.stream().filter(s->"EARNING".equalsIgnoreCase(s.getComponent().getType())).map(EmployeeSalary::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
   BigDecimal deductions=components.stream().filter(s->"DEDUCTION".equalsIgnoreCase(s.getComponent().getType())).map(EmployeeSalary::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
   Payroll p=new Payroll();p.setEmployee(e);p.setPayPeriod(period);p.setGrossPay(gross);p.setTotalDeductions(deductions);p.setNetPay(gross.subtract(deductions));p.setProcessedDate(LocalDate.now());p.setStatus("LOCKED");result.add(payrolls.save(p));
  } return result;
 }
}
