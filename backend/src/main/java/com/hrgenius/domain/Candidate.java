package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="CANDIDATES")
public class Candidate {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="requisition_id") private JobRequisition requisition;
 @Column(nullable=false,length=80) private String firstName;
 @Column(nullable=false,length=80) private String lastName;
 @Column(nullable=false,length=160) private String email;
 @Column(length=500) private String resumeRef;
 @Column(nullable=false,length=30) private String stage="APPLIED";
 public Long getId(){return id;} public JobRequisition getRequisition(){return requisition;} public void setRequisition(JobRequisition v){requisition=v;}
 public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
 public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getResumeRef(){return resumeRef;} public void setResumeRef(String v){resumeRef=v;}
 public String getStage(){return stage;} public void setStage(String v){stage=v;}
}
