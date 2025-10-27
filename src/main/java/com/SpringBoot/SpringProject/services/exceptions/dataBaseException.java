package com.SpringBoot.SpringProject.services.exceptions;

public class dataBaseException extends RuntimeException{

    public dataBaseException(Long id){
        super("id "+id+" not might to be remove");
    }


}
