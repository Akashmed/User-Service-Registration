package com.example.User.Service;

public interface UserRepository {
    void Save(User user);
    User findUserByEmail(String email);
}
