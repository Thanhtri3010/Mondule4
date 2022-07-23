package com.example.validatemusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.controller")
@ComponentScan(basePackages = "com.example.service")
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.model")
public class ValidateMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidateMusicApplication.class, args);
    }

}
