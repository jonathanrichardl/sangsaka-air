package com.example.sangsakaair.routes;

import com.example.sangsakaair.airportapi.Airport;

public class DistanceMeasurer {
    public static double distance(double lat1, double lon1, double lat2, double lon2){
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;
        return(c * r);
    }

    public static double distance(Airport origin, Airport destination){
        double lon1 = Math.toRadians(origin.longitude);
        double lon2 = Math.toRadians(destination.longitude);
        double lat1 = Math.toRadians(origin.latitude);
        double lat2 = Math.toRadians(destination.latitude);
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;
        return(c * r);
    }
}
