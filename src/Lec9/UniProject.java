package Lec9;

import java.util.concurrent.Phaser;

public class UniProject {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        for(int i=0;i<3;i++){
            int studentID=i;
            Thread student =new Thread(()-> {
                System.out.println(Thread.currentThread().getName() + "- started collecting data");
                try {
                    Thread.sleep(100);

                System.out.println(Thread.currentThread().getName() + "- completed collecting data");
                phaser.arriveAndAwaitAdvance();

                System.out.println(Thread.currentThread().getName() + "- Started preparing the slides");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "- Completed preparing the slides");
                phaser.arriveAndAwaitAdvance();

                System.out.println(Thread.currentThread().getName() + "- Started preparing the presentation");
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + "- Completed preparing the presentation");
                phaser.arriveAndAwaitAdvance();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        }
    }
}
