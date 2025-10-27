package com.SpringBoot.SpringProject.repositories;


import com.SpringBoot.SpringProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
