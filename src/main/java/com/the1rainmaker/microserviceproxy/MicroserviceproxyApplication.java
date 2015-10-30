package com.the1rainmaker.microserviceproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MicroserviceproxyApplication {

    /* public static void main(String[] args) {
        SpringApplication.run(MicroserviceproxyApplication.class, args);
    }
    */

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MicroserviceproxyApplication.class, args);

        /** TODO: Refactor loggin here!!! */
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }


}
