package com.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories
public class LoanApp {

    public static void main(String[] args) {
        SpringApplication.run(LoanApp.class, args);
    }

}