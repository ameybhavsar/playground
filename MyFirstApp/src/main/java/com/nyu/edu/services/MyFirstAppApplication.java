package com.nyu.edu.services;

import com.nyu.edu.services.health.TemplateHealthCheck;
import com.nyu.edu.services.resources.MyFirstAppResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * Created by Amey on 9/10/2016.
 */
public class MyFirstAppApplication extends Application<MyFirstAppConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyFirstAppApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<MyFirstAppConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(MyFirstAppConfiguration configuration,
                    Environment environment) {
        final MyFirstAppResource resource = new MyFirstAppResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
