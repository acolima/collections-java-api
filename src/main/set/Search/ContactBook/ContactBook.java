package main.set.Search.ContactBook;

import java.util.HashSet;
import java.util.Set;

public class ContactBook {
    private Set<Contact> contactBook;

    public ContactBook() {
        contactBook = new HashSet<>();
    }

    public void addContact(String name, int number) {
        Contact newContact = new Contact(name, number);
        contactBook.add(newContact);
    }

    public void displayContacts() {
        if(!contactBook.isEmpty()){
            System.out.println(contactBook);
        } else {
            System.out.println("The contact book is empty");
        }
    }

    public Set<Contact> searchByName(String name) {
        Set<Contact> contactsByName = new HashSet<>();

        for(Contact c : contactBook) {
            if(c.getName().startsWith(name)) {
                contactsByName.add(c);
            }
        }

        return contactsByName;
    }

    public void updatePhoneNumber(String name, int newNumber) {
        boolean contactFound = false;

        if(!contactBook.isEmpty()){
            for(Contact c : contactBook) {
                if(c.getName().equalsIgnoreCase(name)) {
                    c.setPhoneNumber(newNumber);
                    contactFound = true;
                    break;
                }
            }
        } else {
            System.out.println("Couldn't update because the contact book is empty");
            return;
        }

        if(!contactFound) {
            System.out.println("Contact not found");
        }
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();

        contactBook.addContact("Carol 1", 12345678);
        contactBook.addContact("Carol 1", 22345678);
        contactBook.addContact("Carol 2", 12345688);
        contactBook.addContact("Ana", 12345679);

        contactBook.displayContacts();

        System.out.println("List of contacts where name starts with 'Carol': " + contactBook.searchByName("Carol"));
        System.out.println("List of contacts where name starts with 'Ana': " + contactBook.searchByName("Ana"));
        System.out.println("List of contacts where name starts with 'João': " + contactBook.searchByName("João"));

        contactBook.updatePhoneNumber("Ana", 11111111);

        System.out.println("Contact book after update");
        contactBook.displayContacts();
    }
}
