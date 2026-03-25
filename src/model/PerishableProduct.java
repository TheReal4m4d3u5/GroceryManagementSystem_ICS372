package model;

public class PerishableProduct extends Product {
    private String expirationDate;
    private boolean refrigerated;

    public PerishableProduct(int id, String name, double price, int quantity,
                             String expirationDate, boolean refrigerated) {
        super(id, name, price, quantity);
        this.expirationDate = expirationDate;
        this.refrigerated = refrigerated;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public boolean isRefrigerated() {
        return refrigerated;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setRefrigerated(boolean refrigerated) {
        this.refrigerated = refrigerated;
    }

    @Override
    public String getProductDetails() {
        return toString() +
               ", Expiration Date: " + expirationDate +
               ", Refrigerated: " + refrigerated;
    }
}