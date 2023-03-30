package com.devops.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Properties;
import java.io.FileReader;
import javax.naming.NamingException;

public class TestApplication {
        
    private EJBContainer container;
    private Context context;

    @BeforeEach
    public void setup() throws Exception {
        Properties properties = new Properties();
        properties.put("mysqlds", "new://Resource?type=DataSource");
        properties.put("mysqlds.jdbcDriver", "com.mysql.cj.jdbc.Driver");
        properties.put("mysqlds.jdbcUrl", "jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}");
        properties.put("mysqlds.userName", "${DB_USER}");
        properties.put("mysqlds.password", "${DB_PASSWORD}");
        properties.put("mysqlds.JtaManaged", "false");
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        container = EJBContainer.createEJBContainer(properties);
        context = container.getContext();
    }

    @AfterEach
    public void teardown() {
        if (container != null) {
            container.close();
        }
    }

    @Test
    public void testCustomerService() throws NamingException {
        CustomerService customerService = (CustomerService) context.lookup("java:global/main/CustomerService!com.devops.platform.CustomerService");
        List<Customer> result = customerService.getAllCustomers();
        assertEquals(3, result.size());
    }
}
