package Tut8.Q2;

import java.util.concurrent.Callable;

public class TravelAgency implements Callable<Double> {

    private TravelDetails travelDetails;
    public TravelAgency(TravelDetails travelDetails) {
        this.travelDetails = travelDetails;
    }
    @Override
    public Double call() throws Exception {
        double totalCost = travelDetails.totalCost();
        return totalCost;
    }
}
