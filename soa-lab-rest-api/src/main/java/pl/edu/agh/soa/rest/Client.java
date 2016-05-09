package pl.edu.agh.soa.rest;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.edu.agh.soa.resources.model.Worker;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dylek on 2016-05-09.
 */
public class Client {



    public static void main(String[] args ){
        String BASE_URL = "http://localhost:8080/soa-lab-rest-api/work/workers";

        DefaultHttpClient client = new DefaultHttpClient();

        client.getCredentialsProvider().setCredentials(
                new AuthScope("localhost", 8080),
                new UsernamePasswordCredentials("nowak", "password1!"));

        HttpGet httppost = new HttpGet(BASE_URL);

        System.out.println("executing request " + httppost.getRequestLine());
        HttpResponse response = null;
        try {
            response = client.execute(httppost);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            client.getConnectionManager().shutdown();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
/*
    public static void main(String[] args){

        ResteasyClient client= new ResteasyClientBuilder().build();
        ResteasyWebTarget target=client.target("http://localhost:8080/soa-lab-rest-api/work/workers");

        String response=target.request().get(String.class);
        String result = response.readEntity(String.class);


        getExample_one();

        postExample();
    }

    private static void getExample_one()
    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/soa-lab-rest-api/work/workers");
        Response response = target.request().get();
        //Read output in string format
        String value = response.readEntity(String.class);
        System.out.println(value);
        response.close();
    }



    private static void postExample()
    {
        Worker worker=new Worker("JAN",10000,10);


        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/soa-lab-rest-api/work/workers");
        Response response = target.request().post(Entity.entity(worker, "http://localhost:8080/soa-lab-rest-api/work/workers"));
        //Read output in string format
        System.out.println(response.getStatus());
        response.close();
    }*/
}
