package com.ecommerce.customer;

public class Customer {
    String username;
    double balance;

    public Customer(String username,double balance) {
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }
    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        if(amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }
}
