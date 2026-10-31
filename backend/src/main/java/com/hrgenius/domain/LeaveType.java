package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="LEAVE_TYPES")
public class LeaveType {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=60) private String typeName;
 @Column(nullable=false) private Integer annualQuota;
 private Boolean carryForward=false;
 public Long getId(){return id;} public String getTypeName(){return typeName;} public void setTypeName(String v){typeName=v;}
 public Integer getAnnualQuota(){return annualQuota;} public void setAnnualQuota(Integer v){annualQuota=v;}
 public Boolean getCarryForward(){return carryForward;} public void setCarryForward(Boolean v){carryForward=v;}
}
