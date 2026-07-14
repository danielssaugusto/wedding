package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "org.example.model") // <-- Force o escaneamento da pasta model
public class WeddingApplication {

    static void main(String[] args) {
        SpringApplication.run(WeddingApplication.class, args);
    }
}
