package com.educandoweb.workshopmongo;

import com.educandoweb.workshopmongo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkshopmongoApplication {

    public static void main(String[] args) {

        SpringApplication.run(WorkshopmongoApplication.class, args);

    }

    @Bean
    CommandLineRunner runner(UserRepository repository) {
        return args -> {
            System.out.println("--- TOTAL DE USUÁRIOS NO MONGO: " + repository.count());
            repository.findAll().forEach(u -> System.out.println(u.getName()));
        };
    }

}
