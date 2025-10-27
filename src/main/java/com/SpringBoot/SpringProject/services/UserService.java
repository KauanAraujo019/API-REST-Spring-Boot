package com.SpringBoot.SpringProject.services;

import com.SpringBoot.SpringProject.entities.User;
import com.SpringBoot.SpringProject.repositories.UserRepository;
import com.SpringBoot.SpringProject.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){

        return userRepository.findAll();

    }

    public User findById(Long id){

        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public void insert(User user){

        userRepository.save(user);

    }


}
