package org.openrap.webservices.javaeewebservices.rest.supplement;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import lombok.extern.log4j.Log4j;

@Log4j
public class BeanValidationAppendixInterceptor {
    
    @Inject
    private Validator validator;
    
    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {

        if (validator == null){
            throw new IllegalArgumentException("Could not find validator, perhaps beans.xml not found");
        }
        log.info("validate bean "+context.getParameters());
        Set<ConstraintViolation<?>> violations = new LinkedHashSet<>();
        for (Object obj : context.getParameters()){
            violations.addAll(validator.validate(obj));
        }
        if (!violations.isEmpty()){
           throw new BeanConstraintViolationException(violations);
        }
        return context.proceed();
    }
}
