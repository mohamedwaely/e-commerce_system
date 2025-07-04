package com.ecommerce.cart;

import com.ecommerce.products.Product;
import com.ecommerce.products.shippable;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CarItem> items = new ArrayList<CarItem>();

    public void add(Product product, int quantity){
        if(quantity <=0 ){
            throw new IllegalArgumentException("Quantity should be greater than 0");
        }

        for(CarItem item : this.items){
            if(item.getProduct().equals(product)){
                if(product.isValidForPurchase(item.getQuantity()+quantity)){
                    item = new CarItem(product, item.getQuantity()+quantity);
                    return;
                }
                else {
                    throw new IllegalStateException("Cannot add more than available quantity due to unavailable product");
                }
            }
        }

        if(product.isValidForPurchase(quantity)){
            items.add(new CarItem(product, quantity));
        }
        else{
            throw new IllegalStateException("Unavailable quantity");
        }
    }

    public List<CarItem> getItems() {
        return new ArrayList<>(items);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public double subTotal(){
        return items.stream()
                .mapToDouble(CarItem::getTotalPrice)
                .sum();
    }

    public List<shippable> getShippableItems(){
        List <shippable> shippableItems = new ArrayList<>();
        for(CarItem item : items){
            if(item.getProduct() instanceof shippable){
                for(int i=0;i<item.getQuantity();i++){
                    shippableItems.add((shippable) item.getProduct());
                }
            }
        }
        return shippableItems;
    }

    public void clear(){
        items.clear();
    }
}
