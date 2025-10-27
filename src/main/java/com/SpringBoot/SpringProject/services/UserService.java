package com.SpringBoot.SpringProject.services;

import com.SpringBoot.SpringProject.entities.User;
import com.SpringBoot.SpringProject.repositories.UserRepository;
import com.SpringBoot.SpringProject.services.exceptions.ResourceNotFoundException;
import com.SpringBoot.SpringProject.services.exceptions.dataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public void remove(Long id){

        try {


            userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

            userRepository.deleteById(id);

        }catch (DataIntegrityViolationException e){
            throw new dataBaseException(id);
        }


    }

    public User update(Long id, User user){

        User obj = userRepository.getReferenceById(id);

        UpdateToObj(user, obj);

        userRepository.save(obj);

        return obj;

    }

    private void UpdateToObj(User user, User obj) {

        obj.setName(user.getName());
        obj.setEmail(user.getEmail());

    }


}
