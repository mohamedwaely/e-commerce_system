package com.ecommerce.products;

import java.util.Date;

public class ExpirableProduct extends Product {
    Date expiryDate;
    public ExpirableProduct(String name, double price, int quantity, Date expiryDate){
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isValidForPurchase(int Quantity) {
        Date currentDate = new Date();
        return currentDate.before(expiryDate) && (Quantity <= getQuantity());
    }
}
