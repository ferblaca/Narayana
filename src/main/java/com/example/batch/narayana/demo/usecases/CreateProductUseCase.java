package com.example.batch.narayana.demo.usecases;


import com.example.batch.narayana.demo.model.Product;

/**
 * The interface Create product use case.
 */
public interface CreateProductUseCase {

    /**
     * Create product mono.
     *
     * @param product the product
     * @return the product
     */
    Product createProduct(Product product);

}
