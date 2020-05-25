package com.company;

public class Date { //create the date class and initialize the attributes
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) { //generate the constructors for the date class
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // generate the getters and setters to date class
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    // generate the toString method to date class
    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
