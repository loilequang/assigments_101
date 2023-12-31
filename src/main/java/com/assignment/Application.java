package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"com.assignment"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.assignment")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
