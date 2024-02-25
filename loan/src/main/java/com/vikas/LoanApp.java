package com.vikas;

import com.vikas.loan.DistributorFunction;
import com.vikas.loan.model.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
@EnableCassandraRepositories
public class LoanApp {

    public static void main(String[] args) {
        SpringApplication.run(LoanApp.class, args);
    }

    @Bean
    DistributorFunction distributorFunction(){
        return new DistributorFunction();
    }

    /*
    @Bean
    public Supplier<Message> producer() {
        return () -> new Message("Hello");
    }

    @Bean
    Consumer<Message> consumer(){
        return message -> System.out.println("Received" + message);
    }
    */
}