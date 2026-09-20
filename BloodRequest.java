package model;

import java.sql.Date;

public class BloodRequest {

    private int requestId;
    private String patientName;
    private String hospitalName;
    private String bloodGroup;
    private int quantity;
    private Date requestDate;
    private String status;

    // Default constructor
    public BloodRequest() {
    }

    // Parameterized constructor
    public BloodRequest(String patientName,
                        String hospitalName,
                        String bloodGroup,
                        int quantity,
                        Date requestDate,
                        String status) {

        this.patientName = patientName;
        this.hospitalName = hospitalName;
        this.bloodGroup = bloodGroup;
        this.quantity = quantity;
        this.requestDate = requestDate;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Request ID: " + requestId
                + ", Patient Name: " + patientName
                + ", Hospital Name: " + hospitalName
                + ", Blood Group: " + bloodGroup
                + ", Quantity: " + quantity
                + ", Request Date: " + requestDate
                + ", Status: " + status;
    }
}