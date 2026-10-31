package com.hrgenius.repository;
import com.hrgenius.domain.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Long> {}
