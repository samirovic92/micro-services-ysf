package com.samirovic.billingservice;

import com.samirovic.billingservice.dao.BillRepository;
import com.samirovic.billingservice.model.Bill;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(BillRepository billRepository) {

        return args -> {
            billRepository.save(new Bill(null, LocalDateTime.now(), null,null,1L,1L));
        };
    }
}
