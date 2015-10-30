package com.the1rainmaker.microserviceproxy;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by the1rainmaker on 10/26/2015.
 */
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ProxyController.class);
    }
}