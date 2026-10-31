package com.hrgenius.repository;
import com.hrgenius.domain.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Long> {}
