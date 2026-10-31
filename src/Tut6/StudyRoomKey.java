package Tut6;

import java.util.concurrent.Semaphore;

class StudyRoomKey {
    // Synchronization mechanics
    private final Semaphore keyAvailable = new Semaphore(1);     // room is free
    private final Semaphore keyNotAvailable = new Semaphore(0);  // no return pending

    // TODO 1: shared field tracking the current student
    private String student;

    public void borrowKey(String student) throws InterruptedException {
        // TODO 2: wait until the room is free
        keyAvailable.acquire();
        try {
            // TODO 3: record the student's name
            this.student = student;

            // TODO 4: borrow message, sleep 2000 ms, in-use message
            System.out.println(student + " borrowed the key");
            Thread.sleep(2000);
            System.out.println(student + " is using the study room");
        } finally {
            // TODO 5: signal the return service
            keyNotAvailable.release();
        }
    }

    public void returnKey() throws InterruptedException {
        // TODO 6: wait until a student is ready to leave
        keyNotAvailable.acquire();
        try {
            // TODO 7: read name, leaving message, sleep 1000 ms, cleared message
            String current = this.student;
            System.out.println(current + " is leaving and returning the key");
            Thread.sleep(1000);
            System.out.println("Room cleared after " + current);
        } finally {
            // TODO 8: signal the next borrower
            keyAvailable.release();
        }
    }
}