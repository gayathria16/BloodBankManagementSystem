package controller;

import java.util.List;

import model.Donor;
import service.DonorService;

public class DonorController {

    private DonorService donorService;

    public DonorController() {
        donorService = new DonorService();
    }

    // Add Donor
    public void addDonor(Donor donor) {

        if (donorService.addDonor(donor)) {

            System.out.println(
                    "Donor added successfully!"
            );

        } else {

            System.out.println(
                    "Failed to add donor."
            );
        }
    }

    // View All Donors
    public void viewAllDonors() {

        List<Donor> donors =
                donorService.getAllDonors();

        if (donors.isEmpty()) {

            System.out.println(
                    "No donors found."
            );

        } else {

            System.out.println(
                    "\n----- DONOR LIST -----"
            );

            for (Donor donor : donors) {
                System.out.println(donor);
            }
        }
    }

    // View Donor By ID
    public void viewDonor(int donorId) {

        Donor donor =
                donorService.getDonorById(donorId);

        if (donor != null) {

            System.out.println(donor);

        } else {

            System.out.println(
                    "Donor not found."
            );
        }
    }

    // Update Donor
    public void updateDonor(Donor donor) {

        if (donorService.updateDonor(donor)) {

            System.out.println(
                    "Donor updated successfully!"
            );

        } else {

            System.out.println(
                    "Donor update failed."
            );
        }
    }

    // Delete Donor
    public void deleteDonor(int donorId) {

        if (donorService.deleteDonor(donorId)) {

            System.out.println(
                    "Donor deleted successfully!"
            );

        } else {

            System.out.println(
                    "Donor not found."
            );
        }
    }
}