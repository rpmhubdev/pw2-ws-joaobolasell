package dev.rpmhub;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class Start {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy";
    }

    /* Quilômetro por hora para milhas por hora (1=0.621) – esse método (kmh2mih) deve consumir por POST e produzir dados em texto. */
    @POST
    @Path("/kmh2mih/{kmh}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String hello2(@PathParam("kmh") String kmh) {
        double kmhDouble = Double.parseDouble(kmh);
        double mih = kmhDouble / 1.609344;    
        
        return  kmh + " km/h = " + mih + " mih";


    }

    /* Nós para quilometro por hora (1=1.852) – esse método (no2kmh) deve consumir dados por GET e produzir dados em JSON. */

    @GET 
    @Path("/no2kmh/{nos}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public String no2kmh(@PathParam("nos") String nos) {
        double nosDouble = Double.parseDouble(nos);
        double kmh = nosDouble * 1.852;

        return "nós: " + nos + ", km/h: " + kmh + " ";
        
    }  


    


    









}
