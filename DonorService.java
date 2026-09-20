package service;

import java.util.List;

import dao.DonorDAO;
import model.Donor;

public class DonorService {

    private DonorDAO donorDAO;

    public DonorService() {
        donorDAO = new DonorDAO();
    }

    // Add Donor
    public boolean addDonor(Donor donor) {

        validateDonor(donor);

        return donorDAO.addDonor(donor);
    }

    // Get All Donors
    public List<Donor> getAllDonors() {

        return donorDAO.getAllDonors();
    }

    // Get Donor By ID
    public Donor getDonorById(int donorId) {

        if (donorId <= 0) {
            throw new IllegalArgumentException(
                    "Invalid donor ID"
            );
        }

        return donorDAO.getDonorById(donorId);
    }

    // Update Donor
    public boolean updateDonor(Donor donor) {

        validateDonor(donor);

        if (donor.getDonorId() <= 0) {
            throw new IllegalArgumentException(
                    "Invalid donor ID"
            );
        }

        return donorDAO.updateDonor(donor);
    }

    // Delete Donor
    public boolean deleteDonor(int donorId) {

        if (donorId <= 0) {
            throw new IllegalArgumentException(
                    "Invalid donor ID"
            );
        }

        return donorDAO.deleteDonor(donorId);
    }

    // Donor Validation
    private void validateDonor(Donor donor) {

        if (donor == null) {
            throw new IllegalArgumentException(
                    "Donor cannot be null"
            );
        }

        if (donor.getDonorName() == null ||
            donor.getDonorName().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Donor name is required"
            );
        }

        if (donor.getAge() < 18) {

            throw new IllegalArgumentException(
                    "Donor must be 18 or above"
            );
        }

        if (donor.getBloodGroup() == null ||
            donor.getBloodGroup().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Blood group is required"
            );
        }

        if (donor.getPhone() == null ||
            donor.getPhone().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Phone number is required"
            );
        }
    }
}
