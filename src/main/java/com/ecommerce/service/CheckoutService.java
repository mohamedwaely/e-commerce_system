package com.ecommerce.service;

import com.ecommerce.cart.CarItem;
import com.ecommerce.cart.Cart;
import com.ecommerce.customer.Customer;
import com.ecommerce.products.Product;
import com.ecommerce.products.shippable;

import java.util.List;

import static java.lang.System.out;

public class CheckoutService {
    private ShippingService shippingService;
    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) {
        if(cart.isEmpty()){
            throw new IllegalStateException("Cannot checkout with empty cart");
        }

        for(CarItem item : cart.getItems()){
            if(!item.getProduct().isValidForPurchase(item.getQuantity())){
                throw new IllegalStateException("Product " + item.getProduct().getName() +
                        " is either out of stock or expired");
            }
        }

        double subTotal= cart.subTotal();
        double shippingFees=shippingFee(cart);
        double total = subTotal + shippingFees;

        if(customer.getBalance() < total){
            throw new IllegalStateException("Insufficient balance for checkout");
        }

        List<shippable> shippableItems = cart.getShippableItems();
        if(!shippableItems.isEmpty()){
            shippingService.shipItems(shippableItems);
        }

        customer.deductBalance(total);

       for(CarItem item : cart.getItems()){
           Product product = item.getProduct();
           product.setQuantity(product.getQuantity() - item.getQuantity());
       }

       printReceipt(cart, subTotal, shippingFees, total, customer);

       cart.clear();

    }

    private double shippingFee(Cart cart) {
        // $5 per shippable item
        return cart.getShippableItems().size() * 5;
    }

    private void printReceipt(Cart cart, double subtotal, double shippingFee, double total, Customer customer) {
        out.println("** Checkout receipt **");

        // items
        for (CarItem item : cart.getItems()) {
            out.printf("%dx %s\t%.0f L.E%n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getTotalPrice());
        }

        // totals
        out.println("----------------------");
        out.printf("Subtotal\t%.0f L.E%n", subtotal);
        out.printf("Shipping\t%.0f L.E%n", shippingFee);
        out.printf("Amount\t\t%.0f L.E%n", total);
        out.printf("Remaining balance: %.0f L.E%n", customer.getBalance());
    }
}
