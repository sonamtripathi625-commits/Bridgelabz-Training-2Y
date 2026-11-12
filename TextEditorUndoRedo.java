package com.gla.LinkedList;

import java.util.Scanner;

public class TextEditorUndoRedo {

    static class State {
        String text;
        State prev, next;

        State(String text) {
            this.text = text;
        }
    }

    static State head, tail, current;

    static int size = 0;
    static final int LIMIT = 10;

    static Scanner sc = new Scanner(System.in);

    static void addState(String text) {

        // Remove redo history when a new action is performed
        if (current != null) {
            current.next = null;
            tail = current;
        }

        State newNode = new State(text);

        if (current == null) {
            head = tail = current = newNode;
            size = 1;
        } else {
            newNode.prev = current;
            current.next = newNode;

            current = tail = newNode;
            size++;
        }

        // Keep only the last 10 states
        while (size > LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    static void typeText() {
        sc.nextLine();

        System.out.print("Enter complete new text: ");
        String text = sc.nextLine();

        addState(text);

        System.out.println("Text saved.");
    }

    static void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo completed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    static void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo completed.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    static void displayCurrent() {
        if (current == null) {
            System.out.println("Text is empty.");
        } else {
            System.out.println("Current Text: " + current.text);
        }
    }

    static void displayHistory() {
        if (head == null) {
            System.out.println("No history.");
            return;
        }

        State temp = head;

        while (temp != null) {
            if (temp == current) {
                System.out.println("-> " + temp.text);
            } else {
                System.out.println("   " + temp.text);
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== TEXT EDITOR UNDO/REDO =====");
            System.out.println("1. Type / Save New State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Display History");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    typeText();
                    break;
                case 2:
                    undo();
                    break;
                case 3:
                    redo();
                    break;
                case 4:
                    displayCurrent();
                    break;
                case 5:
                    displayHistory();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
