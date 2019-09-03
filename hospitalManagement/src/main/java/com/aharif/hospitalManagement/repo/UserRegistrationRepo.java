package com.aharif.hospitalManagement.repo;

import com.aharif.hospitalManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegistrationRepo extends JpaRepository<User,Long> {




    Optional<User> findByuserNameOrEmail(String userName, String email);
    User findByUserName(String userName);
    boolean existsByEmail(String email);

    Optional<User> findByUserNameOrEmail(String userName, String email);

}
