package com.hrgenius.repository;
import com.hrgenius.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface RoleRepository extends JpaRepository<Role, Long> {}
