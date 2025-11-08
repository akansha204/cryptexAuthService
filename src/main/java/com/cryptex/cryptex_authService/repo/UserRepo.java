package com.cryptex.cryptex_authService.repo;

import com.cryptex.cryptex_authService.enitity.UserEnitity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEnitity, Long> {
    Optional<UserEnitity> findByEmail(String email);
//    boolean existsByEmail(String email);

}
