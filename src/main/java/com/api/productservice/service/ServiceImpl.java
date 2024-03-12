package com.api.productservice.service;

import com.api.productservice.dto.ProductRequest;
import com.api.productservice.model.Product;
import com.api.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServiceImpl implements ServiceInterface{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProduct() {
        log.info("retrieving products");
        productRepository.findAll();
        log.info("products retrieved");
        return productRepository.findAll();
    }

    @Override
    public void createProduct(ProductRequest productRequest) {
        log.info("creating Product");
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} created", product.getId());
    }
}
