package Tut8.Q1;

import java.util.concurrent.Callable;

public class Electricity  {
    private int id;
    private int unit;
    private double ratePerUnit;

    public Electricity(int id, int unit, double ratePerUnit) {
        this.id = id;
        this.unit = unit;
        this.ratePerUnit = ratePerUnit;
    }
    public int getId() {return id;}
    public int getUnit() {return unit;}
    public double getRatePerUnit() {return ratePerUnit;}
}