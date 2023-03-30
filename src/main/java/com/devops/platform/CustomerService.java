package com.devops.platform;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(Long id);

    List<Customer> getAllCustomers();
    
    Long createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}