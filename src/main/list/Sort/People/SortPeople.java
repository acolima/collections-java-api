package main.list.Sort.People;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPeople {
    private List<Person> peopleList;

    public SortPeople() {
        peopleList = new ArrayList<>();
    }

    public void addPerson(String name, int age, double height) {
        Person newPerson = new Person(name, age, height);
        peopleList.add(newPerson);
    }

    public List<Person> sortByAge() {
        List<Person> sortedByAge = new ArrayList<>(peopleList);
        Collections.sort(sortedByAge);
        return sortedByAge;
    }

    public List<Person> sortByHeight() {
        List<Person> sortedByHeight = new ArrayList<>(peopleList);
        Collections.sort(sortedByHeight, new ComparatorByAge());
        return sortedByHeight;
    }

    public static void main(String[] args) {
        SortPeople peopleList = new SortPeople();

        peopleList.addPerson("Person 1", 29, 1.83);
        peopleList.addPerson("Person 2", 25, 1.75);
        peopleList.addPerson("Person 3", 28, 1.80);
        peopleList.addPerson("Person 4", 26, 1.63);

        System.out.println("Sorted by age - " + peopleList.sortByAge());
        System.out.println("Sorted by height - " + peopleList.sortByHeight());
    }
}
