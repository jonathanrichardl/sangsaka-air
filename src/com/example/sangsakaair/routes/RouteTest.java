package com.example.sangsakaair.routes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouteTest {
    @Test
    void testRouteCreation() throws Exception{
        Route newRoute = new Route("CGK", "KIX");
        assertTrue(newRoute.international);
        assert Math.abs((5402 - newRoute.getDistance())) <= 100;
        assert Math.abs(1870600 - newRoute.fee) <= 100000;

        newRoute = new Route("CGK", "SUB");
        assertFalse(newRoute.international);

    }
}
