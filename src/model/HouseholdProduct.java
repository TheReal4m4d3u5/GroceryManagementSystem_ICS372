package model;

public class HouseholdProduct extends Product {
    private String brand;
    private boolean hazardous;

    public HouseholdProduct(int id, String name, double price, int quantity,
                            String brand, boolean hazardous) {
        super(id, name, price, quantity);
        this.brand = brand;
        this.hazardous = hazardous;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isHazardous() {
        return hazardous;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHazardous(boolean hazardous) {
        this.hazardous = hazardous;
    }

    @Override
    public String getProductDetails() {
        return toString() +
               ", Brand: " + brand +
               ", Hazardous: " + hazardous;
    }
}