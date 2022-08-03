package com.example.sangsakaair;

import com.example.sangsakaair.aircraft.Aircraft;
import com.example.sangsakaair.flight.Flight;
import com.example.sangsakaair.routes.Route;

import java.util.ArrayList;
import java.util.Scanner;

public class SangsakaAir {
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
    private static ArrayList<Aircraft> aircraftList = new ArrayList<Aircraft>();
    private static ArrayList<Route> routeList = new ArrayList<Route>();
    private static ArrayList<Flight> flightList = new ArrayList<Flight>();
    public static void main(String[] args) {
        while (true){
            try {
                mainMenu();
            }
            catch (Exception e){
                System.out.println(e);
                continue;
            }
        }


    }

    private static void mainMenu() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Sangsaka Air App!");
        System.out.println("1. Admin App");
        System.out.println("2. User App");
        String choice = scan.nextLine();
        switch (choice){
            case "1":
                admin();
                break;
            case "2":
                user();
                break;
            default:
                throw new Exception("Invalid Input");
        }
    }

    private static void admin() throws Exception{
        Scanner scan = new Scanner(System.in);
        clearConsole();
        System.out.println("What do you wanna do!");
        System.out.println("1. Register New Aircraft!\n2.Generate a Route\n3. Assign Aircraft for Flights\n4. See Flight Detail");
        System.out.println("Enter Input: ");
        String choice = scan.nextLine();
        switch (choice){
            case "1":
                registerNewAircraft();
                break;
            case "2":
                generateRoutes();
                break;
            case "3":
                assignPlaneToRoute();
                break;
            case "4":
                seeFlightDetails();
                break;
            default:
                admin();
                return;

        }

    }

    private static void user() throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you wanna do!");
        System.out.println("1. Book a Flight");
        System.out.println("Enter Input: ");
        String choice = scan.nextLine();
        switch (choice) {
            case "1":
                bookAFlight();
                break;
            default:
                break;

        }
        mainMenu();

    }

    private static void registerNewAircraft() throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Aircraft ICAO Code: ");
        String choice = scan.nextLine();
        System.out.println();
        System.out.print("Input Aircraft Registration: ");
        String registration = scan.nextLine();
        SangsakaAdminUtil.registerAircraft(aircraftList, choice, registration);
        System.out.println(String.format("Aircraft %s has been added", registration));
        scan.nextLine();
        mainMenu();
    }

    private static void generateRoutes() throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Origin: ");
        String origin = scan.nextLine();
        System.out.println();
        System.out.print("Input Destination: ");
        String destination = scan.nextLine();
        System.out.println();
        SangsakaAdminUtil.generateRoute(routeList, origin, destination);
        System.out.println(String.format("Route %s-%s has been added", origin, destination));
        scan.nextLine();
        mainMenu();
    }

    private static void assignPlaneToRoute() throws Exception{
        Scanner scan = new Scanner(System.in);
        if(routeList.size() == 0){
            System.out.println("No route available");
            scan.nextLine();
        }
        int count = 1;
        for (Route route : routeList){
            System.out.println(String.format("%d. %s - %s", count, route.getOriginName(), route.getDestinationName()));
            count++;
        }
        for (Aircraft plane: aircraftList) {
            if(plane.isAssigned()) {
                continue;
            }
            System.out.println(String.format("Assign %s to what route? ", plane.getRegistration()));
            int route = Integer.parseInt(scan.nextLine());
            SangsakaAdminUtil.generateFlight(flightList, plane, routeList.get(route-1));
        }
        mainMenu();
    }

    private static void seeFlightDetails() throws Exception{
        int count = 1;
        for(Flight flight : flightList){
            String message = String.format("%d. FLT-NO: %s \t Registration: %s \t Origin : %s \t Destination : %s",
                    count, flight.getFltNo(),
                    flight.getAircraft().getRegistration(),
                    flight.getOrigin(), flight.getDestination());
            System.out.println(message + "\nPassengers:");
            int paxCount = 1;
            for(String pax : flight.getPassengers()){
                System.out.println(String.format("%d. %s", paxCount, pax));
                paxCount++;
            }
            count++;
        }
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        mainMenu();

    }

    private static void bookAFlight() throws Exception{
        Scanner scan = new Scanner(System.in);
        int count = 1;
        for(Flight flight : flightList) {
            String message = String.format("%d. FLT-NO: %s \t Registration: %s \t Origin : %s \t Destination : %s \t Price : %f",
                    count, flight.getFltNo(),
                    flight.getAircraft().getRegistration(),
                    flight.getOrigin(), flight.getDestination(),
                    flight.getFee());
            System.out.println(message);
        }
        System.out.print("Enter Flight to book: ");
        int choice = Integer.parseInt(scan.nextLine());
        Flight chosen = flightList.get(choice-1);
        System.out.println();
        System.out.print("Enter pax Name: ");
        String paxName = scan.nextLine();
        System.out.println();
        if(chosen.addPassengers(paxName)){
            System.out.println(String.format("Passenger %s has been added to flight %s", paxName, chosen.getFltNo()));
        }
        else{
            System.out.println("Plane is Full!");
        }
        scan.nextLine();

    }

}

