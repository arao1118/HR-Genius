package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="DEPARTMENTS")
public class Department {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false, unique=true, length=100) private String departmentName;
 @Column(length=500) private String description;
 public Long getId(){return id;} public String getDepartmentName(){return departmentName;}
 public void setDepartmentName(String v){departmentName=v;} public String getDescription(){return description;}
 public void setDescription(String v){description=v;}
}
