package com.example.User.Service;

public class User {
    private long id;

    public String getEmail() {
        return email;
    }

    private String email;
    private String password;
    private String name;

    public User(long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
