package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="ROLES")
public class Role {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=40) private String roleName;
 @Column(length=300) private String description;
 public Long getId(){return id;} public String getRoleName(){return roleName;} public void setRoleName(String v){roleName=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
}
