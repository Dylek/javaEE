package pl.edu.agh.soa.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Dylek on 2016-05-07.
 */
@Path("/images")
public class ImageService {

    private static final String img_file_path = "E:\\restresources\\dices.png";
    @GET
    @Path("dicesdownload")
    @Produces("image/png")
    public Response downloadImage(){
        File file= new File(img_file_path);
        Response.ResponseBuilder response=Response.ok((Object)file);
        response.header("Content-Disposition","attachment; filename=image_from_server.png");
        return  response.build();
    }

    @GET
    @Path("dices")
    @Produces("image/png")
    public Response getImage(){
        File file= new File(img_file_path);
        return Response.status(Response.Status.OK).entity(file).build();
    }
}
