package com.javaAddressBookProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int input = 0;

        while (input != 6) {
            printMenu();
            input = getIntInput();
            if (input < 1 || input > 6) {
                System.out.println("\nInvalid input! Try Again!\n");
            } else {
                switch (input) {
                    case 1:
                        addEntry(addressBook);
                        break;
                    case 2:
                        String email = askForInput("email");
                        addressBook.removeEntry(email);
                        break;
                    case 3:
//                        searchForSpecificEntry(addressBook);
                        break;
                    case 4:
                        addressBook.printAddressBook();
                        break;
                    case 5:
                        addressBook.deleteAddressBook();
                        break;
                    case 6:
                        System.out.println("Exiting program");
                        break;
                }
            }
        }
        scanner.close();
    }

    public static int getIntInput() {
        boolean invalidInput = false;
        int input = 0;

        do {
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                invalidInput = true;
            }
        } while (false);
        scanner.nextLine();
        return input;
    }

    public static String askForInput(String inputName) {
        System.out.print("\nEnter an entry's email to remove: ");
        return scanner.nextLine();
    }

    public static void addEntry(AddressBook addressBook) {
        System.out.print("\nFirst Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Email Address: ");
        String email = scanner.next();

        Entry entry = new Entry(firstName, lastName, phone, email);
        addressBook.addEntry(entry);
    }

    public static void printMenu() {
        System.out.println("1) Add an entry");
        System.out.println("2) Remove an entry");
        System.out.println("3) Search an entry");
        System.out.println("4) Print Address Book");
        System.out.println("5) Delete Book");
        System.out.println("6) Quit");
        System.out.print("\nPlease choose what you'd like to do with the database: ");
    }
}
