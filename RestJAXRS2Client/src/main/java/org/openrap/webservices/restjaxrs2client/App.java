package org.openrap.webservices.restjaxrs2client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class App 
{

    public static void main(String []args){
        javax.ws.rs.client.Client c = ClientBuilder.newClient();

        //RaceBettingResult r = c.target("http://localhost:8080/JavaEEWebServices/rest").resolveTemplate("raceNumber", 2).queryParam("raceId", 1).queryParam("amountCents", 100).request(MediaType.APPLICATION_XML).get(RaceBettingResult.class);

        
        Integer r = c.target("http://localhost:8080/JavaEEWebServices/rest/customer/count").request(MediaType.TEXT_PLAIN).get(Integer.class);
        
        System.out.println(r.toString());
    
    }
}
