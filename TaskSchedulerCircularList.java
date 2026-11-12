package com.gla.LinkedList;

import java.util.Scanner;

public class TaskSchedulerCircularList {

    static class Task {
        int id;
        int priority;
        String name;
        String dueDate;
        Task next;

        Task(int id, String name, int priority, String dueDate) {
            this.id = id;
            this.name = name;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    static Task tail;
    static Task current;

    static Scanner sc = new Scanner(System.in);

    static Task input() {
        System.out.print("Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Task Name: ");
        String name = sc.nextLine();

        System.out.print("Priority: ");
        int priority = sc.nextInt();
        sc.nextLine();

        System.out.print("Due Date: ");
        String dueDate = sc.nextLine();

        return new Task(id, name, priority, dueDate);
    }

    static void insert(int pos) {
        Task newNode = input();

        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
            current = newNode;
            return;
        }

        if (pos <= 1) {
            newNode.next = tail.next;
            tail.next = newNode;
            return;
        }

        Task temp = tail.next;

        for (int i = 1; i < pos - 1 && temp != tail; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }
    }

    static void delete() {
        System.out.print("Task ID to remove: ");
        int id = sc.nextInt();

        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Task prev = tail;
        Task cur = tail.next;

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

                if (current == cur) {
                    current = (tail == null) ? null : cur.next;
                }

                System.out.println("Task removed.");
                return;
            }

            prev = cur;
            cur = cur.next;

        } while (cur != tail.next);

        System.out.println("Task not found.");
    }

    static void viewCurrent() {
        if (current == null) {
            System.out.println("No tasks.");
            return;
        }

        print(current);

        current = current.next;
    }

    static void display() {
        if (tail == null) {
            System.out.println("No tasks.");
            return;
        }

        Task cur = tail.next;

        do {
            print(cur);
            cur = cur.next;
        } while (cur != tail.next);
    }

    static void searchPriority() {
        if (tail == null) {
            System.out.println("No tasks.");
            return;
        }

        System.out.print("Enter Priority: ");
        int priority = sc.nextInt();

        Task cur = tail.next;
        boolean found = false;

        do {
            if (cur.priority == priority) {
                print(cur);
                found = true;
            }

            cur = cur.next;

        } while (cur != tail.next);

        if (!found) {
            System.out.println("No task with this priority.");
        }
    }

    static void print(Task t) {
        System.out.println(
                t.id + " | " +
                        t.name + " | Priority: " +
                        t.priority + " | Due Date: " +
                        t.dueDate
        );
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== TASK SCHEDULER =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove Task");
            System.out.println("5. View Current/Next Task");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
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
                    delete();
                    break;
                case 5:
                    viewCurrent();
                    break;
                case 6:
                    display();
                    break;
                case 7:
                    searchPriority();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
