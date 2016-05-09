package pl.edu.agh.soa.rest;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.File;
import java.util.*;
import pl.edu.agh.soa.resources.*;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 * Created by Dylek on 2016-05-07.
 */
@ApplicationPath("/mjrest")
public class RestService extends Application{
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classses=new HashSet<>();
        classses.add(TestResource.class);
        classses.add(JsonService.class);
        classses.add(PdfService.class);
        classses.add(ImageService.class);
        classses.add(TextService.class);
        classses.add(ProtocolBufferService.class);
        return classses;
    }

    @Override
    public Set<Object> getSingletons(){
        Set<Object> singletons= new HashSet<>();
        singletons.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
        return singletons;
    }
}
