package com.hrgenius.repository;
import com.hrgenius.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> { Optional<UserAccount> findByUsername(String username);}
