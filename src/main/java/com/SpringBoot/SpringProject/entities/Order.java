package com.SpringBoot.SpringProject.entities;

import com.SpringBoot.SpringProject.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment;

    @Enumerated
    private Integer orderStatus;


    public Order(){

    }

    public Order(Long id, Instant moment, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.findById(orderStatus);

    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }

        throw new IllegalArgumentException("orderStatus Invalid");

    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
