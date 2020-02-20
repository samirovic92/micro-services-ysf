package com.samirovic.customerservice;

import com.samirovic.customerservice.dao.CustomerRepository;
import com.samirovic.customerservice.model.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){

        return args -> {
            customerRepository.save(new Customer(null, "Hasan", "hassan@gmail.com"));
            customerRepository.save(new Customer(null, "Mohamed", "mohamed@gmail.com"));
            customerRepository.save(new Customer(null, "samir", "samir@gmail.com"));
            customerRepository.findAll().forEach( System.out::println);

        };
    }
}
