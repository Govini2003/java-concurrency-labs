package Tut8.Q2;

public class TravelDetails {
    private int travelID;

    private String travelDestination;
    private int noOfDays;
    private int costPerDay;

    public TravelDetails(int travelID,  String travelDestination, int noOfDays, int costPerDay) {
        this.travelID = travelID;
        this.travelDestination = travelDestination;
        this.noOfDays = noOfDays;
        this.costPerDay = costPerDay;


    }


    public double totalCost(){
        return noOfDays*costPerDay;
    }
}
