package com.SpringBoot.SpringProject.test;

import com.SpringBoot.SpringProject.entities.User;
import com.SpringBoot.SpringProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class testDataBase implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Kauan Araujo", "araujo@gmail", "9909099", "0000001");
        User user2 = new User(null, "Jose Generic", "jose@gmail", "8808088", "0000002");
        User user3 = new User(null, "Pedro Generic", "pedro@gmail", "7707077", "0000003");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

    }
}
