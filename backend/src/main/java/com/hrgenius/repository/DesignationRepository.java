package com.hrgenius.repository;
import com.hrgenius.domain.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface DesignationRepository extends JpaRepository<Designation, Long> {}
