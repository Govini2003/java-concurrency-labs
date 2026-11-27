package Lec10;

import java.util.concurrent.Phaser;

public class ManagerApproval {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        for(int i=0;i<3;i++) {

            int employeeId = i;

            Thread employee = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "- Starting working on task");
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "- Finished working on task");
                phaser.arriveAndDeregister();

            },"Employee "+employeeId);
            employee.start();
        }

        Thread manager = new Thread(() -> {
            phaser.awaitAdvance(0);//puts the thread to wait until phase is complete
            System.out.println("Manager has approved");

        },"Manager");
        manager.start();
    }
}
