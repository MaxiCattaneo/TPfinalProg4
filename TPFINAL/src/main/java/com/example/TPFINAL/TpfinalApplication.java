package com.example.TPFINAL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.TPFINAL.repositorios")
public class TpfinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpfinalApplication.class, args);
    }
}