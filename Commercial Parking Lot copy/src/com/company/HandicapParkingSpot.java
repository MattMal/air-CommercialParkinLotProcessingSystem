package com.company;

/**
 * Created by owner on 2017-07-12.
 */
public class HandicapParkingSpot extends ParkingSpot {


    public HandicapParkingSpot(int spotNumberIn, int floorIn, double rateIn) {
        super(spotNumberIn, floorIn);
        rate = rateIn;
    }
}
