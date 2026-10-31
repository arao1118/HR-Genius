package com.hrgenius.repository;
import com.hrgenius.domain.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {}
