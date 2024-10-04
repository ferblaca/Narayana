package com.example.batch.narayana.demo.services;

import com.example.batch.narayana.demo.model.Product;
import com.example.batch.narayana.demo.repositories.ProductRepository;
import com.example.batch.narayana.demo.usecases.CreateProductUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
