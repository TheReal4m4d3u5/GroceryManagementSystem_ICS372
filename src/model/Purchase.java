package model;

import java.util.ArrayList;

public class Purchase {
    private int purchaseId;
    private Member member;
    private ArrayList<CartItem> purchasedItems;
    private double totalAmount;

    public Purchase(int purchaseId, Member member, ArrayList<CartItem> purchasedItems) {
        this.purchaseId = purchaseId;
        this.member = member;
        this.purchasedItems = new ArrayList<>(purchasedItems);
        this.totalAmount = calculateTotalAmount();
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public Member getMember() {
        return member;
    }

    public ArrayList<CartItem> getPurchasedItems() {
        return purchasedItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    private double calculateTotalAmount() {
        double total = 0;
        for (CartItem item : purchasedItems) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void displayPurchase() {
        System.out.println("Purchase ID: " + purchaseId);
        System.out.println("Member: " + member.getName());

        for (CartItem item : purchasedItems) {
            System.out.println(item);
        }

        System.out.println("Total Amount: $" + totalAmount);
    }
}