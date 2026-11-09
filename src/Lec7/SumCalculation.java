package Lec7;

import java.util.concurrent.Callable;


// can't use primitive data types for return
public class SumCalculation implements Callable<Double> {
    @Override
    public Double call() throws Exception {
        // callable used to get return values.
        // callable is similar to runnable. but here it has a return type. and can call exception in method.
        double sum = 0.0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}
