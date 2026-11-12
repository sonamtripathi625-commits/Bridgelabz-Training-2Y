package com.gla.LinkedList;

import java.util.Scanner;

public class TicketReservationSystem {

    static class Ticket {
        int id;
        int seat;
        String customer;
        String movie;
        String bookingTime;

        Ticket next;

        Ticket(int id, String customer, String movie,
               int seat, String bookingTime) {
            this.id = id;
            this.customer = customer;
            this.movie = movie;
            this.seat = seat;
            this.bookingTime = bookingTime;
        }
    }

    static Ticket tail;
    static Scanner sc = new Scanner(System.in);

    static void addTicket() {
        System.out.print("Ticket ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Customer Name: ");
        String customer = sc.nextLine();

        System.out.print("Movie Name: ");
        String movie = sc.nextLine();

        System.out.print("Seat Number: ");
        int seat = sc.nextInt();
        sc.nextLine();

        System.out.print("Booking Time: ");
        String bookingTime = sc.nextLine();

        Ticket newNode = new Ticket(
                id, customer, movie, seat, bookingTime
        );

        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }

        System.out.println("Ticket booked successfully.");
    }

    static void removeTicket() {
        System.out.print("Enter Ticket ID: ");
        int id = sc.nextInt();

        if (tail == null) {
            System.out.println("No bookings available.");
            return;
        }

        Ticket prev = tail;
        Ticket cur = tail.next;

        do {
            if (cur.id == id) {

                if (cur == tail && cur.next == tail) {
                    tail = null;
                } else {
                    prev.next = cur.next;

                    if (cur == tail) {
                        tail = prev;
                    }
                }

                System.out.println("Ticket cancelled.");
                return;
            }

            prev = cur;
            cur = cur.next;

        } while (cur != tail.next);

        System.out.println("Ticket not found.");
    }

    static void displayTickets() {
        if (tail == null) {
            System.out.println("No booked tickets.");
            return;
        }

        Ticket temp = tail.next;

        do {
            print(temp);
            temp = temp.next;

        } while (temp != tail.next);
    }

    static void searchTicket() {
        if (tail == null) {
            System.out.println("No bookings available.");
            return;
        }

        sc.nextLine();

        System.out.print("Search by (1) Customer (2) Movie: ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print(type == 1 ? "Customer Name: " : "Movie Name: ");
        String query = sc.nextLine();

        Ticket temp = tail.next;
        boolean found = false;

        do {
            String value = (type == 1) ? temp.customer : temp.movie;

            if (value.equalsIgnoreCase(query)) {
                print(temp);
                found = true;
            }

            temp = temp.next;

        } while (temp != tail.next);

        if (!found) {
            System.out.println("No matching ticket.");
        }
    }

    static void countTickets() {
        int count = 0;

        if (tail != null) {
            Ticket temp = tail.next;

            do {
                count++;
                temp = temp.next;

            } while (temp != tail.next);
        }

        System.out.println("Total Booked Tickets: " + count);
    }

    static void print(Ticket ticket) {
        System.out.println(
                "Ticket ID: " + ticket.id +
                        " | Customer: " + ticket.customer +
                        " | Movie: " + ticket.movie +
                        " | Seat: " + ticket.seat +
                        " | Booking Time: " + ticket.bookingTime
        );
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== TICKET RESERVATION SYSTEM =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Bookings");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addTicket();
                    break;
                case 2:
                    removeTicket();
                    break;
                case 3:
                    displayTickets();
                    break;
                case 4:
                    searchTicket();
                    break;
                case 5:
                    countTickets();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
