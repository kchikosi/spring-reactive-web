package com.example.springreactiveweb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
public class Customer {
    @Id
    public String id;
    public String firstName;
    public String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }
}
