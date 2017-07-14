package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owner on 2017-07-12.
 */
public class ParkingLot {
    private List<ParkingSpot> parkingSpotList = new ArrayList<>();
    private List<Vehicle> vehicleList = new ArrayList<>();
    private int lotSize = 500;

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public int getLotSize() {
        return lotSize;
    }

    public boolean constructParkingSpot(ParkingSpot parkingSpotIn){
        if(maxParkingSpots()){
            System.out.println("Not Added: City Maximum Spots reached");
            return false;
        } else {
            System.out.println("New parking spot was constructed");
            getParkingSpotList().add(parkingSpotIn);
            return true;
        }
    }

    public boolean maxParkingSpots(){
        if(getParkingSpotList().size()>=lotSize){
            System.out.println("Max amount of spots have been created");
            return true;
        } else {
            System.out.println("There is space to create a new parking spot");
            return false;
        }
    }

    public boolean addVehicle(Vehicle vehicleIn, double timeIn){
        if(spotAvailable(vehicleIn, timeIn)){

            getVehicleList().add(vehicleIn);
            System.out.println("The vehicle is added to the vehicle list ");
            return true;
        } else {
            System.out.println("There are no empty spots in the parking lot so GTFOH");
            return false;
        }
    }


    private boolean spotAvailable(Vehicle vehicleIn, double timeIn ) {
        for(ParkingSpot parkingSpot: getParkingSpotList()){
            if(parkingSpot.isEmpty()){
                System.out.println("An empty parking spot has been found at location: "+parkingSpot.toString());
                parkingSpot.addCar(vehicleIn);
                System.out.println("The empty spot has now been filled by car with plate number: "+ vehicleIn.getPlateNum());
                vehicleIn.setTimeIn(timeIn);
                return true;
            }
        }
        System.out.println("the Lot is full");
        return false;

    }

    private ParkingSpot emptySlots() {
        for(ParkingSpot parkingSpot: getParkingSpotList()){
            if(parkingSpot.isEmpty()){
                System.out.println("An empty parking spot was found at location: "+ parkingSpot.toString());
                return parkingSpot;
            }
        }
        System.out.println("the Lot is full");
        return null;
    }



    public boolean vehicleExit(Vehicle vehicleOut, double timeOut){

        boolean spotRemovalConfirmation = removeFromSpot(vehicleOut);

        boolean totalExitConfirmation = removedFromCarList(vehicleOut);

        if(spotRemovalConfirmation&& totalExitConfirmation){
            vehicleOut.setTimeOut(timeOut);
            System.out.println("The total cost for the parking period is: "+ vehicleOut.getTotalCost());
            System.out.println("The vehicle exited the premises");
            return true;
        } else {
            System.out.println("The vehicle was not removed from the premises");
            return false;
        }

    }

    private boolean removeFromSpot(Vehicle vehicleIn){
        for (ParkingSpot parkingSpot: getParkingSpotList()){
            if(parkingSpot.getVehicle().equals(vehicleIn)){
                parkingSpot.removeCar();
                System.out.println("Car has been removed from the spot");
                return true;
            }
        }
        System.out.println("The car was not found to be removed from the spot");
        return false;
    }

    private boolean carLocation(Vehicle vehicleIn){
        for (ParkingSpot parkingSpot: getParkingSpotList()){
            if(parkingSpot.getVehicle().equals(vehicleIn)){
                System.out.println("Car has been located at: "+parkingSpot.toString());
                return true;
            }
        }
        System.out.println("The car was not found in the parking lot");
        return false;
    }

    private boolean removedFromCarList(Vehicle vehicleIn){
        if(getVehicleList().contains(vehicleIn)){

            getVehicleList().remove(vehicleIn);
            System.out.println("Vehicle has exited the lot");
            return true;
        } else {
            System.out.println("Are you sure your vehicle is in the lot? because It was found");
            return false;
        }
    }

}
