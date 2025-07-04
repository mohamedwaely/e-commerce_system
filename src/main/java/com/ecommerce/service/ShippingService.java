package com.ecommerce.service;

import com.ecommerce.products.shippable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class ShippingService {
    public void shipItems(List<shippable> items){
        if(items.isEmpty()){
            return;
        }

        out.println("** Shipping Items Notice **");
        double totalWeight=0;

        Map<String, Integer> itemCounts = new HashMap<String, Integer>();
        Map<String, Double> itemWeights=new HashMap<String, Double>();
        for(shippable item:items){
            itemCounts.put(item.getName(), itemCounts.getOrDefault(item.getName(), 0) + 1);
            itemWeights.put(item.getName(), itemWeights.getOrDefault(item.getName(), 0.0)+ item.getWeight());
            totalWeight += item.getWeight();
        }


        for(var it:itemCounts.entrySet()){
            out.print(it.getKey() + " x  " + it.getValue());
            out.printf("  =>   %.1fkg%n", itemWeights.get(it.getKey()));
        }
        out.println("----------------------");



        out.printf("Total package weight %.1fkg%n", totalWeight);
        out.println("----------------------");
    }

}
