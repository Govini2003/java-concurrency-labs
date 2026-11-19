package Tut8.Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        //create 5 travel objects - task
        //create fixedThreadPoolExecutor
        //invokeAll
        //invokeAny and see diff

        TravelDetails travelDetails = new TravelDetails(1,"India",5,40000);
        TravelDetails travelDetails1 = new TravelDetails(2,"China",5,40000);
        TravelDetails travelDetails2 = new TravelDetails(3,"Aussie",5,40000);
        TravelDetails travelDetails3 = new TravelDetails(4,"India",5,40000);
        TravelDetails travelDetails5 = new TravelDetails(5,"India",5,40000);

        List<Callable<Double>> tasks = new ArrayList<>(); //invokeAll accepts
        tasks.add(new TravelAgency(travelDetails));
        tasks.add(new TravelAgency(travelDetails1));
        tasks.add(new TravelAgency(travelDetails2));
        tasks.add(new TravelAgency(travelDetails3));
        tasks.add(new TravelAgency(travelDetails5));

        List<Future<Double>> futureList = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            futureList = executorService.invokeAll(tasks);
            //can use invokeAny(tasks) also
            //then returns result of one task
            //invokeAny will return the results of first completing task
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=0; i<futureList.size(); i++){
            try{
                System.out.println("Travel id"+i+"|" +"Total Cost = "+futureList.get(i).get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
