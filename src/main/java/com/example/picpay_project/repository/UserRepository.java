package com.example.picpay_project.repository;

import com.example.picpay_project.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByDocument(String document);
    Optional<User> findUserById(long id);
}
