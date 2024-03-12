package com.api.productservice.controller;

import com.api.productservice.dto.ProductRequest;
import com.api.productservice.model.Product;
import com.api.productservice.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class Controller {

    @Autowired
    private ServiceInterface serviceInterface;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProduct(){
       log.info("Initialising retrieving process");
       List<Product> products = serviceInterface.getProduct();
       log.info("Retrieving process finished");
       return products;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        log.info("Initialising create process");
        serviceInterface.createProduct(productRequest);
        log.info("Product created");
    }
}
