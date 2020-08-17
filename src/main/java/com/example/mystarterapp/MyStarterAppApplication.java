package com.example.mystarterapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This application connects to the psql database and performs crud operations for a Person
 */
@SpringBootApplication
public class MyStarterAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStarterAppApplication.class, args);
    }

}
