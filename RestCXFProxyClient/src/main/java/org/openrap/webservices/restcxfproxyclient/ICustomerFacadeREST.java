package org.openrap.webservices.restcxfproxyclient;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.openrap.webservices.domain.Customer;


@Path("customer")
public interface ICustomerFacadeREST {
    @POST
    @Consumes({"application/xml", "application/json"})
    public Customer create(Customer entity);

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx(@PathParam("id") Long id, Customer entity);

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id);

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Customer find(@PathParam("id") Long id);

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Customer> findAll();

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to);

    @GET
    @Path("count")
    @Produces("text/plain")
    public int countREST();
}
