package com.hrgenius.domain;
import jakarta.persistence.*;
import java.time.*;
import java.math.BigDecimal;

@Entity @Table(name="EMPLOYEES", indexes={@Index(name="IDX_EMP_DEPT",columnList="department_id"),@Index(name="IDX_EMP_STATUS",columnList="status")})
public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=30) private String employeeCode;
 @Column(nullable=false,length=80) private String firstName;
 @Column(nullable=false,length=80) private String lastName;
 private LocalDate dateOfBirth;
 @Column(length=30) private String gender;
 @Column(nullable=false,unique=true,length=160) private String email;
 @Column(length=30) private String phone;
 @Column(length=500) private String address;
 private LocalDate hireDate;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="department_id") private Department department;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="designation_id") private Designation designation;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="manager_id") private Employee manager;
 @Column(nullable=false,length=20) private String status="ACTIVE";
 public Long getId(){return id;} public String getEmployeeCode(){return employeeCode;} public void setEmployeeCode(String v){employeeCode=v;}
 public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
 public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;}
 public LocalDate getDateOfBirth(){return dateOfBirth;} public void setDateOfBirth(LocalDate v){dateOfBirth=v;}
 public String getGender(){return gender;} public void setGender(String v){gender=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getAddress(){return address;} public void setAddress(String v){address=v;}
 public LocalDate getHireDate(){return hireDate;} public void setHireDate(LocalDate v){hireDate=v;}
 public Department getDepartment(){return department;} public void setDepartment(Department v){department=v;}
 public Designation getDesignation(){return designation;} public void setDesignation(Designation v){designation=v;}
 public Employee getManager(){return manager;} public void setManager(Employee v){manager=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
