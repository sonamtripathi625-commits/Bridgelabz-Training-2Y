package com.gla.LinkedList;

import java.util.Scanner;

public class LibraryManagementSystem {

    static class Book {
        String title;
        String author;
        String genre;
        int id;
        boolean available;

        Book prev, next;

        Book(String title, String author, String genre,
             int id, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.id = id;
            this.available = available;
        }
    }

    static Book head, tail;
    static Scanner sc = new Scanner(System.in);

    static Book input() {
        sc.nextLine();

        System.out.print("Book Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Genre: ");
        String genre = sc.nextLine();

        System.out.print("Book ID: ");
        int id = sc.nextInt();

        System.out.print("Available? (true/false): ");
        boolean available = sc.nextBoolean();

        return new Book(title, author, genre, id, available);
    }

    static void insert(int pos) {
        Book newNode = input();

        if (head == null) {
            head = tail = newNode;
            return;
        }

        if (pos <= 1) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        Book temp = head;

        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;
    }

    static void remove() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book temp = head;

        while (temp != null && temp.id != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }

        System.out.println("Book removed.");
    }

    static void search() {
        sc.nextLine();

        System.out.print("Search by (1) Title (2) Author: ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print(type == 1 ? "Title: " : "Author: ");
        String query = sc.nextLine();

        boolean found = false;

        for (Book temp = head; temp != null; temp = temp.next) {
            String value = (type == 1) ? temp.title : temp.author;

            if (value.equalsIgnoreCase(query)) {
                print(temp);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book.");
        }
    }

    static void update() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book temp = head; temp != null; temp = temp.next) {
            if (temp.id == id) {
                System.out.print("Available? (true/false): ");
                temp.available = sc.nextBoolean();

                System.out.println("Availability updated.");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void displayForward() {
        if (head == null) {
            System.out.println("No books.");
            return;
        }

        Book temp = head;

        while (temp != null) {
            print(temp);
            temp = temp.next;
        }
    }

    static void displayReverse() {
        if (tail == null) {
            System.out.println("No books.");
            return;
        }

        Book temp = tail;

        while (temp != null) {
            print(temp);
            temp = temp.prev;
        }
    }

    static void count() {
        int count = 0;

        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total Books: " + count);
    }

    static void print(Book book) {
        System.out.println(
                book.id + " | " +
                        book.title + " | " +
                        book.author + " | " +
                        book.genre + " | Available: " +
                        book.available
        );
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove Book");
            System.out.println("5. Search Book");
            System.out.println("6. Update Availability");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Count Books");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insert(1);
                    break;
                case 2:
                    insert(Integer.MAX_VALUE);
                    break;
                case 3:
                    System.out.print("Position: ");
                    insert(sc.nextInt());
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    update();
                    break;
                case 7:
                    displayForward();
                    break;
                case 8:
                    displayReverse();
                    break;
                case 9:
                    count();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}