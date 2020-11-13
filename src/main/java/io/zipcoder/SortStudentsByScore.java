package io.zipcoder;

import java.util.Comparator;

public class SortStudentsByScore implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAverageExamScore() > o2.getAverageExamScore()) {
            return 1;
        }
        else if (o1.getAverageExamScore() < o2.getAverageExamScore()) {
            return -1;
        }
        return (o1.getFirstName().compareTo(o2.getFirstName()));
    }

    @Override
    public Comparator<Student> reversed() {
        return null;
    }
}
