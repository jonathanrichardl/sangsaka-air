package com.example.sangsakaair;

import com.example.sangsakaair.aircraft.Aircraft;
import com.example.sangsakaair.aircraft.BCS1;
import com.example.sangsakaair.aircraft.BCS3;
import com.example.sangsakaair.flight.Flight;
import com.example.sangsakaair.routes.Route;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SangsakaAdminUtil {
    public static void registerAircraft(ArrayList<Aircraft> aircraftList, String type, String registration) throws Exception{
        Aircraft aircraft;
        Pattern pattern = Pattern.compile("^PK-S", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(registration);
        if (!matcher.find()){
            throw new Exception("Invalid Registration name!");
        }
        switch (type.replaceAll("\\s+", "").toLowerCase()) {
            case "bcs1":
                aircraft = new BCS1(registration.toUpperCase());
                break;
            case "bcs3":
                aircraft = new BCS3(registration.toUpperCase());
                break;
            default:
                throw new Exception("Aircraft Not Available in Catalog");
        }
        aircraftList.add(aircraft);
    }

    public static void generateRoute(ArrayList<Route> routeList, String origin , String destination) throws Exception{
        Route newRoute = new Route(origin, destination);
        routeList.add(newRoute);
    }

    public static void generateFlight(ArrayList<Flight> flightList, Aircraft aircraft, Route route) throws Exception{
        Flight newFlight = new Flight(route, aircraft);
        flightList.add(newFlight);
        aircraft.setAssigned(true);
    }

    public static void bookFlight(Flight flight, String name){
        flight.getPassengers().add(name);
    }
}
