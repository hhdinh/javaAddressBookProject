package com.javaAddressBookProject;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Entry> addressBook;

    public AddressBook(List<Entry> addressBook) {
        this.addressBook = addressBook;
    }

    public AddressBook() {
        this.addressBook = new ArrayList<>();
    }

    public boolean addEntry(Entry entry) {
        if (this.addressBook.contains(entry.getEmailAddress())) {
            System.out.println("This email is already in the address book.");
            return false;
        }
        this.addressBook.add(entry);
        System.out.println("\nAdded new entry!\n");
        return true;
    }

    public boolean removeEntry(String emailAddress) {
        for (int i = 0; i < this.addressBook.size(); i++) {
            if (this.addressBook.get(i).getEmailAddress().equals(emailAddress)) {
                System.out.println("\nDeleted the following entry: \n" + this.addressBook.get(i).toString());
                addressBook.remove(i);
                return true;
            }
        }
        System.out.println("\nEntry not found!\n");
        return false;
    }

    public void printAddressBook() {
        if (this.addressBook.size() == 0) {
            System.out.println("\nAddress book is empty!\n");
        } else {
            System.out.println(this.addressBook.toString());
        }
    }

    public void deleteAddressBook() {
        this.addressBook.clear();
        System.out.println("\nAddress book cleared!\n");
    }
}
