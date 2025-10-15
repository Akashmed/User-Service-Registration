package com.example.User.Service.repositories;

import com.example.User.Service.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface categoryRepository extends CrudRepository<Category, Long> {
}
