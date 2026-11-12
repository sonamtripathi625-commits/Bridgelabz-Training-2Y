package com.gla.LinkedList;

import java.util.Scanner;

public class InventoryManagementSystem {

    static class Item {
        String name;
        int id;
        int quantity;
        double price;
        Item next;

        Item(String name, int id, int quantity, double price) {
            this.name = name;
            this.id = id;
            this.quantity = quantity;
            this.price = price;
        }
    }

    static Item head;
    static Scanner sc = new Scanner(System.in);

    static Item input() {
        sc.nextLine();

        System.out.print("Item Name: ");
        String name = sc.nextLine();

        System.out.print("Item ID: ");
        int id = sc.nextInt();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        return new Item(name, id, quantity, price);
    }

    static void insert(int pos) {
        Item newNode = input();

        if (pos <= 1 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Item temp = head;

        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    static Item findId(int id) {
        Item temp = head;

        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    static void remove() {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;

        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    static void updateQuantity() {
        System.out.print("Enter Item ID: ");
        Item item = findId(sc.nextInt());

        if (item == null) {
            System.out.println("Item not found.");
        } else {
            System.out.print("Enter New Quantity: ");
            item.quantity = sc.nextInt();

            System.out.println("Quantity updated.");
        }
    }

    static void search() {
        sc.nextLine();

        System.out.print("Search by (1) ID (2) Name: ");
        int type = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        if (type == 1) {
            System.out.print("Enter ID: ");
            Item item = findId(sc.nextInt());

            if (item != null) {
                print(item);
                found = true;
            }
        } else {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            for (Item item = head; item != null; item = item.next) {
                if (item.name.equalsIgnoreCase(name)) {
                    print(item);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No matching item.");
        }
    }

    static void totalValue() {
        double sum = 0;

        for (Item temp = head; temp != null; temp = temp.next) {
            sum += temp.price * temp.quantity;
        }

        System.out.printf("Total Inventory Value: %.2f%n", sum);
    }

    static void sort(boolean byName, boolean ascending) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        boolean swapped;

        do {
            swapped = false;

            for (Item temp = head; temp.next != null; temp = temp.next) {
                int cmp;

                if (byName) {
                    cmp = temp.name.compareToIgnoreCase(temp.next.name);
                } else {
                    cmp = Double.compare(temp.price, temp.next.price);
                }

                if ((ascending && cmp > 0) || (!ascending && cmp < 0)) {
                    String name = temp.name;
                    temp.name = temp.next.name;
                    temp.next.name = name;

                    int id = temp.id;
                    temp.id = temp.next.id;
                    temp.next.id = id;

                    int quantity = temp.quantity;
                    temp.quantity = temp.next.quantity;
                    temp.next.quantity = quantity;

                    double price = temp.price;
                    temp.price = temp.next.price;
                    temp.next.price = price;

                    swapped = true;
                }
            }

        } while (swapped);

        System.out.println("Inventory sorted.");
    }

    static void display() {
        if (head == null) {
            System.out.println("No items.");
            return;
        }

        Item temp = head;

        while (temp != null) {
            print(temp);
            temp = temp.next;
        }
    }

    static void print(Item item) {
        System.out.println(
                item.name + " | ID: " +
                        item.id + " | Quantity: " +
                        item.quantity + " | Price: " +
                        item.price
        );
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove Item");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search Item");
            System.out.println("7. Total Inventory Value");
            System.out.println("8. Sort Inventory");
            System.out.println("9. Display Inventory");
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
                    updateQuantity();
                    break;
                case 6:
                    search();
                    break;
                case 7:
                    totalValue();
                    break;
                case 8:
                    System.out.print("Sort by (1) Name (2) Price: ");
                    int type = sc.nextInt();

                    System.out.print("Order (1) Ascending (2) Descending: ");
                    int order = sc.nextInt();

                    sort(type == 1, order == 1);
                    break;
                case 9:
                    display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
