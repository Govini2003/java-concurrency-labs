package Tut7.Q1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentMarksMain {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Student student1 = new Student("John", 20, 50);
        Student student2 = new Student("Mary", 96, 65);
        Student student3 = new Student("Micheal", 55, 70);
        Student student4 = new Student("Jason", 90, 85);
        Student student5 = new Student("Sara", 76, 67);

        ArrayList<Student> students = new ArrayList<>(List.of(student1,student2,student3,student4,student5));

        // The pool
        for (Student student: students) {
            service.submit(new StudentMarkCalculation(student));
        }

        service.shutdown();
    }
}