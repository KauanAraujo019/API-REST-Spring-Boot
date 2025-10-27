package com.SpringBoot.SpringProject.repositories;

import com.SpringBoot.SpringProject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
