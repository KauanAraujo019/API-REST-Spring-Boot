package com.SpringBoot.SpringProject.entities.enums;


public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code;

    OrderStatus(Integer code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }


    public static OrderStatus findById(Integer id){
        for (OrderStatus y : OrderStatus.values()){
            if (y.getCode() == id ){
                return y;
            }

        }

        throw new IllegalArgumentException("Invalid OrderStatus ID");

    }









}
