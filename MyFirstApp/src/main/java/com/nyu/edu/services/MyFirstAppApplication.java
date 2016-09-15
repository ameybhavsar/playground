package com.nyu.edu.services;

import com.nyu.edu.services.api.StudentUtil;
import com.nyu.edu.services.health.TemplateHealthCheck;
import com.nyu.edu.services.resources.MyFirstAppResource;
import com.nyu.edu.services.resources.StudentResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import java.util.EnumSet;

import static io.dropwizard.jersey.filter.AllowedMethodsFilter.ALLOWED_METHODS_PARAM;
import static org.eclipse.jetty.servlets.CrossOriginFilter.*;


/**
 * Created by Amey on 9/10/2016.
 */
public class MyFirstAppApplication extends Application<MyFirstAppConfiguration> {

    public static void main(String[] args) throws Exception {
        StudentUtil.initializeStudentList();
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

        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORSFilter", CrossOriginFilter.class);

        /**
         * Configuration for cross orgin header
         * */
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, environment.getApplicationContext().getContextPath() + "*");
        filter.setInitParameter(ALLOWED_METHODS_PARAM, "GET,PUT,POST,OPTIONS");
        filter.setInitParameter(ALLOWED_HEADERS_PARAM, "Origin, Content-Type, Accept");
        filter.setInitParameter(ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");

        final MyFirstAppResource resource = new MyFirstAppResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final StudentResource studentResource = new StudentResource();

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);

        environment.jersey().register(studentResource);
    }
}
