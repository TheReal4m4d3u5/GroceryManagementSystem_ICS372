package app;

import java.util.Scanner;
import model.HouseholdProduct;
import model.Member;
import model.PerishableProduct;
import service.GroceryStoreSystem;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GroceryStoreSystem system = new GroceryStoreSystem();

        system.setMember(new Member(1, "Avery", 0, "Gold"));

        system.addProductToInventory(new PerishableProduct(101, "Milk", 4.99, 10, "2026-04-01", true));
        system.addProductToInventory(new PerishableProduct(102, "Eggs", 3.49, 20, "2026-03-30", true));
        system.addProductToInventory(new HouseholdProduct(201, "Dish Soap", 5.99, 15, "Dawn", false));
        system.addProductToInventory(new HouseholdProduct(202, "Paper Towels", 12.99, 8, "Bounty", false));

        boolean running = true;

        while (running) {
            System.out.println("\n--- Grocery Management System ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Item from Cart");
            System.out.println("5. Update Cart Item Quantity");
            System.out.println("6. Checkout");
            System.out.println("7. View Purchase History");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayInventory();
                    break;

                case 2:
                    system.displayInventory();
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    system.addToCart(productId, quantity);
                    break;

                case 3:
                    system.viewCart();
                    break;

                case 4:
                    system.viewCart();
                    System.out.print("Enter product ID to remove: ");
                    int removeId = scanner.nextInt();
                    system.removeFromCart(removeId);
                    break;

                case 5:
                    system.viewCart();
                    System.out.print("Enter product ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    system.updateCartItemQuantity(updateId, newQuantity);
                    break;

                case 6:
                    system.checkout();
                    break;

                case 7:
                    system.displayPurchaseHistory();
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}