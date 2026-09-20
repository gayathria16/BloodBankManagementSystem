package org.anudip.bloodbank;

import java.sql.Date;
import java.util.Scanner;

import controller.BloodRequestController;
import controller.BloodStockController;
import controller.DonorController;

import model.BloodRequest;
import model.BloodStock;
import model.Donor;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);

    private static DonorController donorController =
            new DonorController();

    private static BloodStockController bloodStockController =
            new BloodStockController();

    private static BloodRequestController bloodRequestController =
            new BloodRequestController();

    public static void main(String[] args) {

        int choice;

        do {

            displayMainMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:
                        donorMenu();
                        break;

                    case 2:
                        bloodStockMenu();
                        break;

                    case 3:
                        bloodRequestMenu();
                        break;

                    case 4:
                        System.out.println(
                                "\nThank you for using Blood Bank Management System!"
                        );
                        break;

                    default:
                        System.out.println(
                                "\nInvalid choice. Please try again."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                        "\nError: " + e.getMessage()
                );
            }

        } while (choice != 4);

        scanner.close();
    }

    // ================= MAIN MENU =================

    private static void displayMainMenu() {

        System.out.println("\n====================================");
        System.out.println("     BLOOD BANK MANAGEMENT SYSTEM");
        System.out.println("====================================");
        System.out.println("1. Donor Management");
        System.out.println("2. Blood Stock Management");
        System.out.println("3. Blood Request Management");
        System.out.println("4. Exit");
        System.out.println("====================================");
        System.out.print("Enter your choice: ");
    }

    // ================= DONOR MENU =================

    private static void donorMenu() {

        int choice;

        do {

            System.out.println("\n----------- DONOR MANAGEMENT -----------");
            System.out.println("1. Add Donor");
            System.out.println("2. View All Donors");
            System.out.println("3. View Donor By ID");
            System.out.println("4. Update Donor");
            System.out.println("5. Delete Donor");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:
                        addDonor();
                        break;

                    case 2:
                        donorController.viewAllDonors();
                        break;

                    case 3:
                        viewDonor();
                        break;

                    case 4:
                        updateDonor();
                        break;

                    case 5:
                        deleteDonor();
                        break;

                    case 6:
                        System.out.println(
                                "Returning to main menu..."
                        );
                        break;

                    default:
                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }

        } while (choice != 6);
    }

    // Add Donor

    private static void addDonor() {

        System.out.println("\n----- ADD DONOR -----");

        System.out.print("Enter donor name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print(
                "Enter last donation date (YYYY-MM-DD): "
        );
        String date = scanner.nextLine();

        Date lastDonationDate =
                Date.valueOf(date);

        Donor donor = new Donor(
                name,
                age,
                gender,
                bloodGroup,
                phone,
                email,
                address,
                lastDonationDate
        );

        donorController.addDonor(donor);
    }

    // View Donor

    private static void viewDonor() {

        System.out.print("Enter donor ID: ");

        int donorId = scanner.nextInt();
        scanner.nextLine();

        donorController.viewDonor(donorId);
    }

    // Update Donor

    private static void updateDonor() {

        System.out.println("\n----- UPDATE DONOR -----");

        System.out.print("Enter donor ID: ");
        int donorId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter donor name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print(
                "Enter last donation date (YYYY-MM-DD): "
        );
        String date = scanner.nextLine();

        Date lastDonationDate =
                Date.valueOf(date);

        Donor donor = new Donor(
                name,
                age,
                gender,
                bloodGroup,
                phone,
                email,
                address,
                lastDonationDate
        );

        donor.setDonorId(donorId);

        donorController.updateDonor(donor);
    }

    // Delete Donor

    private static void deleteDonor() {

        System.out.print("Enter donor ID: ");

        int donorId = scanner.nextInt();
        scanner.nextLine();

        donorController.deleteDonor(donorId);
    }

    // ================= BLOOD STOCK MENU =================

    private static void bloodStockMenu() {

        int choice;

        do {

            System.out.println("\n-------- BLOOD STOCK MANAGEMENT --------");
            System.out.println("1. Add Blood Stock");
            System.out.println("2. View All Blood Stock");
            System.out.println("3. Check Blood Availability");
            System.out.println("4. Update Blood Stock");
            System.out.println("5. Delete Blood Stock");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:
                        addBloodStock();
                        break;

                    case 2:
                        bloodStockController.viewAllStock();
                        break;

                    case 3:
                        checkBloodAvailability();
                        break;

                    case 4:
                        updateBloodStock();
                        break;

                    case 5:
                        deleteBloodStock();
                        break;

                    case 6:
                        System.out.println(
                                "Returning to main menu..."
                        );
                        break;

                    default:
                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }

        } while (choice != 6);
    }

    // Add Blood Stock

    private static void addBloodStock() {

        System.out.println("\n----- ADD BLOOD STOCK -----");

        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        BloodStock stock =
                new BloodStock(
                        bloodGroup,
                        quantity
                );

        bloodStockController.addStock(stock);
    }

    // View Blood Availability

    private static void checkBloodAvailability() {

        System.out.print("Enter blood group: ");

        String bloodGroup =
                scanner.nextLine();

        bloodStockController.checkAvailability(
                bloodGroup
        );
    }

    // Update Blood Stock

    private static void updateBloodStock() {

        System.out.println("\n----- UPDATE BLOOD STOCK -----");

        System.out.print("Enter stock ID: ");
        int stockId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        BloodStock stock =
                new BloodStock(
                        bloodGroup,
                        quantity
                );

        stock.setStockId(stockId);

        bloodStockController.updateStock(stock);
    }

    // Delete Blood Stock

    private static void deleteBloodStock() {

        System.out.print("Enter stock ID: ");

        int stockId = scanner.nextInt();
        scanner.nextLine();

        bloodStockController.deleteStock(stockId);
    }

    // ================= BLOOD REQUEST MENU =================

    private static void bloodRequestMenu() {

        int choice;

        do {

            System.out.println("\n------- BLOOD REQUEST MANAGEMENT -------");
            System.out.println("1. Create Blood Request");
            System.out.println("2. View All Requests");
            System.out.println("3. Update Request Status");
            System.out.println("4. Delete Request");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:
                        createBloodRequest();
                        break;

                    case 2:
                        bloodRequestController
                                .viewAllRequests();
                        break;

                    case 3:
                        updateRequestStatus();
                        break;

                    case 4:
                        deleteBloodRequest();
                        break;

                    case 5:
                        System.out.println(
                                "Returning to main menu..."
                        );
                        break;

                    default:
                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }

        } while (choice != 5);
    }

    // Create Blood Request

    private static void createBloodRequest() {

        System.out.println("\n----- CREATE BLOOD REQUEST -----");

        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();

        System.out.print("Enter hospital name: ");
        String hospitalName = scanner.nextLine();

        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print(
                "Enter request date (YYYY-MM-DD): "
        );
        String date = scanner.nextLine();

        Date requestDate =
                Date.valueOf(date);

        BloodRequest request =
                new BloodRequest(
                        patientName,
                        hospitalName,
                        bloodGroup,
                        quantity,
                        requestDate,
                        "PENDING"
                );

        bloodRequestController.addRequest(request);
    }

    // Update Request Status

    private static void updateRequestStatus() {

        System.out.print("Enter request ID: ");

        int requestId = scanner.nextInt();
        scanner.nextLine();

        System.out.print(
                "Enter status (PENDING/APPROVED/REJECTED): "
        );

        String status = scanner.nextLine();

        bloodRequestController.updateRequestStatus(
                requestId,
                status
        );
    }

    // Delete Request

    private static void deleteBloodRequest() {

        System.out.print("Enter request ID: ");

        int requestId = scanner.nextInt();
        scanner.nextLine();

        bloodRequestController.deleteRequest(
                requestId
        );
    }
}
