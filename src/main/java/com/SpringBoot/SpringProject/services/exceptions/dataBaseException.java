package com.SpringBoot.SpringProject.services.exceptions;

public class dataBaseException extends RuntimeException{

    public dataBaseException(Long id){
        super("id "+id+" not found to remove");
    }


}
