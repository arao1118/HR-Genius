package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="PERFORMANCE_REVIEWS")
public class PerformanceReview {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="employee_id") private Employee employee;
 @ManyToOne(optional=false) @JoinColumn(name="reviewer_id") private Employee reviewer;
 @Column(nullable=false,length=30) private String reviewCycle;
 @Column(precision=3,scale=2) private BigDecimal rating;
 @Column(length=2000) private String strengths;
 @Column(length=2000) private String improvementAreas;
 @Column(length=2000) private String goals;
 private LocalDate reviewDate;
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public Employee getReviewer(){return reviewer;} public void setReviewer(Employee v){reviewer=v;}
 public String getReviewCycle(){return reviewCycle;} public void setReviewCycle(String v){reviewCycle=v;}
 public BigDecimal getRating(){return rating;} public void setRating(BigDecimal v){rating=v;}
 public String getStrengths(){return strengths;} public void setStrengths(String v){strengths=v;}
 public String getImprovementAreas(){return improvementAreas;} public void setImprovementAreas(String v){improvementAreas=v;}
 public String getGoals(){return goals;} public void setGoals(String v){goals=v;}
 public LocalDate getReviewDate(){return reviewDate;} public void setReviewDate(LocalDate v){reviewDate=v;}
}
