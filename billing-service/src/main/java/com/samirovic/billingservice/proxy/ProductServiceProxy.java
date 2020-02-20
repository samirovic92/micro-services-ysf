package com.samirovic.billingservice.proxy;

import com.samirovic.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cloud-gateway")
public interface ProductServiceProxy {

    @GetMapping("/INVENTORY-SERVICE/products/{id}")
    public Product getProductById(@PathVariable Long id);
}
