package com.tap.foodapp.impl;

import java.util.HashMap;
import java.util.Map;

import com.tap.foodapp.model.CartItem;


public class CartItemDAOImpl {

    // The cart items, stored as a map where the key is the item ID and the value is the CartItem object
    private Map<Integer, CartItem> items;

    // Constructor to initialize the cart with an empty HashMap
    public CartItemDAOImpl() {
        this.items = new HashMap<>();
    }

    // Method to add an item to the cart
    public void addItem(CartItem item) {
        // Get the ID of the item being added
        int menuId = item.getMenuId();

        // If the item already exists in the cart, increase its quantity
        if (items.containsKey(menuId)) {
            CartItem existingItem = items.get(menuId); // Get the existing item
            // Update the quantity by adding the new item's quantity
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            // If the item doesn't exist, add the new item to the cart
            items.put(menuId, item);
        }
    }

    
    
    
    
    
    
    
    
    
    // Method to update the quantity of an item in the cart
    public void updateItem(int itemId, int quantity) {
        // Check if the item exists in the cart
        if (items.containsKey(itemId)) {
            if (quantity <= 0) {
                // If the quantity is zero or negative, remove the item from the cart
                items.remove(itemId);
            } else {
                // Otherwise, update the quantity of the item
                items.get(itemId).setQuantity(quantity);
            }
        }
    }

    // Method to remove an item from the cart
    public void removeItem(int itemId) {
        // Remove the item by its ID
        items.remove(itemId);
    }

    // Method to get all items currently in the cart
    public Map<Integer, CartItem> getItems() {
        return items; // Return the map of items
    }
}

