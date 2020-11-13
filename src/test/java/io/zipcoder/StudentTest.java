package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    private Student studentTest;
    String givenFirstName;
    String givenLastName;

    @Before
    public void setUp() throws Exception {
// : Given
        this.givenFirstName = "Leon";
        this.givenLastName = "Hunter";
        Double[] givenExamScores = {100.0, 95.0, 123.0, 96.0};
        this.studentTest = new Student(givenFirstName, givenLastName, givenExamScores);
    }

    @Test
    public void testGetFirstName() {
        String given = "Merp";
        studentTest.setFirstName(given);
        Assert.assertEquals(given, studentTest.getFirstName());
    }

    @Test
    public void testGetLastName() {
        String given = "Ah Derp";
        studentTest.setLastName(given);
        Assert.assertEquals(given, studentTest.getLastName());
    }

    @Test
    public void testGetNumOfExamsTaken() {
        Double[] givenExamScores = {100.0, 95.0, 123.0, 96.0};
        int expected = givenExamScores.length;
        Assert.assertEquals(expected, studentTest.getNumOfExamsTaken());
    }

    @Test
    public void testGetExamScores() {
        // When
        String expected = "Exam 1 -> 100.0\n" +
                "Exam 2 -> 95.0\n" +
                "Exam 3 -> 123.0\n" +
                "Exam 4 -> 96.0\n";

        String actual = studentTest.getExamScores();

        // Then

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testAddExamScore() {
        // : Given
        double newScore = 88.8;
        String expected = "Exam 1 -> 100.0\n" +
                "Exam 2 -> 95.0\n" +
                "Exam 3 -> 123.0\n" +
                "Exam 4 -> 96.0\n" +
                "Exam 5 -> 88.8\n";

        // When
        this.studentTest.addExamScore(newScore);
        String actual = studentTest.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetExamScore() {
        //Given
        String expected = "Exam 1 -> 150.0\n" +
                "Exam 2 -> 95.0\n" +
                "Exam 3 -> 123.0\n" +
                "Exam 4 -> 96.0\n";
        // When
        studentTest.setExamScore(1, 150.0);
        String actual = studentTest.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore() {

        //Given
        Double expected = (100.0 + 95.0 + 123.0 + 96.0) / 4;

        //When
        Double actual = studentTest.getAverageExamScore();

        //Then
        Assert.assertEquals(expected, actual);

    }
}