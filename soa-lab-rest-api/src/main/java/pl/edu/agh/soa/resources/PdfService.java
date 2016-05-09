package pl.edu.agh.soa.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * Created by Dylek on 2016-05-07.
 */
@Path("/pdfs")
public class PdfService {

    private static final String pdf_file_path = "E:\\restresources\\";

    @GET
    @Path("downloads/restformaty")
    @Produces("application/pdf")
    public Response downloadPDF(){
        File file=new File(pdf_file_path);
        Response.ResponseBuilder response=Response.ok((Object)file);
        response.header("Content-Disposition","attachment; filename=pdf_from_server.pdf");
        return  response.build();

    }
    @GET
    @Path("get/{param}")
    @Produces("application/pdf")
    public Response getPDF(@PathParam("param") String str){
        File file= new File(pdf_file_path+str);
        return Response.status(Response.Status.OK).entity(file).build();
    }
}
