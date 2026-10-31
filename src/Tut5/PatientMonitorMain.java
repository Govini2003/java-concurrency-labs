package Tut5;

public class PatientMonitorMain {
    public static void main(String[] args) {
        PatientMonitor monitor = new PatientMonitor(72, 36.6);

        // Three doctor threads
        for (int i = 1; i <= 3; i++) {
            Thread doctor = new Thread(() -> {
                try {
                    for (int j = 0; j < 3; j++) {
                        monitor.readPatientData();
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Doctor-" + i);
            doctor.start();
        }

        // Two nurse threads
        Thread nurse1 = new Thread(() -> {
            try {
                Thread.sleep(500);
                monitor.updatePatientData(85, 37.2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Nurse-1");

        Thread nurse2 = new Thread(() -> {
            try {
                Thread.sleep(600);
                monitor.updatePatientData(78, 36.9);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Nurse-2");

        nurse1.start();
        nurse2.start();
    }
}