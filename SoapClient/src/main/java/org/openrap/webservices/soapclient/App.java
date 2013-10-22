package org.openrap.webservices.soapclient;

public class App 
{
    public static void main( String[] args )
    {
        SOAPWebServiceService service = new SOAPWebServiceService();
        SOAPWebService ws = service.getSOAPWebServicePort();
        String output = ws.ping("INPUT ");
        System.out.println("Got output "+output);

    }
}
