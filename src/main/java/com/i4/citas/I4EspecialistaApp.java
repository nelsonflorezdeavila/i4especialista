package com.i4.citas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class I4EspecialistaApp {

    public static void main(String[] args) {
        SpringApplication.run(I4EspecialistaApp.class, args);
    }

}
