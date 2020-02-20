package com.samirovic.billingservice.proxy;

import com.samirovic.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cloud-gateway")
public interface CustomerServiceProxy {

    @GetMapping("/CUSTOMER-SERVICE/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);
}
