package com.nyu.edu.services.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Amey on 9/10/2016.
 */

@Path("/myFirstApp")
@Produces(MediaType.APPLICATION_JSON)
public class MyFirstAppResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;


    public MyFirstAppResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

/*    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }*/





}

/* Service Definition
 * /student/list
 * /student?name={name}
 * /student?id={id}
 *
 *
 * */
