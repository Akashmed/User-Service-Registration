package com.example.User.Service.repositories;

import com.example.User.Service.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface addressRepository extends CrudRepository<Address, Long> {
}
