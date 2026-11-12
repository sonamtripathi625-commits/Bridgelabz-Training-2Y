package com.gla.LinkedList;

import java.util.Scanner;

public class MovieManagementSystem {

    static class Movie {
        String title;
        String director;
        int year;
        double rating;

        Movie prev, next;

        Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    static Movie head, tail;
    static Scanner sc = new Scanner(System.in);

    static Movie input() {
        sc.nextLine();

        System.out.print("Movie Title: ");
        String title = sc.nextLine();

        System.out.print("Director: ");
        String director = sc.nextLine();

        System.out.print("Year: ");
        int year = sc.nextInt();

        System.out.print("Rating: ");
        double rating = sc.nextDouble();

        return new Movie(title, director, year, rating);
    }

    static void insertAt(int pos) {
        Movie node = input();

        if (head == null) {
            head = tail = node;
            return;
        }

        if (pos <= 1) {
            node.next = head;
            head.prev = node;
            head = node;
            return;
        }

        Movie cur = head;

        for (int i = 1; i < pos - 1 && cur.next != null; i++) {
            cur = cur.next;
        }

        node.next = cur.next;
        node.prev = cur;

        if (cur.next != null) {
            cur.next.prev = node;
        } else {
            tail = node;
        }

        cur.next = node;
    }

    static void delete() {
        sc.nextLine();

        System.out.print("Title to remove: ");
        String title = sc.nextLine();

        Movie cur = head;

        while (cur != null && !cur.title.equalsIgnoreCase(title)) {
            cur = cur.next;
        }

        if (cur == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (cur.prev != null) {
            cur.prev.next = cur.next;
        } else {
            head = cur.next;
        }

        if (cur.next != null) {
            cur.next.prev = cur.prev;
        } else {
            tail = cur.prev;
        }

        System.out.println("Movie removed.");
    }

    static void search() {
        sc.nextLine();

        System.out.print("Search by (1) Director (2) Rating: ");
        int type = sc.nextInt();
        sc.nextLine();

        if (type == 1) {
            System.out.print("Director: ");
            String director = sc.nextLine();

            for (Movie m = head; m != null; m = m.next) {
                if (m.director.equalsIgnoreCase(director)) {
                    print(m);
                }
            }
        } else {
            System.out.print("Rating: ");
            double rating = sc.nextDouble();

            for (Movie m = head; m != null; m = m.next) {
                if (m.rating == rating) {
                    print(m);
                }
            }
        }
    }

    static void update() {
        sc.nextLine();

        System.out.print("Movie Title: ");
        String title = sc.nextLine();

        for (Movie m = head; m != null; m = m.next) {
            if (m.title.equalsIgnoreCase(title)) {
                System.out.print("New Rating: ");
                m.rating = sc.nextDouble();

                System.out.println("Rating updated.");
                return;
            }
        }

        System.out.println("Movie not found.");
    }

    static void print(Movie m) {
        System.out.println(
                m.title + " | " +
                        m.director + " | " +
                        m.year + " | Rating: " + m.rating
        );
    }

    static void displayForward() {
        if (head == null) {
            System.out.println("No movies.");
            return;
        }

        for (Movie m = head; m != null; m = m.next) {
            print(m);
        }
    }

    static void displayReverse() {
        if (tail == null) {
            System.out.println("No movies.");
            return;
        }

        for (Movie m = tail; m != null; m = m.prev) {
            print(m);
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== MOVIE MANAGEMENT =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove Movie");
            System.out.println("5. Search Director/Rating");
            System.out.println("6. Display Forward");
            System.out.println("7. Display Reverse");
            System.out.println("8. Update Rating");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertAt(1);
                    break;
                case 2:
                    insertAt(Integer.MAX_VALUE);
                    break;
                case 3:
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    insertAt(pos);
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    displayForward();
                    break;
                case 7:
                    displayReverse();
                    break;
                case 8:
                    update();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
