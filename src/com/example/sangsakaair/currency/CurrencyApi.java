package com.example.sangsakaair.currency;

import com.example.sangsakaair.airportapi.Airport;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class CurrencyApi {
    private static double getCurrencyFactor(String from, String to) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder().uri(
                URI.create(String.format("https://currency-exchange.p.rapidapi.com/exchange?from=%s&to=%s&q=1", from, to))
        ).headers(
                "X-RapidAPI-Key", "9837a16d1cmsh836c1dbb70f83c0p185f65jsn549b5c98016c","X-RapidAPI-Host", "currency-exchange.p.rapidapi.com"
        ).GET().build();
        try{
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            double result = Double.parseDouble(response.body().toString());
            if(result == 0){
                throw new Exception("Invalid Currency input!");
            }
            return result;

        }
        catch (Exception e){
            throw (e);

        }
    }
    public static double convertCurrency(String from, String to, double quantity) throws Exception{
        double multiplier = getCurrencyFactor(from, to);
        return quantity*multiplier;
    }
}
