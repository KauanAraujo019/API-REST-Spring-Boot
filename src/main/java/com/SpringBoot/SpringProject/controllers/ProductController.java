package com.SpringBoot.SpringProject.controllers;

import com.SpringBoot.SpringProject.entities.Product;
import com.SpringBoot.SpringProject.services.ProductService;
import com.sun.jdi.request.BreakpointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){

        return ResponseEntity.ok().body(productService.findAll());

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(productService.findById(id));

    }

}
