package com.hrgenius.repository;
import com.hrgenius.domain.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {}
