package Tut5;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PatientMonitor {
    private int heartRate;
    private double bodyTemperature;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public PatientMonitor(int heartRate, double bodyTemperature) {
        this.heartRate = heartRate;
        this.bodyTemperature = bodyTemperature;
    }

    // (a) Shared access: many doctors can hold the read lock together
    public void readPatientData() throws InterruptedException {
        String name = Thread.currentThread().getName();
        readLock.lock();
        try {
            System.out.println(name + " started reading");
            Thread.sleep(1000); // simulate reading
            System.out.println(name + " read -> Heart rate: " + heartRate
                    + " bpm, Temperature: " + bodyTemperature + " C");
            System.out.println(name + " finished reading");
        } finally {
            readLock.unlock();
        }
    }

    // (b) Exclusive access: only one nurse, and no doctors, while updating
    public void updatePatientData(int newHeartRate, double newTemperature) throws InterruptedException {
        String name = Thread.currentThread().getName();
        writeLock.lock();
        try {
            System.out.println(">>> " + name + " started updating");
            Thread.sleep(1500); // simulate updating
            this.heartRate = newHeartRate;
            this.bodyTemperature = newTemperature;
            System.out.println(">>> " + name + " set -> Heart rate: " + heartRate
                    + " bpm, Temperature: " + bodyTemperature + " C");
            System.out.println(">>> " + name + " finished updating");
        } finally {
            writeLock.unlock();
        }
    }
}