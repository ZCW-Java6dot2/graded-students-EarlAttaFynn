package io.zipcoder;

import java.util.*;

public class Classroom {
    private Student[] students;
    private int maxNumberOfStudents;

    //Constructors
    public Classroom() {
        this.students = new Student[30];
    }

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    //Getters

    public Student[] getStudents() {
        return this.students;
    }

    public Double getAverageExamScore() {
        Double totalAverageSum = 0.0;

        for (Student s : students) {
            totalAverageSum += s.getAverageExamScore();
        }

        return totalAverageSum / students.length;

    }

    //Methods
    public void addStudent(Student student) {
        ArrayList<Student> etudiants = new ArrayList<>(Arrays.asList(this.students));
        etudiants.add(student);
        this.students = new Student[etudiants.size()];

        for (int i = 0; i < etudiants.size(); i++) {
            this.students[i] = etudiants.get(i);
        }
    }

    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> etudiants = new ArrayList<>(Arrays.asList(this.students));

        for (Student s : etudiants) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                etudiants.remove(s);
            }
        }

        etudiants.removeIf(Objects::isNull);

        this.students = new Student[etudiants.size()];

        for (int i = 0; i < etudiants.size(); i++) {
            this.students[i] = etudiants.get(i);
        }
    }

    public Student[] getStudentsByScore() {

        List<Student> studentList = new ArrayList<>(Arrays.asList(getStudents()));

        Collections.sort(studentList, (s1, s2) -> {
            int result = s2.getAverageExamScore().compareTo(s1.getAverageExamScore());
            if(result == 0){
                result = s1.getFirstName().compareTo(s2.getFirstName());
            }
            return result;
        });
        return studentList.toArray(new Student[studentList.size()]);
        }
       /* {
            boolean sorted = false;
            Student temp;
            String tempName;

            while (!sorted) {
                sorted = true;
                for (int i = 0; i < etudiants.size(); i++) {
                    if (etudiants.get(i).getAverageExamScore() > etudiants.get(i + 1).getAverageExamScore()) {
                        temp = etudiants.get(i);
                        etudiants.set(i, etudiants.get(i + 1));
                        etudiants.set(i + 1, temp);
                        sorted = false;

                    }
                }
            }
            return etudiants.toArray(new Student[0]);
        }

        */



    public Map<String, String> getGradeBook() throws NullPointerException{

        Map<String, String> gradeBook = new HashMap<>();
        int count;
        int percent;

        for (int i = 0; i < students.length; i++) {
            count = 0;
            for (int j = 0; j < students.length; j++) {
                if (students[i].getAverageExamScore() > students[j].getAverageExamScore()) {
                    count++;
                }
            }
            percent = (count * 100) / (students.length - 1);
            if (percent > 89) {
                gradeBook.put(students[i].toString(), "A");
            } else if (percent <= 89 && percent > 70) {
                gradeBook.put(students[i].toString(), "B");
            } else if (percent <= 70 && percent > 49) {
                gradeBook.put(students[i].toString(), "C");
            } else if (percent <= 49 && percent > 11) {
                gradeBook.put(students[i].toString(), "D");
            } else {
                gradeBook.put(students[i].toString(), "F");
            }
        }

        return  gradeBook;
    }

    public static void main(String[] args) {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {56.0, 25.0};
        Double[] s3Scores = {225.0, 100.0};
        Double[] s4Scores = {78.0, 85.0};

        Student s1 = new Student("Jim", "Bob", s1Scores);
        Student s2 = new Student("Billy", "Ray", s2Scores);
        Student s3 = new Student("Bobby", "Carpenter", s3Scores);
        Student s4 = new Student("Mike", "Mulligan", s4Scores);

        Student[] students = new Student[]{s1, s2, s3, s4};
        Classroom classroom = new Classroom(students);

        System.out.println(classroom.getGradeBook());
    }








}


