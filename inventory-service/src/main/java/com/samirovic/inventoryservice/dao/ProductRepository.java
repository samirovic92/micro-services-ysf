package com.samirovic.inventoryservice.dao;

import com.samirovic.inventoryservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface  ProductRepository extends JpaRepository<Product, Long> {
}
