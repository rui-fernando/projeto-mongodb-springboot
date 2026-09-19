package com.educandoweb.workshopmongo.services;

import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.repositories.UserRepository;
import com.educandoweb.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){

        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
