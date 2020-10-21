package com.example.springreactiveweb;

import com.example.springreactiveweb.hello.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReactiveWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveWebApplication.class, args);
		GreetingWebClient webClient = new GreetingWebClient();
		System.out.println(webClient.getResult());
	}
}
