package com.hrgenius.repository;
import com.hrgenius.domain.EmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory, Long> {}
