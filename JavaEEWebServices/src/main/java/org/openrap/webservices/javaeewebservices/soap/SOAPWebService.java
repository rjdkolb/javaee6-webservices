package org.openrap.webservices.javaeewebservices.soap;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.openrap.webservices.domain.Customer;
import org.openrap.webservices.javaeewebservices.AbstractFacade;

@WebService
@Stateless
public class SOAPWebService extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "JavaEEWebServices")
    private EntityManager em;
    public SOAPWebService() {
        super(Customer.class);
    }

    @WebMethod
    public String ping(String input) {
        if ("ERROR".equals(input)){
            throw new RuntimeException("ERROR, input set");
        }
        return "PONG " + input;
    }

    @Override
    @WebMethod
    public void create(Customer entity) {
        super.create(entity);
    }

    @WebMethod
    public void edit( Long id, Customer entity) {
        super.edit(entity);
    }

    @WebMethod
    public void remove( Long id) {
        super.remove(super.find(id));
    }

    @WebMethod
    public Customer find( Long id) {
        return super.find(id);
    }

    @WebMethod
    public List<Customer> findAll() {
        return super.findAll();
    }

    @WebMethod
    public List<Customer> findRange(Integer from,  Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @WebMethod
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
