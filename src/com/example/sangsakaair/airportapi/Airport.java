package com.example.sangsakaair.airportapi;

public class Airport {
    public String iataCode;
    public String icaoCode;
    public String name;
    public String alpha2countryCode;
    public float latitude;
    public float longitude;

    public Airport(String iataCode, String icaoCode, String name, String alpha2countryCode, float latitude, float longitude){
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.name = name;
        this.alpha2countryCode = alpha2countryCode;
        this.latitude= latitude;
        this.longitude = longitude;
    }
}
