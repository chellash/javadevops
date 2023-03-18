package com.javadevops;

import javax.persistence.EntityManager;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestCustomerService {
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    CustomerService customerService;

    @Test 
    void testCreateCustomer() {
        // Create a new customer
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@example.com");

        customerService.createCustomer(customer);

        verify(entityManager).persist(customer);
    }

}