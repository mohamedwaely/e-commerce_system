package com.ecommerce.products;

import java.util.Date;

public class ExpirableShippableProduct extends ExpirableProduct implements shippable {
    String name;
    double weight;
    double price;
    int quantity;
    Date expiryDate;

    public ExpirableShippableProduct(String name, double weight, double price, int quantity, Date expiryDate) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
