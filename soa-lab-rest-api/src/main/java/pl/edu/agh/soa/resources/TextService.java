package pl.edu.agh.soa.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Dylek on 2016-05-07.
 */
@Path("/texts")
public class TextService {

    private static final String log_file_path = "E:\\restresources\\";
    private ArrayList<String> strings=new ArrayList<String>();


    @GET
    @Path("/file")
    @Produces("text/plain")
    public Response getLog(){
        File file= new File(log_file_path);
        Response.ResponseBuilder response=Response.ok((Object)file);
        response.header("Content-Disposition","attachment; filename=tekst.txt");
        return  response.build();
    }
    @GET
    @Path("files/{param}")
    @Produces("text/plain")
    public Response getText(@PathParam("param") String name){
        File file= new File(log_file_path+name);
        return Response.status(Response.Status.OK).entity(file).build();
    }

    @GET
    @Path("/getAll")
    @Produces("text/plain")
    public Response getWorkersJson(){
        strings.add("Start");
        return Response.status(Response.Status.OK).entity(strings).build();
    }

    @POST
    @Path("posttext")
    @Consumes("text/plain")
    public Response postString( String str )
    {
        String output = str;
        strings.add(str);
        strings.add(output);
        return Response.status(Response.Status.OK).entity(output).build();
    }

}
