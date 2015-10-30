package com.the1rainmaker.microserviceproxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

//@RestController
@Component
@Path("/")
public class ProxyController {

    @Value("${com.the1rainmaker.microserviceproxy.targetUrlPrefix}")
    private String targetUrlPrefix;

    //@RequestMapping("/")
    @GET
    @Path("/ws/{seg: .*}")
    public String index(@Context HttpServletRequest httpRequest) {
        //return "Greetings from Spring Boot!";
        //System.out.println("urlPrefix!!!: " + urlPrefix);
        /** TODO: Refactor loggin here!!! */
        System.out.println("Index URI /ws+:" + httpRequest.getRequestURI());
        //System.out.println("URI:" + httpRequest.getRequestURI());

        //return new PassiveLocatorService().getData();
        return new PassiveLocatorService(targetUrlPrefix).doSuffixCall(httpRequest.getRequestURI());
    }
}
