package com.company;

/**
 * Created by owner on 2017-07-12.
 */
public abstract  class ParkingSpot {
    public int spotNumber;
    public int floor;
    public double rate;
    public boolean inUse;
    Vehicle vehicle;


    public ParkingSpot(int spotNumberIn, int floorIn) {
        this.spotNumber = spotNumberIn;
        this.floor = floorIn;
        this.inUse = false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isEmpty(){
        if(vehicle == null){
            System.out.println("The spot is available");
            return true;
        } else{
            System.out.println("The spot is in Use");
            return false;
        }
    }

    public boolean addCar(Vehicle vehicleIn){
        if(isEmpty()){
            vehicle = vehicleIn;
            System.out.println("Vehicle has been added");
            return true;
        } else {
            System.out.println("Vehicle was not added");
            return false;
        }

    }

    public boolean removeCar(){
        if(isEmpty()){
            System.out.println("The spot is already empty");
            return false;
        } else {
            vehicle = null;
            System.out.println("Vehicle has been removed from the spot");
            return true;
        }
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public int getFloor() {
        return floor;
    }

    public double getRate() {
        return rate;
    }

    public boolean isInUse() {
        return inUse;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", floor=" + floor +
                ", rate=" + rate +
                ", inUse=" + inUse +
                '}';
    }
}
