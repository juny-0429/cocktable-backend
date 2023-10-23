package com.green.cocktable.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.green.cocktable")
@EnableJpaRepositories(basePackages = "com.green.cocktable")
public class JpaConfiguration {
}
