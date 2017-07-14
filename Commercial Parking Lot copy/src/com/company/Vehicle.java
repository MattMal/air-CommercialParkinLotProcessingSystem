package com.company;

/**
 * Created by owner on 2017-07-12.
 */
public class Vehicle {

    private String plateNum;
    private String make;
    private String model;
    private boolean regularPark;
    private double timeIn;
    private boolean member;
    private double timeOut;
    private double regularRate = 3.99;
    private double handRate = 1.99;

    public Vehicle(String plateNum, String make, String model, boolean regularPark, boolean member) {
        this.plateNum = plateNum;
        this.make = make;
        this.model = model;
        this.regularPark = regularPark;
        this.member = member;
    }

    public void setTimeIn(double timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(double timeOut) {
        this.timeOut = timeOut;
    }

    public void setRegularRate(double regularRate) {
        this.regularRate = regularRate;
    }

    public void setHandRate(double handRate) {
        this.handRate = handRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        return plateNum.equals(vehicle.plateNum);
    }

    @Override
    public int hashCode() {
        return plateNum.hashCode();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNum='" + plateNum + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", regularPark=" + regularPark +
                ", timeIn=" + timeIn +
                ", member=" + member +
                '}';
    }

    public String getPlateNum() {
        return plateNum;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean isRegularPark() {
        return regularPark;
    }

    public double getTimeIn() {
        return timeIn;
    }

    public boolean isMember() {
        return member;
    }

    public double getTimeOut() {
        return timeOut;
    }

    public double totalTime(){
        return getTimeOut()-getTimeIn();
    }

    public double getRegularRate() {
        return regularRate;
    }

    public double getHandRate() {
        return handRate;
    }

    public double getTotalCost(){
        if(isRegularPark()){
            System.out.println("You are getting charged at the REGULAR rate");
            return totalTime()* getRegularRate();
        } else if (isMember()){
            System.out.println("You are a member, no added charges needed");
            return 0;
        } else {
            System.out.println("You are getting charged the DISCOUNTED rate");
            return totalTime()*getHandRate();
        }

    }
}
