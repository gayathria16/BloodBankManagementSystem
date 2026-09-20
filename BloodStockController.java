package controller;

import java.util.List;

import model.BloodStock;
import service.BloodStockService;

public class BloodStockController {

    private BloodStockService bloodStockService;

    public BloodStockController() {
        bloodStockService =
                new BloodStockService();
    }

    // Add Blood Stock
    public void addStock(BloodStock stock) {

        if (bloodStockService.addStock(stock)) {

            System.out.println(
                    "Blood stock added successfully!"
            );

        } else {

            System.out.println(
                    "Failed to add blood stock."
            );
        }
    }

    // View All Blood Stock
    public void viewAllStock() {

        List<BloodStock> stocks =
                bloodStockService.getAllStock();

        if (stocks.isEmpty()) {

            System.out.println(
                    "No blood stock found."
            );

        } else {

            System.out.println(
                    "\n----- BLOOD STOCK -----"
            );

            for (BloodStock stock : stocks) {
                System.out.println(stock);
            }
        }
    }

    // Check Blood Availability
    public void checkAvailability(
            String bloodGroup) {

        BloodStock stock =
                bloodStockService
                .getStockByBloodGroup(bloodGroup);

        if (stock != null) {

            System.out.println(
                    "Blood Group: " +
                    stock.getBloodGroup()
            );

            System.out.println(
                    "Available Quantity: " +
                    stock.getQuantity()
            );

        } else {

            System.out.println(
                    "Blood group not available."
            );
        }
    }

    // Update Stock
    public void updateStock(BloodStock stock) {

        if (bloodStockService.updateStock(stock)) {

            System.out.println(
                    "Blood stock updated successfully!"
            );

        } else {

            System.out.println(
                    "Blood stock update failed."
            );
        }
    }

    // Delete Stock
    public void deleteStock(int stockId) {

        if (bloodStockService.deleteStock(stockId)) {

            System.out.println(
                    "Blood stock deleted successfully!"
            );

        } else {

            System.out.println(
                    "Blood stock not found."
            );
        }
    }
}