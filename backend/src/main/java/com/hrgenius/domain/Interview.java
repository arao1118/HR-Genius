package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="INTERVIEWS")
public class Interview {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="candidate_id") private Candidate candidate;
 @ManyToOne(optional=false) @JoinColumn(name="interviewer_id") private Employee interviewer;
 @Column(nullable=false) private LocalDateTime interviewDate;
 @Column(length=40) private String round;
 @Column(length=2000) private String feedback;
 @Column(length=30) private String result="PENDING";
 public Long getId(){return id;} public Candidate getCandidate(){return candidate;} public void setCandidate(Candidate v){candidate=v;}
 public Employee getInterviewer(){return interviewer;} public void setInterviewer(Employee v){interviewer=v;}
 public LocalDateTime getInterviewDate(){return interviewDate;} public void setInterviewDate(LocalDateTime v){interviewDate=v;}
 public String getRound(){return round;} public void setRound(String v){round=v;}
 public String getFeedback(){return feedback;} public void setFeedback(String v){feedback=v;}
 public String getResult(){return result;} public void setResult(String v){result=v;}
}
