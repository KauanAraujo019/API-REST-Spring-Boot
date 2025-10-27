package com.SpringBoot.SpringProject.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Long id){
        super("ID "+id+" NOT FOUND");
    }

}
