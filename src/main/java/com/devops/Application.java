package com.javadevops;
import javax.ejb.embeddable.EJBContainer;

public class Application {

    public static void main(String[] args) throws Exception {
        // create an instance of the EJB container
        EJBContainer container = EJBContainer.createEJBContainer();

        try {
            // deploy the EJB components
            container.getContext().bind("inject", new CustomerService());

            // start the application
            System.out.println("EJB application started");
        } catch (Exception e) {
            // handle any exceptions that may occur
            e.printStackTrace();
        } finally {
            // stop the container
            container.close();
        }
    }
}
