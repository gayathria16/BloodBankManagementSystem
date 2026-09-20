package model;

public class BloodStock {

    private int stockId;
    private String bloodGroup;
    private int quantity;

    // Default constructor
    public BloodStock() {
    }

    // Parameterized constructor
    public BloodStock(String bloodGroup, int quantity) {

        this.bloodGroup = bloodGroup;
        this.quantity = quantity;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {

        return "Stock ID: " + stockId
                + ", Blood Group: " + bloodGroup
                + ", Quantity: " + quantity;
    }
}
