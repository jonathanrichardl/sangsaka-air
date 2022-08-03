package com.example.sangsakaair.routes;

public class PriceCalculation {
    private static double feePerKilometre = 300;
    private static double baseFareDomestic = 100000;
    private static double baseFareInternational = 250000;
    public static long calculatePrice(double distance, boolean international){
        double fare = international?
                (distance * feePerKilometre) + baseFareInternational :
                (distance * feePerKilometre) + baseFareDomestic;
        return Math.round(fare);
    }



}
