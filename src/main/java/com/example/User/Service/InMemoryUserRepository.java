package com.example.User.Service;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> usersCollection = new HashMap<>();

    @Override
    public void Save(User user) {
        usersCollection.put(user.getEmail(), user);
    }

    @Override
    public User findUserByEmail(String email) {
      return usersCollection.getOrDefault(email, null);

    }
}
