package com.nyu.edu.services.health;


import com.codahale.metrics.health.HealthCheck;

/**
 * Created by Amey on 9/10/2016.
 */

public class TemplateHealthCheck extends HealthCheck {

    public TemplateHealthCheck(String template) {
    }

    @Override
    protected Result check() throws Exception {
        return null;
    }
}