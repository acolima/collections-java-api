package main.list.Search.SumOfNumbers;

import java.util.ArrayList;
import java.util.List;

public class NumbersList {
    private List<Integer> list;

    public NumbersList() {
        list = new ArrayList<>();
    }

    public void addNumber(int number) {
        list.add(number);
    }

    public int calculateSum() {
        int sum = 0;

        for(Integer number: list) {
            sum += number;
        }

        return sum;
    }

    public int findGreatest() {
        int greatest = Integer.MIN_VALUE;

        if(!list.isEmpty()) {
            for(Integer number : list) {
                if(number > greatest) {
                    greatest = number;
                }
            }
            return greatest;
        } else {
            throw new RuntimeException("The list is empty");
        }
    }

    public int findSmallest() {
        int smallest = Integer.MAX_VALUE;

        if(!list.isEmpty()) {
            for(Integer number : list) {
                if(number < smallest) {
                    smallest = number;
                }
            }
            return smallest;
        } else {
            throw new RuntimeException("The list is empty");
        }
    }

    public void displayList() {
        if(!list.isEmpty()) {
            System.out.println(list);
        } else {
            System.out.println("The list is empty");
        }
    }

    public static void main(String[] args) {
        NumbersList list = new NumbersList();

        list.addNumber(2);
        list.addNumber(7);
        list.addNumber(12);
        list.addNumber(-8);
        list.addNumber(10);
        list.addNumber(1);
        list.addNumber(5);

        list.displayList();

        System.out.println("Sum: " + list.calculateSum());
        System.out.println("Greatest: " + list.findGreatest());
        System.out.println("Smallest: " + list.findSmallest());
    }
}
