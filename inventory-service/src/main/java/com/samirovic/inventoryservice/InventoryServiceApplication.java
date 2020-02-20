package com.samirovic.inventoryservice;

import com.samirovic.inventoryservice.dao.ProductRepository;
import com.samirovic.inventoryservice.model.Product;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){

        return args -> {
            productRepository.save(new Product(null, "Printer Hp", 170d));
            productRepository.save(new Product(null, "Computer Asus", 800d));
            productRepository.save(new Product(null, "Mac Book Pro", 1200d));
            productRepository.findAll().forEach( System.out::println);
        };
    }
}
