package com.SpringBoot.SpringProject.repositories;

import com.SpringBoot.SpringProject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
