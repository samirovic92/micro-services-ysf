package com.samirovic.billingservice.controller;

import com.samirovic.billingservice.dao.BillRepository;
import com.samirovic.billingservice.model.Bill;
import com.samirovic.billingservice.model.Customer;
import com.samirovic.billingservice.model.Product;
import com.samirovic.billingservice.proxy.CustomerServiceProxy;
import com.samirovic.billingservice.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BillController {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductServiceProxy productServiceProxy;
    @Autowired
    private CustomerServiceProxy customerServiceProxy;

    @GetMapping("/bill/{id}")
    public Bill getBillById(@PathVariable Long id){
        Optional<Bill> billOptional = billRepository.findById(id);

        if (!billOptional.isPresent()) {
            throw new RuntimeException("There is no Bill with Id : " + id);
        }

        Bill bill = billOptional.get();

        /* get product */
        Product product = productServiceProxy.getProductById(bill.getProductId());
        product.setId(bill.getProductId());
        bill.setProduct(product);

        /* get Customer */
        Customer customer = customerServiceProxy.getCustomerById(bill.getCustomerId());
        customer.setId(bill.getCustomerId());
        bill.setCustomer(customer);

        return bill;
    }

}
