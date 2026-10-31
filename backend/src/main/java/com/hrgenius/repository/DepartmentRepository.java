package com.hrgenius.repository;
import com.hrgenius.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface DepartmentRepository extends JpaRepository<Department, Long> {}
