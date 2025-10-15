package com.example.User.Service.repositories;

import com.example.User.Service.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Long> {
}
