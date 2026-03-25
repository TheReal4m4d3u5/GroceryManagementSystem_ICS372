package model;

public class Member extends Person {
    private int loyaltyPoints;
    private String membershipLevel;

    public Member(int id, String name, int loyaltyPoints, String membershipLevel) {
        super(id, name);
        this.loyaltyPoints = loyaltyPoints;
        this.membershipLevel = membershipLevel;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    public void redeemPoints(int points) {
        if (points > 0 && points <= loyaltyPoints) {
            loyaltyPoints -= points;
        }
    }
}