package main.map.Search.WordCount;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private Map<String, Integer> wordList;

    public WordCount() {
        wordList = new HashMap<>();
    }

    public void addWord(String word, Integer count) {
        wordList.put(word, count);
    }

    public void removeWord(String word) {
        if(!wordList.isEmpty()) {
            wordList.remove(word);
        } else {
            System.out.println("The list is empty");
        }
    }

    public void displayWordCount() {
        if(!wordList.isEmpty()) {
            System.out.println(wordList);
        } else {
            System.out.println("The list is empty");
        }
    }

    public String mostFrequentWord() {
        int frequency = 0;
        String word = null;

        if(!wordList.isEmpty()) {
            for (Map.Entry<String, Integer> entry : wordList.entrySet()) {
                if(entry.getValue() > frequency) {
                    frequency = entry.getValue();
                    word = entry.getKey();
                }
            }
        } else {
            return "The list is empty";
        }

        return "The most frequent word is " + word + " - " + frequency + " times";
    }

    public static void main(String[] args) {
        WordCount wordList = new WordCount();

        wordList.addWord("Java", 2);
        wordList.addWord("Python", 8);
        wordList.addWord("JavaScript", 1);
        wordList.addWord("C#", 6);

        System.out.println("LIST OF WORDS");
        wordList.displayWordCount();

        System.out.println(wordList.mostFrequentWord());

        System.out.println("Removing word 'JavaScript'");
        wordList.removeWord("JavaScript");

        System.out.println("List after removing 'JavaScript'");
        wordList.displayWordCount();

    }
}
