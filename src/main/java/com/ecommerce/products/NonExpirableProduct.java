package com.ecommerce.products;

public class NonExpirableProduct extends Product {
    String name;
    double price;
    int quantity;

    public NonExpirableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isValidForPurchase(int Quantity) {
        return Quantity <= getQuantity();
    }
}
