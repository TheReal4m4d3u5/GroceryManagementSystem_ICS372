package service;

import java.util.ArrayList;
import model.CartItem;
import model.Member;
import model.Product;
import model.Purchase;

public class GroceryStoreSystem {
    private Inventory inventory;
    private ShoppingCart cart;
    private ArrayList<Purchase> purchases;
    private Member member;
    private int nextPurchaseId;

    public GroceryStoreSystem() {
        inventory = new Inventory();
        cart = new ShoppingCart();
        purchases = new ArrayList<>();
        nextPurchaseId = 1;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void addProductToInventory(Product product) {
        inventory.addProduct(product);
    }

    public void displayInventory() {
        inventory.displayProducts();
    }

    public void addToCart(int productId, int quantity) {
        Product product = inventory.findProductById(productId);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Not enough stock available.");
            return;
        }

        cart.addItem(product, quantity);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeFromCart(int productId) {
        cart.removeItem(productId);
        System.out.println("Item removed from cart if it existed.");
    }

    public void updateCartItemQuantity(int productId, int newQuantity) {
        cart.updateItemQuantity(productId, newQuantity);
        System.out.println("Cart updated.");
    }

    public void viewCart() {
        cart.displayCart();
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        if (member == null) {
            System.out.println("No member is currently set.");
            return;
        }

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceStock(item.getQuantity());
        }

        Purchase purchase = new Purchase(nextPurchaseId++, member, cart.getItems());
        purchases.add(purchase);

        int pointsEarned = (int) purchase.getTotalAmount();
        member.addPoints(pointsEarned);

        System.out.println("\nCheckout successful.");
        purchase.displayPurchase();
        System.out.println("Points earned: " + pointsEarned);
        System.out.println("Total loyalty points: " + member.getLoyaltyPoints());

        cart.clearCart();
    }

    public void displayPurchaseHistory() {
        if (purchases.isEmpty()) {
            System.out.println("No purchases found.");
            return;
        }

        System.out.println("\n--- Purchase History ---");
        for (Purchase purchase : purchases) {
            purchase.displayPurchase();
            System.out.println();
        }
    }
}