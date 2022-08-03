package com.example.sangsakaair.airportapi;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class AirportAPI {
    public static Airport GetAirportDetails(String iataCode) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder().uri(
                URI.create("https://aviation-reference-data.p.rapidapi.com/airports/" + iataCode)
        ).headers(
                "X-RapidAPI-Key", "9837a16d1cmsh836c1dbb70f83c0p185f65jsn549b5c98016c","X-RapidAPI-Host", "aviation-reference-data.p.rapidapi.com"
        ).GET().build();

        try{
            HttpResponse response = client.send(request, BodyHandlers.ofString());
            if(response.statusCode() == 404){
                throw new Exception("Airport not Found!");
            }
            Gson deserializer = new Gson();
            return deserializer.fromJson(response.body().toString(), Airport.class);
        }
        catch (Exception e){
            throw (e);

        }





    }
}
