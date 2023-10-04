package main.set.Search.ContactBook;

import java.util.Objects;

public class Contact {
    private String name;
    private int phoneNumber;

    public Contact(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int number) {
        this.phoneNumber = number;
    }

    @Override
    public String toString() {
        return "{ " + name + ", phoneNumber: " + phoneNumber + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getName(), contact.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
