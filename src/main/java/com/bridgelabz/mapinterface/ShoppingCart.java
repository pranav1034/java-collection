package com.bridgelabz.mapinterface;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> priceMap = new HashMap<>(); // Product -> Price
    private Map<String, Integer> cart = new LinkedHashMap<>(); // Maintains order of added items
    private TreeMap<Double, List<String>> sortedItems = new TreeMap<>(); // Price -> Products

    // Add a product with its price
    public void addProduct(String product, double price) {
        priceMap.put(product, price);
    }

    // Add an item to the cart
    public void addToCart(String product, int quantity) {
        if (!priceMap.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Display the cart in order of addition
    public void displayCart() {
        System.out.println("\nCart (Order Added):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue() + " - $" + priceMap.get(entry.getKey()));
        }
    }

    // Display the cart sorted by price
    public void displayCartSortedByPrice() {
        sortedItems.clear();

        // Group products by price
        for (String product : cart.keySet()) {
            double price = priceMap.get(product);
            sortedItems.putIfAbsent(price, new ArrayList<>());
            sortedItems.get(price).add(product);
        }

        System.out.println("\nCart (Sorted by Price):");
        for (Map.Entry<Double, List<String>> entry : sortedItems.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - $" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Laptop", 800.00);
        cart.addProduct("Phone", 500.00);
        cart.addProduct("Headphones", 200.00);
        cart.addProduct("Keyboard", 100.00);

        // Adding items to the cart
        cart.addToCart("Phone", 1);
        cart.addToCart("Laptop", 2);
        cart.addToCart("Keyboard", 2);
        cart.addToCart("Headphones", 1);

        // Display cart in order added
        cart.displayCart();

        // Display cart sorted by price
        cart.displayCartSortedByPrice();
    }
}

