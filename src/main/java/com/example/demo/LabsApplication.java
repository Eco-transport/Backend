package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/* @Configuration
@ComponentScan
@EnableAutoConfiguration
@EntityScan("com.example.demo.model") // path of the entity model
@EnableJpaRepositories("com.example.demo.controller") // path of jpa repository  */
@SpringBootApplication
public class LabsApplication{

    public static void main( String[] args ){
        SpringApplication.run( LabsApplication.class );
    }

}
