package com.service.note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.service.note.controller", "com.service.note.service"})
public class NoteTakingApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoteTakingApplication.class, args);
    }
}
