package com.SpringBoot.SpringProject.repositories;

import com.SpringBoot.SpringProject.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
