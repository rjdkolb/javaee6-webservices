package org.openrap.webservices.restcxfproxyclient;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.WebApplicationException;
import javax.xml.ws.Response;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.openrap.webservices.domain.Customer;

public class RestClientMain {

    public static void main(String[] args) {
        try {
            ICustomerFacadeREST store = JAXRSClientFactory.create("http://localhost:8080/JavaEEWebServices/rest", ICustomerFacadeREST.class);

            int count = store.countREST();
            System.out.println("count is " + count);
            System.out.println("Create new customer");
            for (int i = 0; i < 10; i++) {
                long time = System.currentTimeMillis();
                Customer returnedCustomer = store.create(new Customer("New Customer " + System.currentTimeMillis()));
                System.out.println("Took " + (System.currentTimeMillis() - time) + "ms");
                System.out.println("Created " + returnedCustomer);
            }
            int countAgain = store.countREST();

            System.out.println("count is now " + countAgain);

        } catch (RuntimeException rExp) {
            System.out.println(rExp.getMessage());
            rExp.printStackTrace();
        }
    }
}
