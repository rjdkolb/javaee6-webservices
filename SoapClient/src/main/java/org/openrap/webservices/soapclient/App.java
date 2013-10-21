package org.openrap.webservices.soapclient;

public class App 
{
    public static void main( String[] args )
    {
        SOAPWebServiceService service = new SOAPWebServiceService();
        
        String output = service.getSOAPWebServicePort().ping("INPUT ");
        System.out.println("Got output "+output);
    }
}
