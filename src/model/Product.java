package model;

public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
        }
    }

    public void reduceStock(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            
            
        }
    }

    public abstract String getProductDetails();

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Price: $" + price +
               ", Quantity: " + quantity;
    }
}