package com.ecommerce.products;

public class ShippableProduct extends Product implements shippable {
    String name;
    double price;
    int quantity;
    double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isValidForPurchase(int Quantity) {
        return Quantity <= getQuantity();
    }
}
