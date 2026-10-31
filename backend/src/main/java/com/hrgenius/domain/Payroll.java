package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="PAYROLL", indexes=@Index(name="IDX_PAYROLL_PERIOD",columnList="pay_period"))
public class Payroll {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="employee_id") private Employee employee;
 @Column(name="pay_period",nullable=false,length=7) private String payPeriod;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal grossPay;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal totalDeductions;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal netPay;
 private LocalDate processedDate;
 @Column(nullable=false,length=20) private String status="PROCESSED";
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public String getPayPeriod(){return payPeriod;} public void setPayPeriod(String v){payPeriod=v;}
 public BigDecimal getGrossPay(){return grossPay;} public void setGrossPay(BigDecimal v){grossPay=v;}
 public BigDecimal getTotalDeductions(){return totalDeductions;} public void setTotalDeductions(BigDecimal v){totalDeductions=v;}
 public BigDecimal getNetPay(){return netPay;} public void setNetPay(BigDecimal v){netPay=v;}
 public LocalDate getProcessedDate(){return processedDate;} public void setProcessedDate(LocalDate v){processedDate=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
