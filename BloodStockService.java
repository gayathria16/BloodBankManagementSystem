package service;

import java.util.List;

import dao.BloodStockDAO;
import model.BloodStock;

public class BloodStockService {

    private BloodStockDAO bloodStockDAO;

    public BloodStockService() {
        bloodStockDAO = new BloodStockDAO();
    }

    // Add Stock
    public boolean addStock(BloodStock stock) {

        validateStock(stock);

        return bloodStockDAO.addStock(stock);
    }

    // View All Stock
    public List<BloodStock> getAllStock() {

        return bloodStockDAO.getAllStock();
    }

    // Check Blood Availability
    public BloodStock getStockByBloodGroup(
            String bloodGroup) {

        if (bloodGroup == null ||
            bloodGroup.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Blood group is required"
            );
        }

        return bloodStockDAO.getStockByBloodGroup(
                bloodGroup.toUpperCase()
        );
    }

    // Update Stock
    public boolean updateStock(BloodStock stock) {

        validateStock(stock);

        return bloodStockDAO.updateStock(stock);
    }

    // Delete Stock
    public boolean deleteStock(int stockId) {

        if (stockId <= 0) {

            throw new IllegalArgumentException(
                    "Invalid stock ID"
            );
        }

        return bloodStockDAO.deleteStock(stockId);
    }

    // Validation
    private void validateStock(BloodStock stock) {

        if (stock == null) {

            throw new IllegalArgumentException(
                    "Blood stock cannot be null"
            );
        }

        if (stock.getBloodGroup() == null ||
            stock.getBloodGroup().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Blood group is required"
            );
        }

        if (stock.getQuantity() < 0) {

            throw new IllegalArgumentException(
                    "Quantity cannot be negative"
            );
        }

        stock.setBloodGroup(
                stock.getBloodGroup().toUpperCase()
        );
    }
}
