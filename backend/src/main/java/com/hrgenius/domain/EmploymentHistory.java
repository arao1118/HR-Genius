package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="EMPLOYMENT_HISTORY")
public class EmploymentHistory {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="employee_id") private Employee employee;
 @Column(nullable=false,length=140) private String companyName;
 @Column(length=120) private String role;
 private LocalDate startDate; private LocalDate endDate;
 @Column(length=1000) private String notes;
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public String getCompanyName(){return companyName;} public void setCompanyName(String v){companyName=v;}
 public String getRole(){return role;} public void setRole(String v){role=v;}
 public LocalDate getStartDate(){return startDate;} public void setStartDate(LocalDate v){startDate=v;}
 public LocalDate getEndDate(){return endDate;} public void setEndDate(LocalDate v){endDate=v;}
 public String getNotes(){return notes;} public void setNotes(String v){notes=v;}
}
