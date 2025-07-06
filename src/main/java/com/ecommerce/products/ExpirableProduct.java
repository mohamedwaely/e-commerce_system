package com.ecommerce.products;

import java.time.LocalDate;

public class ExpirableProduct extends Product {
    LocalDate expiryDate;
    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate){
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isValidForPurchase(int Quantity) {
        LocalDate now = LocalDate.now();
        return (Quantity <= getQuantity()) && (now.isBefore(expiryDate) || now.isEqual(expiryDate));
    }
}
