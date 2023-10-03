package main.set.BasicOperations.Words;

import java.util.HashSet;
import java.util.Set;

public class UniqueWords {
    private Set<String> uniqueWordsSet;

    public UniqueWords() {
        uniqueWordsSet = new HashSet<>();
    }

    public void addWord(String word) {
        uniqueWordsSet.add(word);
    }

    public void removeWord(String word) {
        if(!uniqueWordsSet.isEmpty()) {
            if(uniqueWordsSet.contains(word)) {
                uniqueWordsSet.remove(word);
            } else {
                System.out.println("Word " + word + " not found on set");
            }
        } else {
            System.out.println("Set is empty");
        }
    }

    public boolean checkWord(String word) {
        return uniqueWordsSet.contains(word);
    }

    public void displaySet() {
        if(uniqueWordsSet.isEmpty()) {
            System.out.println("Set is empty");
        } else {
            System.out.println(uniqueWordsSet);
        }
    }

    public static void main(String[] args) {
        UniqueWords uniqueWordsSet = new UniqueWords();

        uniqueWordsSet.addWord("Hi");
        uniqueWordsSet.addWord("Bye");
        uniqueWordsSet.addWord("Hello");
        uniqueWordsSet.addWord("Hi");

        uniqueWordsSet.displaySet();

        uniqueWordsSet.removeWord("Bye");
        uniqueWordsSet.displaySet();

        uniqueWordsSet.removeWord("Carol");
        uniqueWordsSet.displaySet();

        System.out.println("Is the word 'bye' on the set? " + uniqueWordsSet.checkWord("Bye"));
    }
}
