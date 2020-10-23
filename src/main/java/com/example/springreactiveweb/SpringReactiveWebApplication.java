package com.example.springreactiveweb;

import com.example.springreactiveweb.hello.GreetingWebClient;
import com.example.springreactiveweb.model.Customer;
import com.example.springreactiveweb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {CustomerRepository.class})
public class SpringReactiveWebApplication implements CommandLineRunner {
    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveWebApplication.class, args);
    }

    public void run(String... args) {
        sayHello();
        // test Mongo Db crud operations
        clearMongoRepository();
        addCustomersToMongoRepository();
        findAllCustomers();
        findCustomerByFirstName();
        findCustomerByLastName();
    }

    private void sayHello() {
        // test 'Hello World'
        GreetingWebClient webClient = new GreetingWebClient();
        System.out.println(webClient.getResult());
    }

    private void clearMongoRepository() {
        System.out.println("Delete all customers from Db >>");
        repository.deleteAll();
    }

    private void addCustomersToMongoRepository() {
        System.out.println("Add customers to Db >>");
        repository.save(new Customer("Kotsanai", "Chikosi"));
        repository.save(new Customer("Koko", "Chikosi"));
    }

    private void findAllCustomers() {
        List<Customer> customers = repository.findAll();
        System.out.println("List all customers >> ");
        //TODO: use Java 8 streams
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    private void findCustomerByFirstName() {
        System.out.println("Find by first name (Koko): >> " + repository.findByFirstName("Koko"));
    }

    private void findCustomerByLastName() {
        System.out.println("Find by last name (Chikosi): >> " + repository.findByLastName("Chikosi"));
    }
}
