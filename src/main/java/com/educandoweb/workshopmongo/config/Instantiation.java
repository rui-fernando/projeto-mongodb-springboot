package com.educandoweb.workshopmongo.config;

import com.educandoweb.workshopmongo.domain.Post;
import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.repositories.PostRepository;
import com.educandoweb.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Conectado ao Banco: " + mongoTemplate.getDb().getName());

        System.out.println("--- QUANTIDADE ANTES DO DELETE: " + userRepository.count() + " ---");

        userRepository.deleteAll();
        postRepository.deleteAll();

        System.out.println("--- QUANTIDADE APÓS DELETE: " + userRepository.count() + " ---");

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User rui = new User(null, "Rui Fernando", "rui@gmail.com");



        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Post post1 = new Post(null, sdf.parse("21/03/2026"), "Partiu viagem",
                "Vou viajar para Jacumã. Abraços!", rui);

        Post post2 = new Post(null, sdf.parse("25/03/2026"), "Bom dia",
                "Acordei feliz hoje.", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, rui));
        postRepository.saveAll(Arrays.asList(post1, post2));

        System.out.println("--- DADOS SALVOS COM SUCESSO PELO SPRING! ---");
    }
}