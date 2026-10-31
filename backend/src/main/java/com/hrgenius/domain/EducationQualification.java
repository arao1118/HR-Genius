package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="EDUCATION_QUALIFICATIONS")
public class EducationQualification {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="employee_id") private Employee employee;
 @Column(nullable=false,length=120) private String degree;
 @Column(length=160) private String institution;
 private Integer yearOfPassing;
 @Column(length=1000) private String notes;
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public String getDegree(){return degree;} public void setDegree(String v){degree=v;}
 public String getInstitution(){return institution;} public void setInstitution(String v){institution=v;}
 public Integer getYearOfPassing(){return yearOfPassing;} public void setYearOfPassing(Integer v){yearOfPassing=v;}
 public String getNotes(){return notes;} public void setNotes(String v){notes=v;}
}
