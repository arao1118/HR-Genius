package com.hrgenius.repository;
import com.hrgenius.domain.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {}
