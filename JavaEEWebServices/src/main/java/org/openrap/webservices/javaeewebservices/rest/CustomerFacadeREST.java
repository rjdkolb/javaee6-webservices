package org.openrap.webservices.javaeewebservices.rest;

import org.openrap.webservices.javaeewebservices.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.openrap.webservices.domain.Customer;
import org.openrap.webservices.javaeewebservices.rest.supplement.BeanValidationAppendixInterceptor;

@Stateless
@Path("customer")
@Interceptors(BeanValidationAppendixInterceptor.class)
public class CustomerFacadeREST extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "JavaEEWebServices")
    private EntityManager em;

    public CustomerFacadeREST() {
        super(Customer.class);
    }

    @GET
    @Path("ping")
    public String ping(@QueryParam(value = "input") String input) {
        if ("ERROR".equals(input)){
            throw new RuntimeException("ERROR, input set");
        }
        return "PONG " + input;
    }
    
    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Customer entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Customer entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Customer find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Customer> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
