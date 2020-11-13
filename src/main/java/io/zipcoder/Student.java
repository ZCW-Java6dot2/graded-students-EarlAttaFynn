package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(examScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Methods
    public int getNumOfExamsTaken() {
        return this.examScores.toArray().length;
    }

    //psvm for debugging
    public static void main(String[] args) {
        String givenFirstName = "Leon";
        String givenLastName = "Hunter";
        Double[] givenExamScores = {100.0, 95.0, 123.0, 96.0};
        Student studentTest = new Student(givenFirstName, givenLastName, givenExamScores);

        System.out.print(studentTest.toString());
    }



    public String getExamScores () {
        StringBuilder output = new StringBuilder();
        int index = 1;

        for (Double score : examScores) {
            output.append("Exam " + index + " -> " + score + "\n");
            index++;
        }

        return output.toString();
    }

    public void addExamScore(double testScore) {
       this.examScores.add(testScore);

    }

    public void setExamScore(int examNum, double examScore) {

        examScores.set(examNum-1, examScore);
    }

    public Double getAverageExamScore() {

        Double averageScore;
        Double sum = 0.0;

        for (Double score : examScores) {
            sum += score;
        }

        return averageScore = sum / examScores.size();
    }

    @Override
    public String toString() {
       String studentSummary = String.format("Student Name :  %s %s\nAverage exam score : %4.2f\nExam scores :\n%s\nLetter Grade",
               getFirstName(), getLastName(), getAverageExamScore(), getExamScores());

        return studentSummary;
    }
/*
    @Override
    public int compareTo(Student o2) {
        if (this.getAverageExamScore() > o2.getAverageExamScore()) {
            return 1;
        }
        else if (this.getAverageExamScore() < o2.getAverageExamScore()) {
            return -1;
        }
        return (this.getFirstName().compareTo(o2.getFirstName()));
    }

 */

}
