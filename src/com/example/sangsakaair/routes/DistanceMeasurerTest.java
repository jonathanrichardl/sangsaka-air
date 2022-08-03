package com.example.sangsakaair.routes;

import com.example.sangsakaair.airportapi.Airport;
import com.example.sangsakaair.airportapi.AirportAPI;
import org.junit.jupiter.api.Test;

public class DistanceMeasurerTest {
    @Test
    void testMeasureDistance(){
        double originLatitude = 0.00;
        double originLongitude = 0.00;
        double destinationLatitude = 90.00;
        double destinationLongitude = 90.00;
        double distance = DistanceMeasurer.distance(originLatitude, originLongitude, destinationLatitude, destinationLongitude);
        assert Math.abs((10001.00 - distance)) <= 50.00;

    }
    @Test
    void testMeasureDistanceofAirports() throws Exception {
        Airport origin = AirportAPI.GetAirportDetails("BPN");
        Airport destination = AirportAPI.GetAirportDetails("CGK");
        double distance = DistanceMeasurer.distance(origin, destination);
        assert Math.abs((1258 - distance)) <= 50.00;
    }
}
