package pl.edu.agh.soa.resources;

import pl.edu.agh.soa.resources.model.Worker;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dylek on 2016-05-07.
 */


@Path("/work")
public class JsonService {

    private List<Worker> workers=new ArrayList<Worker>(Arrays.asList(new Worker("Adam",500f,1),new Worker("Bartek",1500f,2),new Worker("Wawrzyniec",3000f,3) ));
    //private ArrayList<Worker> workers=new ArrayList<Worker>();

    @GET
    @Path("/workers")
    @Produces("application/json")
    public Response getWorkersJson(){
        return Response.status(Response.Status.OK).entity(workers).build();
    }

    @GET
    @Path("workers/{id}")
    @Produces("application/json")
    public Response getWorkerJson(@PathParam("id") int id){

        for (Worker temp:workers) {
            if(temp.getId()==id){
                return Response.status(Response.Status.OK).entity(temp).build();
              }
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }


    @POST
    @Path("/workers")
    @Produces("application/json")
    public Response createWorker(@QueryParam("name") String name,@QueryParam("salary") float salary ,@QueryParam("id") int id){
        Worker worker=new Worker(name,salary,id);
        if(getMeWorker(id)!=null){
            return Response.status(Response.Status.CONFLICT).entity(worker).build();
        }
        //workers.add(worker);
        workers.add(new Worker(name,salary,id));
        return Response.status(Response.Status.CREATED).entity(worker).build();

    }
    @DELETE
    @Path("/workers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteWorker(@PathParam("id") int id){
       for (Worker w:workers) {
            if(id==w.getId()){
                workers.remove(w);
                return Response.status(Response.Status.OK).build();
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();

    }


    @PUT
    @Path("/workers")
    public Response updateWorker(@QueryParam("name") String name,@QueryParam("salary") float salary,@QueryParam("id") int id){
       Worker temp=getMeWorker(id);
       if(workers.contains(temp)){
           temp.setName(name);
           temp.setSalary(salary);
           return Response.status(Response.Status.OK).build();
       }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }

    private Worker getMeWorker(int id){
        for (Worker temp:workers) {
            if(id == temp.getId()) {
                    return temp;
                }
        }
        return  null;
    }
    private void addWorker(Worker temp){
        workers.add(temp);
    }


}
