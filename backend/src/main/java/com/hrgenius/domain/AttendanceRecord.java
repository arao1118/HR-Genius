package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="ATTENDANCE_RECORDS", uniqueConstraints=@UniqueConstraint(columnNames={"employee_id","attendance_date"}))
public class AttendanceRecord {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="employee_id") private Employee employee;
 @Column(name="attendance_date",nullable=false) private LocalDate attendanceDate;
 private LocalTime checkIn; private LocalTime checkOut;
 @Column(length=20) private String status;
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public LocalDate getAttendanceDate(){return attendanceDate;} public void setAttendanceDate(LocalDate v){attendanceDate=v;}
 public LocalTime getCheckIn(){return checkIn;} public void setCheckIn(LocalTime v){checkIn=v;}
 public LocalTime getCheckOut(){return checkOut;} public void setCheckOut(LocalTime v){checkOut=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
