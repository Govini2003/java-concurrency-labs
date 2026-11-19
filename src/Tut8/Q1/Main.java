package Tut8.Q1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        // 1) create the 10 houses
        Electricity[] electricityDetails = new Electricity[10];
        for (int i = 0; i < electricityDetails.length; i++) {
            electricityDetails[i] = new Electricity(i, i * 25, i * 1000);
        }

        // 2) one pool with 3 threads, submit one task per house
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Double>> futureList = new ArrayList<>();

        for (Electricity electricity : electricityDetails) {
            futureList.add(executorService.submit(new BillCalculation(electricity)));
        }

        // 3) collect the results (get() blocks until each bill is ready)
        for (int i = 0; i < futureList.size(); i++) {
            try {
                System.out.println("House No " + i + " | Total Bill = " + futureList.get(i).get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        // 4) always shut down
        executorService.shutdown();
    }
}