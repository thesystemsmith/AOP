package com.thesystemsmith.AOP;

// InMemoryUserRepository.java
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private Map<Long, User> users = new HashMap<>();
    private Long idSequence = 1L;

    @Override
    public User findById(Long id) {
        return users.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idSequence++);
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        users.remove(id);
    }
}
