package service;

import java.util.List;

import dao.BloodRequestDAO;
import model.BloodRequest;

public class BloodRequestService {

    private BloodRequestDAO bloodRequestDAO;

    public BloodRequestService() {
        bloodRequestDAO = new BloodRequestDAO();
    }

    // Add Blood Request
    public boolean addRequest(
            BloodRequest request) {

        validateRequest(request);

        return bloodRequestDAO.addRequest(request);
    }

    // View All Requests
    public List<BloodRequest> getAllRequests() {

        return bloodRequestDAO.getAllRequests();
    }

    // Update Request Status
    public boolean updateRequestStatus(
            int requestId,
            String status) {

        if (requestId <= 0) {

            throw new IllegalArgumentException(
                    "Invalid request ID"
            );
        }

        if (status == null ||
            status.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Status is required"
            );
        }

        status = status.toUpperCase();

        if (!status.equals("PENDING") &&
            !status.equals("APPROVED") &&
            !status.equals("REJECTED")) {

            throw new IllegalArgumentException(
                    "Invalid status. Use PENDING, APPROVED or REJECTED"
            );
        }

        return bloodRequestDAO.updateRequestStatus(
                requestId,
                status
        );
    }

    // Delete Request
    public boolean deleteRequest(int requestId) {

        if (requestId <= 0) {

            throw new IllegalArgumentException(
                    "Invalid request ID"
            );
        }

        return bloodRequestDAO.deleteRequest(
                requestId
        );
    }

    // Validation
    private void validateRequest(
            BloodRequest request) {

        if (request == null) {

            throw new IllegalArgumentException(
                    "Blood request cannot be null"
            );
        }

        if (request.getPatientName() == null ||
            request.getPatientName().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Patient name is required"
            );
        }

        if (request.getHospitalName() == null ||
            request.getHospitalName().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Hospital name is required"
            );
        }

        if (request.getBloodGroup() == null ||
            request.getBloodGroup().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Blood group is required"
            );
        }

        if (request.getQuantity() <= 0) {

            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        if (request.getRequestDate() == null) {

            throw new IllegalArgumentException(
                    "Request date is required"
            );
        }

        request.setBloodGroup(
                request.getBloodGroup().toUpperCase()
        );
    }
}
