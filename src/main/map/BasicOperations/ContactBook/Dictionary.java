package main.map.BasicOperations.ContactBook;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }
    public void addWord(String word, String definition) {
        dictionary.put(word, definition);
    }

    public void removeWord(String word) {
        if(!dictionary.isEmpty()) {
            dictionary.remove(word);
        } else {
            System.out.println("Dictionary is empty");
        }
    }

    public void displayWords() {
        if(!dictionary.isEmpty()) {
            System.out.println(dictionary);
        } else {
            System.out.println("Dictionary is empty");
        }
    }

    public String getWordDefinition(String word) {

        if(!dictionary.isEmpty()) {
            String definition = dictionary.get(word);
            if(definition != null) {
                return definition;
            } else {
                return "Word " + word + " not found on dictionary";
            }
        } else {
            return "Dictionary is empty";
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.addWord("Java", "Programming language based on OOP");
        dictionary.addWord("TypeScript", "JavaScript Superset");
        dictionary.addWord("Kotlin", "Modern programming language to JVM");

        System.out.println("DICTIONARY");
        dictionary.displayWords();

        System.out.println("\nDefinition of Java: " + dictionary.getWordDefinition("Java"));
        System.out.println("\nDefinition of JavaScript (doesn't exist): " + dictionary.getWordDefinition("JavaScript"));

        System.out.println("\nRemove word Kotlin");
        dictionary.removeWord("Kotlin");

        System.out.println("\nDictionary after remove word Kotlin");
        dictionary.displayWords();
    }
}
