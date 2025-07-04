package com.ecommerce;

import com.ecommerce.cart.Cart;
import com.ecommerce.customer.Customer;
import com.ecommerce.products.*;
import com.ecommerce.service.CheckoutService;
import com.ecommerce.service.ShippingService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Date cheeseExpiry = Date.from(Instant.now().plus(10, ChronoUnit.DAYS));
        Product cheese = new ExpirableShippableProduct("cheese", 2, 100, 6, cheeseExpiry);
        Date biscuitsExpiry = Date.from(Instant.now().plus(15, ChronoUnit.DAYS));
        Product biscuit = new ExpirableShippableProduct("biscuit", 0.2, 50, 10, biscuitsExpiry);
        Product TV = new ShippableProduct("TV", 150, 2, 25);
        Product scratchCard = new NonExpirableProduct("scratch Card ", 25, 3);

        Customer ali = new Customer("aliloka", 150000);
        Cart cart = new Cart();


        // Normal Checkout
        try{
            cart.add(cheese, 2);
            cart.add(biscuit, 3);
            cart.add(scratchCard, 1);
            cart.add(TV, 1);
        }
        catch(Exception e){
            out.println("Error: " +  e.getMessage());
        }
        ShippingService shippingService = new ShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService);

        try{
            checkoutService.checkout(ali, cart);
        }
        catch(Exception e){
            out.println("Error: " +  e.getMessage());
        }

        out.println("=================================================================");

        // Insufficient Balance
        Customer ahmed = new Customer("ahmed", 150);
        try{
            checkoutService.checkout(ahmed, cart);
        }
        catch(Exception e){
            out.println("Error: " +  e.getMessage());
        }

        out.println("=================================================================");

        // Empty Cart
        cart.clear();
        try{
            checkoutService.checkout(ali, cart);
        }
        catch(Exception e){
            out.println("Error: " +  e.getMessage());
        }

        out.println("=================================================================");

        // Expired Product
        Date expiredCheeseExpiry = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
        Product expiredCheese = new ExpirableProduct("cheese", 100, 2, expiredCheeseExpiry);
        cart.clear();
        cart.add(expiredCheese, 1);
        try{
            checkoutService.checkout(ali, cart);
        }
        catch(Exception e){
            out.println("Error: " +  e.getMessage());
        }

        out.println("=================================================================");

       //  Out of Stock
        cart.clear();
        cart.add(TV, 3);
        try{
            checkoutService.checkout(ali, cart);
        }
        catch(Exception e){
            out.println("Error: " +  e.getMessage());
        }




    }
}