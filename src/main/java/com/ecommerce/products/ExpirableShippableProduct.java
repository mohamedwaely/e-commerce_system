package com.ecommerce.products;

import java.time.LocalDate;

public class ExpirableShippableProduct extends ExpirableProduct implements shippable {
    String name;
    double weight;
    double price;
    int quantity;
    LocalDate expiryDate;

    @Override
    public String getName() {
        return name;
    }
    public ExpirableShippableProduct(String name, double weight, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
