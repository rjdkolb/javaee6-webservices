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
            store.create(new Customer("New Customer " + System.currentTimeMillis()));
            int countAgain = store.countREST();

            System.out.println("count is now " + countAgain);

            try {
                store.create(new Customer(null));
            } catch (InternalServerErrorException serverError) {
                javax.ws.rs.core.Response r = serverError.getResponse();
                String message = serverError.getMessage();
                System.out.println("Expected Error "+message);
            }

        } catch (RuntimeException rExp) {
            System.out.println(rExp.getMessage());
            rExp.printStackTrace();
        }
    }
}
