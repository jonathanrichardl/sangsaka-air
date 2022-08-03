package com.example.sangsakaair.routes;

import com.example.sangsakaair.airportapi.Airport;
import com.example.sangsakaair.airportapi.AirportAPI;

public class Route {
    private Airport origin;
    private Airport destination;

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    private double distance;
    long fee;
    boolean international;
    public Route(String originIata, String destinationIata) throws Exception{
        try{
            this.origin = AirportAPI.GetAirportDetails(originIata);
            this.destination = AirportAPI.GetAirportDetails(destinationIata);
        }
        catch (Exception e){
            throw(e);
        }
        this.international = !(origin.alpha2countryCode.equals(destination.alpha2countryCode));
        this.distance = DistanceMeasurer.distance(origin, destination);
        this.fee = PriceCalculation.calculatePrice(distance, this.international);
    }

    public double getDistance() {
        return distance;
    }

    public String getOriginName(){
        return this.origin.name;
    }

    public String getDestinationName(){
        return this.destination.name;
    }
}
