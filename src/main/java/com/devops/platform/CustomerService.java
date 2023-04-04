package com.devops.platform;

import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Local
@Path("/customers")
public interface CustomerService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Customer getCustomer(Long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Customer> getAllCustomers();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Long createCustomer(Customer customer);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    Customer updateCustomer(Customer customer);

    @DELETE
    @Path("/{id}")
    void deleteCustomer(Customer customer);
}