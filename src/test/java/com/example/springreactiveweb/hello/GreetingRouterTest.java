package com.example.springreactiveweb.hello;

import com.example.springreactiveweb.model.Customer;
import com.example.springreactiveweb.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingRouterTest {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private CustomerRepository repository;

    @Test
    public void testHello(){
        webTestClient.get()
                .uri("/hello")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello World!!");
    }
    @Test
    public void clearMongoDb() {
        repository.deleteAll();
        //TODO: complete assertions
    }

    @Test
    public void testAddCustomers(){
        repository.save(new Customer("Kotsanai", "Chikosi"));
        repository.save(new Customer("Koko", "Chikosi"));
        //TODO: complete assertions
    }
}
