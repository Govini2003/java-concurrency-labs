package Tut7.Q1;

public class Student {
    private String name;
    private double courseworkMark;
    private double examMark;

    public Student(String name, double courseworkMark, double examMark) {
        this.name = name;
        this.courseworkMark = courseworkMark;
        this.examMark = examMark;
    }

    public String getName() {
        return this.name;
    }

    public double getCourseworkMark() {
        return courseworkMark;
    }

    public double getExamMark() {
        return examMark;
    }
}
