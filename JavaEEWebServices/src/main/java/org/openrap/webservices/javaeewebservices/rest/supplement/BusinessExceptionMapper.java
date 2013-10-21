package org.openrap.webservices.javaeewebservices.rest.supplement;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.openrap.webservices.domain.ErrorHandlingRequest;


@Provider
public class BusinessExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception ex) {
        return Response.serverError().status(400).type(MediaType.APPLICATION_XML).entity(new ErrorHandlingRequest(ex)).build();
    }
}