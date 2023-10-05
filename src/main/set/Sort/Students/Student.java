package main.set.Sort.Students;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student>{
    private long id;
    private String name;
    private double grade;

    public Student(long id, String name, double grade ) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student " + id +" - " + name + ", grade: " + grade + " }";
    }

    @Override
    public int compareTo(Student student) {
        return name.compareToIgnoreCase(student.getName());
    }
}

class ComparatorByGrade implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student1.getGrade(), student2.getGrade());
    }
}
