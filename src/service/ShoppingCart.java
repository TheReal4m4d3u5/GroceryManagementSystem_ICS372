package service;

import java.util.ArrayList;
import model.CartItem;
import model.Product;

public class ShoppingCart {
    private ArrayList<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        addItem(product, 1);
    }

    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            return;
        }

        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public void removeItem(int productId) {
        items.removeIf(item -> item.getProduct().getId() == productId);
    }

    public void updateItemQuantity(int productId, int newQuantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == productId) {
                if (newQuantity > 0) {
                    item.setQuantity(newQuantity);
                } else {
                    removeItem(productId);
                }
                return;
            }
        }
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clearCart() {
        items.clear();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n--- Shopping Cart ---");
        for (CartItem item : items) {
            System.out.println(item);
        }
        System.out.printf("Total: $%.2f%n", calculateTotal());
    }
}