package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Donor;
import util.DBConnection;

public class DonorDAO {

    // 1. Add Donor
    public boolean addDonor(Donor donor) {

        String sql = "INSERT INTO donors "
                + "(donor_name, age, gender, blood_group, phone, email, address, last_donation_date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, donor.getDonorName());
            ps.setInt(2, donor.getAge());
            ps.setString(3, donor.getGender());
            ps.setString(4, donor.getBloodGroup());
            ps.setString(5, donor.getPhone());
            ps.setString(6, donor.getEmail());
            ps.setString(7, donor.getAddress());
            ps.setDate(8, donor.getLastDonationDate());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    // 2. Get All Donors
    public List<Donor> getAllDonors() {

        List<Donor> donors = new ArrayList<Donor>();

        String sql = "SELECT * FROM donors";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Donor donor = new Donor();

                donor.setDonorId(
                        rs.getInt("donor_id")
                );

                donor.setDonorName(
                        rs.getString("donor_name")
                );

                donor.setAge(
                        rs.getInt("age")
                );

                donor.setGender(
                        rs.getString("gender")
                );

                donor.setBloodGroup(
                        rs.getString("blood_group")
                );

                donor.setPhone(
                        rs.getString("phone")
                );

                donor.setEmail(
                        rs.getString("email")
                );

                donor.setAddress(
                        rs.getString("address")
                );

                donor.setLastDonationDate(
                        rs.getDate("last_donation_date")
                );

                donors.add(donor);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return donors;
    }


    // 3. Get Donor By ID
    public Donor getDonorById(int donorId) {

        String sql =
                "SELECT * FROM donors WHERE donor_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, donorId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Donor donor = new Donor();

                donor.setDonorId(
                        rs.getInt("donor_id")
                );

                donor.setDonorName(
                        rs.getString("donor_name")
                );

                donor.setAge(
                        rs.getInt("age")
                );

                donor.setGender(
                        rs.getString("gender")
                );

                donor.setBloodGroup(
                        rs.getString("blood_group")
                );

                donor.setPhone(
                        rs.getString("phone")
                );

                donor.setEmail(
                        rs.getString("email")
                );

                donor.setAddress(
                        rs.getString("address")
                );

                donor.setLastDonationDate(
                        rs.getDate("last_donation_date")
                );

                return donor;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // 4. Update Donor
    public boolean updateDonor(Donor donor) {

        String sql = "UPDATE donors SET "
                + "donor_name = ?, "
                + "age = ?, "
                + "gender = ?, "
                + "blood_group = ?, "
                + "phone = ?, "
                + "email = ?, "
                + "address = ?, "
                + "last_donation_date = ? "
                + "WHERE donor_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, donor.getDonorName());
            ps.setInt(2, donor.getAge());
            ps.setString(3, donor.getGender());
            ps.setString(4, donor.getBloodGroup());
            ps.setString(5, donor.getPhone());
            ps.setString(6, donor.getEmail());
            ps.setString(7, donor.getAddress());
            ps.setDate(8, donor.getLastDonationDate());
            ps.setInt(9, donor.getDonorId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    // 5. Delete Donor
    public boolean deleteDonor(int donorId) {

        String sql =
                "DELETE FROM donors WHERE donor_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, donorId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
}
