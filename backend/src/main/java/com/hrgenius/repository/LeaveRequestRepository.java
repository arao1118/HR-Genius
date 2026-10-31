package com.hrgenius.repository;
import com.hrgenius.domain.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> { List<LeaveRequest> findByEmployeeIdAndStatus(Long employeeId, String status);}
