package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="JOB_REQUISITIONS")
public class JobRequisition {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="department_id") private Department department;
 @ManyToOne(optional=false) @JoinColumn(name="designation_id") private Designation designation;
 @ManyToOne(optional=false) @JoinColumn(name="requested_by") private Employee requestedBy;
 @Column(nullable=false) private Integer openings;
 @Column(nullable=false,length=30) private String status="PENDING_APPROVAL";
 private LocalDate openDate;
 @Column(length=2000) private String jobDescription;
 public Long getId(){return id;} public Department getDepartment(){return department;} public void setDepartment(Department v){department=v;}
 public Designation getDesignation(){return designation;} public void setDesignation(Designation v){designation=v;}
 public Employee getRequestedBy(){return requestedBy;} public void setRequestedBy(Employee v){requestedBy=v;}
 public Integer getOpenings(){return openings;} public void setOpenings(Integer v){openings=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public LocalDate getOpenDate(){return openDate;} public void setOpenDate(LocalDate v){openDate=v;}
 public String getJobDescription(){return jobDescription;} public void setJobDescription(String v){jobDescription=v;}
}
