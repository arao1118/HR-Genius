package com.hrgenius.repository;
import com.hrgenius.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface CandidateRepository extends JpaRepository<Candidate, Long> {}
