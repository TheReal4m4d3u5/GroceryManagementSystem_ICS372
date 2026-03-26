package service;

import java.util.ArrayList;
import model.Product;

public class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product product : products) {
            System.out.println(product.getProductDetails());
        }
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}