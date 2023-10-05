package main.set.Sort.Students;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudentList {
    private Set<Student> studentList;

    public StudentList() {
        studentList = new HashSet<>();
    }

    public void addStudent(long id, String name, double grade) {
        Student newStudent = new Student(id, name, grade);
        studentList.add(newStudent);
    }

    public void removeStudent(long id) {
        boolean studentFound = false;
        if(!studentList.isEmpty()) {
            for(Student s : studentList) {
                if(s.getId() == id) {
                    studentList.remove(s);
                    studentFound = true;
                    break;
                }
            }
        }

        if(!studentFound) {
            System.out.println("Student not found");
        }
    }

    public void sortByName() {
        if(!studentList.isEmpty()) {
            Set<Student> sortedStudents = new TreeSet<>(studentList);
            System.out.println(sortedStudents);
        } else {
            System.out.println("The student list is empty");
        }
    }

    public void sortByGrade() {
        if(!studentList.isEmpty()) {
            Set<Student> sortedStudents = new TreeSet<>(new ComparatorByGrade());
            sortedStudents.addAll(studentList);
            System.out.println(sortedStudents);
        } else {
            System.out.println("The student list is empty");
        }
    }

    public void displayStudents() {
        if(!studentList.isEmpty()) {
            System.out.println(studentList);

        } else {
            System.out.println("The student list is empty");
        }
    }

    public static void main(String[] args) {
        StudentList studentList = new StudentList();

        studentList.addStudent(1L, "Student A", 8.2);
        studentList.addStudent(1L, "Student C", 5.2);
        studentList.addStudent(2L, "Student M", 2.0);
        studentList.addStudent(3L, "Student D", 9.1);
        studentList.addStudent(4L, "Student T", 4.3);
        studentList.addStudent(5L, "Student R", 6.8);

        System.out.println("STUDENTS");
        studentList.displayStudents();

        System.out.println("\nRemoving student 5");
        studentList.removeStudent(5);
        studentList.displayStudents();

        System.out.println("\nStudents sorted by name");
        studentList.sortByName();

        System.out.println("\nStudents sorted by grade");
        studentList.sortByGrade();
    }
}
