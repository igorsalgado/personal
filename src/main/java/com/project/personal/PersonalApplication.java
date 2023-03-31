package com.project.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.project.personal.model") // Habilita o uso de entidades
@ComponentScan(basePackages = {"com.*"}) // Habilita o uso de componentes
@EnableTransactionManagement // Habilita o gerenciamento de transações
@EnableJpaRepositories(basePackages = {"com.project.personal.repository"})
public class PersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalApplication.class, args);
    }

}
