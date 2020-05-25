package com.company;

public class Schedule { //create the schedule class and initialize the variable on it
    private Date dateOfPickup;
    private Date dateOfDrop;
    private Date date;

    // generate the constructors inside the schedule class
    public Schedule(Date date) {
        this.date = date;
    }

    public Schedule(Date dateOfPickup, Date dateOfDrop) {
        this.dateOfPickup = dateOfPickup;
        this.dateOfDrop = dateOfDrop;
    }

    // generate the getters and setters for the Date class
    public Date getDateOfPickup() {
        return dateOfPickup;
    }

    public void setDateOfPickup(Date dateOfPickup) {
        this.dateOfPickup = dateOfPickup;
    }

    public Date getDateOfDrop() {
        return dateOfDrop;
    }

    public void setDateOfDrop(Date dateOfDrop) {
        this.dateOfDrop = dateOfDrop;
    }

    //generate the toSting method to schedule class
    @Override
    public String toString() {
        return "Schedule{" +
                "date=" + date +
                '}';
    }
}

