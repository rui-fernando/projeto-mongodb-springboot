package com.educandoweb.workshopmongo.resources;

import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.repositories.UserRepository;
import com.educandoweb.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repo;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/debug")
    public String debug() {
        return "Count: " + repo.count();
    }

    @GetMapping("/repo")
    public List<User> repoTest() {
        return repo.findAll();
    }

}
