package org.openrap.webservices.domain;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XmlRootElement
public class ErrorHandlingRequest {
    private String errorMessage;
    private String exceptionName;

    public ErrorHandlingRequest(Throwable t) {
        errorMessage = t.getMessage();
        exceptionName = t.getClass().getName();
    }
    
}