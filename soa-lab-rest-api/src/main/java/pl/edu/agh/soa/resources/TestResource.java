package pl.edu.agh.soa.resources;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;
import  pl.edu.agh.soa.resources.model.*;
/**
 * Created by teacher on 28.04.2015.
 */
@Stateless
@Path("test")
public class TestResource {

    private static final Logger logger = Logger.getLogger("TestResource");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hello")
    public Response hello(@QueryParam("id") String id) {
        logger.info(String.format("hello invoked, id=%s", id));
        Student s = new Student("Jan", "Nowak", id);
        return Response.ok(s, MediaType.APPLICATION_JSON).build();
    }



}