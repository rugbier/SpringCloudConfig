package com.example.spring.cloud.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClient {

    @Value("${user.role}")
    private String role;

    @Value("${user.permission}")
    private String permission;

    @Value("${general.server}")
    private String server;


    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }

    @GetMapping(value = "/whoami/{username}",
                produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello! You're %s and you'll become a(n) %s...\nThe user permission are %s\nThe server is located in %s", username, role, permission, server);
    }
}
