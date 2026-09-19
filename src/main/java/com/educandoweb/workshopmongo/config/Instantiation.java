package com.educandoweb.workshopmongo.config;

import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Conectado ao Banco: " + mongoTemplate.getDb().getName());

        System.out.println("--- QUANTIDADE ANTES DO DELETE: " + userRepository.count() + " ---");

        userRepository.deleteAll();

        System.out.println("--- QUANTIDADE APÓS DELETE: " + userRepository.count() + " ---");

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User rui = new User(null, "Rui Fernando", "rui@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, rui));
        System.out.println("--- DADOS SALVOS COM SUCESSO PELO SPRING! ---");
    }
}