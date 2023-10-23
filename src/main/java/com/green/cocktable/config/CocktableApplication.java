package com.green.cocktable.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.green.cocktable")
public class CocktableApplication {

    public static void main(String[] args) {

        SpringApplication.run(CocktableApplication.class, args);

    }
}
