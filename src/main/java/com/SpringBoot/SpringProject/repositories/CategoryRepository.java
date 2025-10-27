package com.SpringBoot.SpringProject.repositories;

import com.SpringBoot.SpringProject.entities.Category;
import com.SpringBoot.SpringProject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
