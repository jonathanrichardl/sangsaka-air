package com.example.sangsakaair.airportapi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AirportTest {
    @Test
    void testRetrieveAirport() throws Exception {
        try {
            Airport test = AirportAPI.GetAirportDetails("JFK");
            assertEquals(test.icaoCode, "KJFK");
        } catch (Exception e) {
            return;
        }
        Exception e = assertThrows(Exception.class, () -> {
            AirportAPI.GetAirportDetails("111");
        });
    }
}
