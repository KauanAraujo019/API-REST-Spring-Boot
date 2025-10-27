package com.SpringBoot.SpringProject.entities;

import com.SpringBoot.SpringProject.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment;
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private User user;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order(){

    }

    public Order(Long id, Instant moment, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
    }


    public Double getTotal(){
        Double som = 0.0;

        for (OrderItem value : items){

            som += value.getSubTotal();

        }

        return som;

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
        else{

            throw new IllegalArgumentException("orderStatus Invalid");

        }


    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Set<OrderItem> getItems() {
        return items;
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
