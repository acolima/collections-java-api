package main.map.BasicOperations;

import java.util.HashMap;
import java.util.Map;

public class ContactBook {
    private Map<String, Integer> contactBook;

    public ContactBook() {
        contactBook = new HashMap<>();
    }

    public void addContact(String name, Integer phoneNumber) {
        contactBook.put(name, phoneNumber);
    }

    public void removeContact(String name) {
        if(!contactBook.isEmpty()) {
            contactBook.remove(name);
        } else {
            System.out.println("The contact book is empty");
        }
    }

    public void displayContacts() {
        if(!contactBook.isEmpty()) {
            System.out.println(contactBook);
        } else {
            System.out.println("The contact book is empty");
        }
    }

    public Integer getPhoneByName(String name) {
        Integer phoneNumber = null;

        if(!contactBook.isEmpty()) {
            phoneNumber = contactBook.get(name);
            if(phoneNumber == null) {
                System.out.println("Contact " + name + " not found");
            }
        } else {
            System.out.println("The contact book is empty");
        }

        return phoneNumber;
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();

        contactBook.addContact("Carol 1", 12345678);
        contactBook.addContact("Carol 1", 22345678);
        contactBook.addContact("Carol 2", 12345688);
        contactBook.addContact("Ana 1", 12345679);
        contactBook.addContact("Ana 2", 12346579);

        System.out.println("CONTACTS");
        contactBook.displayContacts();

        System.out.println("Carol 1 phone number: " + contactBook.getPhoneByName("Carol 1"));
        System.out.println("Ana 1 phone number: " + contactBook.getPhoneByName("Ana 1"));
        System.out.println("João phone number: " + contactBook.getPhoneByName("João"));

        System.out.println("\nRemoving contact Ana 2");
        contactBook.removeContact("Ana 2");

        System.out.println("\nContact book after remove Ana 2");
        contactBook.displayContacts();
    }
}
