package com.hrgenius.repository;
import com.hrgenius.domain.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface InterviewRepository extends JpaRepository<Interview, Long> { List<Interview> findByInterviewerIdAndInterviewDateBetween(Long id, java.time.LocalDateTime from, java.time.LocalDateTime to);}
