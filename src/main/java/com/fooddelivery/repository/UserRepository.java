package com.fooddelivery.repository;

import com.fooddelivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Spring Data JPA will automatically implement these methods
    // based on the method name convention
    
    // Find user by email
    Optional<User> findByEmail(String email);
    
    // Check if email exists - SPRING DATA JPA IMPLEMENTS THIS AUTOMATICALLY
    boolean existsByEmail(String email);
    
    // Find user by email and password
    Optional<User> findByEmailAndPassword(String email, String password);
    
    // Count users by email (another example)
    long countByEmail(String email);
    
    // Delete user by email
    void deleteByEmail(String email);
}