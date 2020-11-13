package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClassroomTest {
    private Student s1;
    private Student s2;
    private Student[] students;
    private Classroom classroom;

    @Before
    public void setup() {
        //Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {56.0, 25.0};
        Double[] s3Scores = {225.0, 100.0};
        Double[] s4Scores = {78.0, 85.0};

        this.s1 = new Student("Jim", "Bob", s1Scores);
        this.s2 = new Student("Billy", "Ray", s2Scores);

        this.students = new Student[]{s1, s2};
        this.classroom = new Classroom(students);
    }

    @Test
    public void testGetStudents() {
        //When
        Student[] expected = this.students;
        Student[] actual = classroom.getStudents();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore() {

        Double expected = (100.0 + 150.0 + 225.0 + 25.0) / 4;

        Double actual = classroom.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddStudent() {
        // : Given
        int maxNumberOfStudents = 3;
        //Classroom testClassroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Leon", "Hunter", examScores);

        //When
        Student[] pre = classroom.getStudents();
        classroom.addStudent(student);
        Student[] post = classroom.getStudents();

        //Then
        Assert.assertFalse(pre == post);
        Assert.assertTrue(pre.length < post.length);

    }

    @Test
    public void testRemoveStudent() {

        //When
        Student[] pre = classroom.getStudents();
        classroom.removeStudent("Jim", "Bob");
        Student[] post = classroom.getStudents();

        //Then
        Assert.assertTrue(pre.length > post.length);
        Assert.assertNotEquals(pre, post);
    }

    @Test
    public void testGetStudentByScore() {
        Student[] expected = new Student[]{s2, s1};

       Student[] actual = classroom.getStudentsByScore();

       Assert.assertEquals(expected, actual);
    }

}
