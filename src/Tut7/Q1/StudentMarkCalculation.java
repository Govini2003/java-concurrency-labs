package Tut7.Q1;

public class StudentMarkCalculation implements Runnable {
    private Student student;

    public StudentMarkCalculation(Student student) {
        this.student = student;
    }
    @Override
    public void run() {
        double finalMark = student.getCourseworkMark() * 8.4 + student.getExamMark() * 8.6;

        String outcome = (finalMark >= 40) ? "PASS" : "FAIL";

        System.out.println(
                Thread.currentThread().getName() +
                        " | Student: " + student.getName() +
                        " | Final Mark " + String.format("%.2f", finalMark) +
                        " | Outcome " + outcome
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
