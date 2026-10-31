package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="USERS")
public class UserAccount {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=80) private String username;
 @Column(nullable=false) private String passwordHash;
 @OneToOne @JoinColumn(name="employee_id",unique=true) private Employee employee;
 @ManyToOne(optional=false) @JoinColumn(name="role_id") private Role role;
 @Column(nullable=false) private Boolean active=true;
 public Long getId(){return id;} public String getUsername(){return username;} public void setUsername(String v){username=v;}
 public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;}
 public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public Role getRole(){return role;} public void setRole(Role v){role=v;}
 public Boolean getActive(){return active;} public void setActive(Boolean v){active=v;}
}
