package com.api.productservice.service;

import com.api.productservice.dto.ProductRequest;
import com.api.productservice.model.Product;

import java.util.List;

public interface ServiceInterface {

    List<Product> getProduct();
    void createProduct(ProductRequest productRequest);
}
