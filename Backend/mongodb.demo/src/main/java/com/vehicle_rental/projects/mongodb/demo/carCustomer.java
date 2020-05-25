package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "carCustomer")
public class carCustomer {
    private String FullName;
    private String NIC;
    private int ContactNo;
    private String EmailAddress;
    private String NumberPlate;
    private Date pickUpDate;
    private Date dropDate;
    private String CarMake;
    private String CarModel;

    public carCustomer(String FullName, String NIC, int ContactNo, String EmailAddress, String NumberPlate, Date pickUpDate, Date dropDate, String carMake, String carModel) {
        this.FullName = FullName;
        this.NIC = NIC;
        this.ContactNo = ContactNo;
        this.EmailAddress = EmailAddress;
        this.NumberPlate = NumberPlate;
        this.pickUpDate = pickUpDate;
        this.dropDate = dropDate;
        this.CarMake = carMake;
        this.CarModel = carModel;
    }

    public String getFullName() {
        System.out.println(FullName);
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public int getContactNo() {
        return ContactNo;
    }

    public void setContactNo(int ContactNo) {
        this.ContactNo = ContactNo;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(String NumberPlate) {
        this.NumberPlate = NumberPlate;
    }

    public Date getpickUpDate() {
        return pickUpDate;
    }

    public void setpickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getdropDate() {
        return dropDate;
    }

    public void setdropDate(Date dropDate) {
        this.dropDate = dropDate;
    }

    public String getCarMake() {
        return CarMake;
    }

    public void setCarMake(String carMake) {
        this.CarMake = carMake;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String carModel) {
        this.CarModel = carModel;
    }
}
