package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="SALARY_COMPONENTS")
public class SalaryComponent {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=80) private String componentName;
 @Column(nullable=false,length=20) private String type;
 private Boolean taxable=false;
 public Long getId(){return id;} public String getComponentName(){return componentName;} public void setComponentName(String v){componentName=v;}
 public String getType(){return type;} public void setType(String v){type=v;}
 public Boolean getTaxable(){return taxable;} public void setTaxable(Boolean v){taxable=v;}
}
