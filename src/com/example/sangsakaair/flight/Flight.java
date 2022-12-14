package com.example.sangsakaair.flight;

import com.example.sangsakaair.aircraft.Aircraft;
import com.example.sangsakaair.routes.Route;

import java.util.ArrayList;
import java.util.Random;

public class Flight {
    private String origin;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFltNo(String fltNo) {
        this.fltNo = fltNo;
    }

    private String destination;
    private String fltNo;

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    private double fee;

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    Aircraft aircraft;
    public Flight(Route route, Aircraft aircraft) throws Exception{
        if(!checkCapability(route, aircraft)){
            throw new Exception("Aircraft incapable to fill the route!");
        }
        setOrigin(route.getOriginName());
        setDestination(route.getDestinationName());
        Random rand = new Random(System.currentTimeMillis());
        setFltNo("SN " + Integer.toString(rand.nextInt(999) + 1));
        setAircraft(aircraft);
        setFee(route.getFee());
    }

    public boolean addPassengers(String name) {
        if(this.passengers.size() >= this.aircraft.getCapacity()){
            return false;
        }
        this.passengers.add(name);
        return true;

    }

    private boolean checkCapability(Route route, Aircraft aircraft){
        return aircraft.getRange() > route.getDistance();
    }

    public String getFltNo() {
        return fltNo;
    }

    public ArrayList<String> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<String> passengers) {
        this.passengers = passengers;
    }

    private ArrayList<String> passengers = new ArrayList<String>();

}
