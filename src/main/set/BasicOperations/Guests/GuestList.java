package main.set.BasicOperations.Guests;

import java.util.HashSet;
import java.util.Set;

public class GuestList {
    private Set<Guest> guestsSet;

    public GuestList() {
        guestsSet = new HashSet<>();
    }

    public void addGuest(String name, int inviteCode) {
        Guest newGuest = new Guest(name, inviteCode);

        guestsSet.add(newGuest);
    }

    public void removeGuestByInviteCode(int inviteCode) {
        Guest guestToRemove = null;

        if(!guestsSet.isEmpty()) {
            for(Guest guest : guestsSet) {
                if(guest.getInviteCode() == inviteCode) {
                    guestToRemove = guest;
                    break;
                }
            }
            guestsSet.remove(guestToRemove);
        } else {
            System.out.println("Guest list is empty");
        }
    }

    public int countNumberOfGuests() {
        return guestsSet.size();
    }

    public void displayGuestList() {
        if(guestsSet.isEmpty()) {
            System.out.println("Guest list is empty");
        } else {
            System.out.println(guestsSet);
        }
    }

    public static void main(String[] args) {
        GuestList guestList = new GuestList();

        System.out.println("Number of guests: " + guestList.countNumberOfGuests());

        guestList.addGuest("Guest 1", 1234);
        guestList.addGuest("Guest 2", 1235);
        guestList.addGuest("Guest 3", 1235);
        guestList.addGuest("Guest 4", 1236);

        System.out.println("Guests");
        guestList.displayGuestList();

        guestList.removeGuestByInviteCode(1234);
        System.out.println("Number of guests: " + guestList.countNumberOfGuests());

        guestList.displayGuestList();
    }
}
