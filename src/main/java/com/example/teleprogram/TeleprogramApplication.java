package com.example.teleprogram;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan ("com.example.teleprogram")
public class TeleprogramApplication {


    public static void main(String[] args) {
        SpringApplication.run (TeleprogramApplication.class, args);

    }


}
