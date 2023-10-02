package main.list.Sort.Numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumbers {
    private List<Integer> numbersList;

    public SortNumbers() {
        numbersList = new ArrayList<>();
    }

    public void addNumber(int number) {
        numbersList.add(number);
    }

    public List<Integer> sortAsc() {
        List<Integer> sortedAsc = new ArrayList<>(this.numbersList);
        if (!numbersList.isEmpty()) {
            Collections.sort(numbersList);
            return sortedAsc;
        } else {
            throw new RuntimeException("The list is empty");
        }
    }

    public List<Integer> sortDesc() {
        List<Integer> sortedDesc = new ArrayList<>(this.numbersList);
        if (!numbersList.isEmpty()) {
            sortedDesc.sort(Collections.reverseOrder());
            return sortedDesc;
        } else {
            throw new RuntimeException("The list is empty");
        }
    }

    public void displayList() {
        if (!numbersList.isEmpty()) {
            System.out.println(numbersList);
        } else {
            System.out.println("The list is empty");
        }
    }

    public static void main(String[] args) {
        SortNumbers numbersList = new SortNumbers();

        numbersList.addNumber(7);
        numbersList.addNumber(5);
        numbersList.addNumber(-1);
        numbersList.addNumber(52);
        numbersList.addNumber(22);

        System.out.println(numbersList.sortAsc());

        System.out.println(numbersList.sortDesc());
    }

}
