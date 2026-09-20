package model;

import java.sql.Date;

public class Donor {

    private int donorId;
    private String donorName;
    private int age;
    private String gender;
    private String bloodGroup;
    private String phone;
    private String email;
    private String address;
    private Date lastDonationDate;

    // Default constructor
    public Donor() {
    }

    // Parameterized constructor
    public Donor(String donorName, int age, String gender,
                 String bloodGroup, String phone,
                 String email, String address,
                 Date lastDonationDate) {

        this.donorName = donorName;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.lastDonationDate = lastDonationDate;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(Date lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    @Override
    public String toString() {

        return "Donor ID: " + donorId
                + ", Name: " + donorName
                + ", Age: " + age
                + ", Gender: " + gender
                + ", Blood Group: " + bloodGroup
                + ", Phone: " + phone
                + ", Email: " + email
                + ", Address: " + address
                + ", Last Donation Date: " + lastDonationDate;
    }
}
