package Playground;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class RestAPI {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Log.debug("Hello from Quarkus REST");
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/error")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello_error() {

        try {
            Log.error("Error from Quarkus REST");
            int i = 1 / 0;

            return "Error from Quarkus REST";
        } catch (Exception e) {
            Log.error(e.getMessage());
            throw new WebApplicationException("This throws an error", 500);
        }

    }

    @GET
    @Path("/long")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello_long() {
        Log.error("Long from Quarkus REST");

        int i = 0;
        while (i < Integer.MAX_VALUE) {
            i++;
        }
        // throw new WebApplicationException("This throws an error", 500);
        return "Hello from Quarkus REST: " + i;
    }
}
