package com.example.batch.narayana.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * The type Product.
 */
@Table
public class Product {

    @Id
    private Long id;

    private String name;

    private Double price;

    private Integer discount;

    public Product() {
    }

    public Product(String name, Double price, Integer discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return this.price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(final Double price) {
        this.price = price;
    }

    /**
     * Gets discount.
     *
     * @return the discount
     */
    public Integer getDiscount() {
        return this.discount;
    }

    /**
     * Sets discount.
     *
     * @param discount the discount
     */
    public void setDiscount(final Integer discount) {
        this.discount = discount;
    }

}
