package pl.edu.agh.soa.resources;

import pl.edu.agh.soa.resources.model.Worker;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dylek on 2016-05-07.
 */
@Path("/workers")
public class JsonService {

    private List<Worker> workers=new ArrayList<Worker>(Arrays.asList(new Worker("Adam",500f,1),new Worker("Bartek",1500f,2),new Worker("Wawrzyniec",3000f,3) ));


    @GET
    @Path("/getWorkers")
    @Produces("application/json")
    public Response getWorkersJson(){
        return Response.status(Response.Status.OK).entity(workers).build();
    }

    @GET
    @Path("worker/{id}")
    @Produces("application/json")
    public Response getWorkerJson(@PathParam("id") int id){
        boolean change=false;
        Worker r=null;
        for (Worker temp:workers) {
            if(temp.getId()==id){
                r=temp;
                change=true;
                break;
            }
        }
        if(change){
            return Response.status(Response.Status.OK).entity(r).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).entity(r).build();
        }

    }


    @POST
    @Path("/postWorker")
  //  @Produces("application/json")
    public Response createWorker(@QueryParam("name") String name,@QueryParam("salary") float salary ,@QueryParam("id") int id){
        Worker worker= new Worker(name,salary,id);

        if(getMeWorker(id)!=null){
            return Response.status(Response.Status.CONFLICT).entity(worker).build();
        }
        workers.add(worker);
        return Response.status(Response.Status.CREATED).entity(worker).build();

    }
    @DELETE
    @Path("/deleteWorker/{id}")
    public Response deleteWorker(@PathParam("id") int id){
       Worker temp=getMeWorker(id);

        if(workers.contains(temp)){
            workers.remove(temp);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }


    @PUT
    @Path("/putWorker")
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
      /* @PATCH
    @Path("promoteWorker")
    public Response promoteWorker(String id){
        boolean deleted=false;
        for (Worker temp:workers) {
            if(temp.getId()==id){
                deleted=workers.remove(temp);
                break;
            }
        }
        if(deleted){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
    }*/
}
