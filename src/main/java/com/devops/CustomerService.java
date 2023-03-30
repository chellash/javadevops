package com.devops;

import javax.ejb.Stateless;
import javax.ejb.Local;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;
import com.devops.platform.Customer;

@Stateless
@Local(com.devops.platform.CustomerService.class)
public class CustomerService implements com.devops.platform.CustomerService {

    @PersistenceContext(unitName="javadevops")
    private EntityManager entityManager;

    public Customer getCustomer(Long id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>)entityManager.createQuery("select c from Customer c").getResultList();
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