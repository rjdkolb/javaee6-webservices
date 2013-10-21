package org.openrap.webservices.restcxfproxyclient;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.WebApplicationException;
import javax.xml.ws.Response;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.openrap.webservices.domain.Customer;

public class RestClientMainWithError {

    public static void main(String[] args) {
        try {
            ICustomerFacadeREST store = JAXRSClientFactory.create("http://localhost:8080/JavaEEWebServices/rest", ICustomerFacadeREST.class);

            int count = store.countREST();
            System.out.println("count is " + count);

            try {
                store.create(new Customer(null));
            } catch (InternalServerErrorException serverError) {
                javax.ws.rs.core.Response r = serverError.getResponse();
                String message = serverError.getMessage();
                System.out.println("Expected Error " + r.toString());
            }

        } catch (RuntimeException rExp) {
            System.out.println(rExp.getMessage());
            rExp.printStackTrace();
        }
    }
}
