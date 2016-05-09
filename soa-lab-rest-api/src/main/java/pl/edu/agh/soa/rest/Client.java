package pl.edu.agh.soa.rest;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;

/**
 * Created by Dylek on 2016-05-09.
 */
public class Client {

    ResteasyClient client= new ResteasyClientBuilder().build();
    ResteasyWebTarget target=client.target("http://localhost:8080/soa-lab-rest-api/work/workers");

    String response=target.request().get(String.class);
    String result=response.readEntity(String.class);
}
