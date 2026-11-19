package Tut8.Q1;

import java.util.concurrent.Callable;

public class BillCalculation implements Callable<Double> {
    private Electricity electricity;

    public BillCalculation(Electricity electricity) {
        this.electricity = electricity;
    }
    @Override
    public Double call() throws Exception {
        return electricity.getUnit() * electricity.getRatePerUnit();
    }
}

