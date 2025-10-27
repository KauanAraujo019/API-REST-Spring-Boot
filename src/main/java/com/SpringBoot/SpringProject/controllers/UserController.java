package com.SpringBoot.SpringProject.controllers;

import com.SpringBoot.SpringProject.entities.User;
import com.SpringBoot.SpringProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        return ResponseEntity.ok().body(userService.findAll());

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(userService.findById(id));

    }


    @PostMapping(value = "")
    public ResponseEntity<User> insert(@RequestBody User user){

        userService.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);


    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        userService.remove(id);

        return ResponseEntity.noContent().build();
    }




}
