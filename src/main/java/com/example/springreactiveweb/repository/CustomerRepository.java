package com.example.springreactiveweb.repository;

import com.example.springreactiveweb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
