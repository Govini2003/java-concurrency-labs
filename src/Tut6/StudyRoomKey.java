package Tut6;

import java.util.concurrent.Semaphore;

class StudyRoomKey {
    // Synchronization Mechanics
    private final Semaphore keyAvailable = new Semaphore(1);
    private final Semaphore keyNotAvailable = new Semaphore(0);

    // TODO 1: shared field tracking the current student
    private String student;

    public void borrowKey(String student) throws InterruptedException {
        keyAvailable.acquire();

        try {
            // TODO 3: record student's name in shared state
            this.student = student;

            // TODO 4: print borrow message, sleep, print using message
            System.out.println(student + " is borrowing the key");
            Thread.sleep(2000);
            System.out.println(student + " is using the key");
        } finally {
            keyNotAvailable.release();
        }
    }

    public void returnKey() throws InterruptedException {
        keyNotAvailable.acquire();

        try {
            // TODO 7: read name, print leaving, sleep, print cleared
            String current = this.student;
            System.out.println(current + " is leaving and returning the key");
            Thread.sleep(1000);
            this.student = null;
            System.out.println("Key cleared, no student holds it now");
        } finally {
            keyAvailable.release();
        }
    }
}
