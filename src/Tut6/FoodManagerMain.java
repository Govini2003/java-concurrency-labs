package Tut6;

public class FoodManagerMain {
    public static void main(String[] args) {
        FoodManager foodManager = new FoodManager();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    foodManager.put("Food " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }, "Producer");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    String food = foodManager.get();
                    System.out.println("Consumed: " + food);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }, "Consumer");

        producer.start();
        consumer.start();
    }
}