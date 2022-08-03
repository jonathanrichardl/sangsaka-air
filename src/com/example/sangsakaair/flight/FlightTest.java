package com.example.sangsakaair.flight;

import com.example.sangsakaair.aircraft.Aircraft;
import com.example.sangsakaair.aircraft.BCS1;
import com.example.sangsakaair.currency.CurrencyApi;
import com.example.sangsakaair.routes.Route;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FlightTest {
    @Test
    void testFlightGeneration() throws Exception{
        Aircraft testAircraft = new BCS1("PK-SAA");
        Route testRoute = new Route("CGK", "DMK");
        Flight testFlight = new Flight(testRoute, testAircraft);
        assert testFlight.getFltNo().startsWith("SN");
        Route impossibleTestRoute = new Route("CGK", "LAX");
        Exception e = assertThrows(Exception.class, ()-> {
            Flight impossibleFlight = new Flight(impossibleTestRoute, testAircraft);
        });
    }
}
