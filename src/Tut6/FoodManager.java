package Tut6;

import java.util.concurrent.Semaphore;

public class FoodManager {
    private String slot;
    private final Semaphore foodAvailable = new Semaphore(0, true);
    private final Semaphore placeAvailable = new Semaphore(1, true);

    public void put(String food) throws InterruptedException {
        placeAvailable.acquire();
        try {
            this.slot = food;
            System.out.println("Produced: " + food);
        } finally {
            foodAvailable.release();
        }
    }

    public String get() throws InterruptedException {
        String collectedFood = null;
        foodAvailable.acquire();
        try {
            collectedFood = slot;
        } finally {
            placeAvailable.release();
        }
        return collectedFood;
    }
}