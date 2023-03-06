package com.javadevops;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class CustomerService {

    @PersistenceContext(unitName="jpa-example")
    private EntityManager entityManager;

    public Customer getCustomer(Long id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>)entityManager.createQuery("from Customer").getResultList();
    }
    
    public Long createCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer.getId();
    }

    public Customer updateCustomer(Customer customer) {
        return entityManager.merge(customer);
    }

    public void deleteCustomer(Customer customer) {
        entityManager.remove(customer);
    }

}