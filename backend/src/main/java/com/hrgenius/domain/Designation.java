package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="DESIGNATIONS")
public class Designation {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false, length=120) private String title;
 private Integer gradeLevel;
 @Column(length=500) private String description;
 public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public Integer getGradeLevel(){return gradeLevel;} public void setGradeLevel(Integer v){gradeLevel=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
}
