package org.openrap.webservices.restjaxrs2client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.openrap.webservices.domain.Customer;

public class App 
{

    public static void main(String []args){
        javax.ws.rs.client.Client c = ClientBuilder.newClient();
        
        Integer count = c.target("http://localhost:8080/JavaEEWebServices/rest/customer/count").request(MediaType.TEXT_PLAIN).get(Integer.class);
        System.out.println(count);
        
        
        Customer newCustomer = c.target("http://localhost:8080/JavaEEWebServices/rest/customer/").request(MediaType.APPLICATION_XML).post(Entity.entity(new Customer("new"), MediaType.APPLICATION_XML),Customer.class);
        
        System.out.println("New customer is "+newCustomer);

    }
}
