package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BloodRequest;
import util.DBConnection;

public class BloodRequestDAO {

    // 1. Add Blood Request
    public boolean addRequest(BloodRequest request) {

        String sql =
                "INSERT INTO blood_requests "
                + "(patient_name, hospital_name, blood_group, "
                + "quantity, request_date, status) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, request.getPatientName());
            ps.setString(2, request.getHospitalName());
            ps.setString(3, request.getBloodGroup());
            ps.setInt(4, request.getQuantity());
            ps.setDate(5, request.getRequestDate());
            ps.setString(6, request.getStatus());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    // 2. Get All Blood Requests
    public List<BloodRequest> getAllRequests() {

        List<BloodRequest> requests =
                new ArrayList<BloodRequest>();

        String sql = "SELECT * FROM blood_requests";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                BloodRequest request =
                        new BloodRequest();

                request.setRequestId(
                        rs.getInt("request_id")
                );

                request.setPatientName(
                        rs.getString("patient_name")
                );

                request.setHospitalName(
                        rs.getString("hospital_name")
                );

                request.setBloodGroup(
                        rs.getString("blood_group")
                );

                request.setQuantity(
                        rs.getInt("quantity")
                );

                request.setRequestDate(
                        rs.getDate("request_date")
                );

                request.setStatus(
                        rs.getString("status")
                );

                requests.add(request);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return requests;
    }


    // 3. Update Request Status
    public boolean updateRequestStatus(
            int requestId,
            String status) {

        String sql =
                "UPDATE blood_requests "
                + "SET status = ? "
                + "WHERE request_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, requestId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    // 4. Delete Blood Request
    public boolean deleteRequest(int requestId) {

        String sql =
                "DELETE FROM blood_requests "
                + "WHERE request_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, requestId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
}