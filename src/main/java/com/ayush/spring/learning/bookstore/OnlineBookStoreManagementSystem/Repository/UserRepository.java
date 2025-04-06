package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Repository;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
