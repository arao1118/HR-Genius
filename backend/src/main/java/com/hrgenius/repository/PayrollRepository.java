package com.hrgenius.repository;
import com.hrgenius.domain.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface PayrollRepository extends JpaRepository<Payroll, Long> { List<Payroll> findByPayPeriod(String period); boolean existsByPayPeriodAndEmployeeId(String period, Long employeeId);}
