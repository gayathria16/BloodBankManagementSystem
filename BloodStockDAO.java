package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BloodStock;
import util.DBConnection;

public class BloodStockDAO {

    // 1. Add Blood Stock
    public boolean addStock(BloodStock stock) {

        String sql =
                "INSERT INTO blood_stock (blood_group, quantity) "
                + "VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, stock.getBloodGroup());
            ps.setInt(2, stock.getQuantity());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    // 2. Get All Blood Stock
    public List<BloodStock> getAllStock() {

        List<BloodStock> stocks =
                new ArrayList<BloodStock>();

        String sql = "SELECT * FROM blood_stock";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                BloodStock stock =
                        new BloodStock();

                stock.setStockId(
                        rs.getInt("stock_id")
                );

                stock.setBloodGroup(
                        rs.getString("blood_group")
                );

                stock.setQuantity(
                        rs.getInt("quantity")
                );

                stocks.add(stock);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return stocks;
    }


    // 3. Get Stock By Blood Group
    public BloodStock getStockByBloodGroup(
            String bloodGroup) {

        String sql =
                "SELECT * FROM blood_stock "
                + "WHERE blood_group = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, bloodGroup);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                BloodStock stock =
                        new BloodStock();

                stock.setStockId(
                        rs.getInt("stock_id")
                );

                stock.setBloodGroup(
                        rs.getString("blood_group")
                );

                stock.setQuantity(
                        rs.getInt("quantity")
                );

                return stock;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // 4. Update Blood Stock
    public boolean updateStock(BloodStock stock) {

        String sql =
                "UPDATE blood_stock "
                + "SET quantity = ? "
                + "WHERE blood_group = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, stock.getQuantity());
            ps.setString(2, stock.getBloodGroup());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    // 5. Delete Blood Stock
    public boolean deleteStock(int stockId) {

        String sql =
                "DELETE FROM blood_stock "
                + "WHERE stock_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, stockId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
}
