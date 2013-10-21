package org.openrap.webservices.javaeewebservices.rest.supplement;

import java.io.Serializable;
import java.util.Set;
import javax.ejb.ApplicationException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ApplicationException(rollback = true,inherited = true)
public class BeanConstraintViolationException extends RuntimeException implements Serializable {

    public BeanConstraintViolationException(String message, Set<ConstraintViolation<?>> constraintViolations) {
        super(new ConstraintViolationException(message, constraintViolations));
    }

    public BeanConstraintViolationException(Set<ConstraintViolation<?>> constraintViolations) {
        super(new ConstraintViolationException(constraintViolations));
    }



}
