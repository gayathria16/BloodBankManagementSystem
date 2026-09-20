package controller;

import java.util.List;

import model.BloodRequest;
import service.BloodRequestService;

public class BloodRequestController {

    private BloodRequestService bloodRequestService;

    public BloodRequestController() {

        bloodRequestService =
                new BloodRequestService();
    }

    // Add Blood Request
    public void addRequest(
            BloodRequest request) {

        if (bloodRequestService.addRequest(request)) {

            System.out.println(
                    "Blood request added successfully!"
            );

        } else {

            System.out.println(
                    "Failed to add blood request."
            );
        }
    }

    // View All Requests
    public void viewAllRequests() {

        List<BloodRequest> requests =
                bloodRequestService
                .getAllRequests();

        if (requests.isEmpty()) {

            System.out.println(
                    "No blood requests found."
            );

        } else {

            System.out.println(
                    "\n----- BLOOD REQUESTS -----"
            );

            for (BloodRequest request : requests) {
                System.out.println(request);
            }
        }
    }

    // Update Request Status
    public void updateRequestStatus(
            int requestId,
            String status) {

        if (bloodRequestService
                .updateRequestStatus(
                        requestId,
                        status)) {

            System.out.println(
                    "Request status updated successfully!"
            );

        } else {

            System.out.println(
                    "Request not found."
            );
        }
    }

    // Delete Request
    public void deleteRequest(int requestId) {

        if (bloodRequestService
                .deleteRequest(requestId)) {

            System.out.println(
                    "Blood request deleted successfully!"
            );

        } else {

            System.out.println(
                    "Blood request not found."
            );
        }
    }
}