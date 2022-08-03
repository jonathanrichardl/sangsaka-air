package com.example.sangsakaair.routes;

import com.example.sangsakaair.airportapi.Airport;
import com.example.sangsakaair.airportapi.AirportAPI;
import org.junit.jupiter.api.Test;

public class PriceCalculationTest {
    @Test
    void testPriceCalculation() throws Exception{
        Airport origin = AirportAPI.GetAirportDetails("CGK");
        Airport destination = AirportAPI.GetAirportDetails("DPS");
        double distance = DistanceMeasurer.distance(origin, destination);
        long price = PriceCalculation.calculatePrice(distance, false);
        assert Math.abs(400000 - price) <= 20000;

    }
}
