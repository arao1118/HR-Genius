package com.hrgenius.repository;
import com.hrgenius.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface EmployeeRepository extends JpaRepository<Employee, Long> { Optional<Employee> findByEmail(String email); boolean existsByEmployeeCode(String code);}
