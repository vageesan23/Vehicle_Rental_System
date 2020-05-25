package com.vehicle_rental.projects.mongodb.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "bikeCustomer")
public class bikeCustomer {

    private String fullName;
    private String NIC;
    private int ContactNo;
    private String EmailAddress;
    private String NumberPlate;
    private Date pickUpDate;
    private Date dropDate;

  private   String bikeMake;
  private  String bikeModel;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public void setContactNo(int contactNo) {
        ContactNo = contactNo;
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

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropDate() {
        return dropDate;
    }

    public void setDropDate(Date dropDate) {
        this.dropDate = dropDate;
    }

    public String getBikeMake() {
        return bikeMake;
    }

    public void setBikeMake(String bikeMake) {
        this.bikeMake = bikeMake;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public bikeCustomer(String fullName, String NIC, int contactNo, String EmailAddress, String numberPlate, Date pickUpDate, Date dropDate, String bikeMake, String bikeModel) {
        this.fullName = fullName;
        this.NIC = NIC;
        this.ContactNo = contactNo;
        this.EmailAddress = EmailAddress;
        this.NumberPlate = numberPlate;
        this.pickUpDate = pickUpDate;
        this.dropDate = dropDate;
        this.bikeMake = bikeMake;
        this.bikeModel = bikeModel;
    }
}
