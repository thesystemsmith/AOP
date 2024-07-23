package com.thesystemsmith.AOP;

// UserRepository.java
import java.util.List;

public interface UserRepository {
    User findById(Long id);
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
}