package com.gla.LinkedList;

import java.util.Scanner;

public class RoundRobinScheduling {

    static class Process {
        int id;
        int burstTime;
        int remainingTime;
        int priority;
        int completionTime;

        Process next;

        Process(int id, int burstTime, int priority) {
            this.id = id;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
        }
    }

    static Process tail;
    static Scanner sc = new Scanner(System.in);

    static void addProcess() {
        System.out.print("Process ID: ");
        int id = sc.nextInt();

        System.out.print("Burst Time: ");
        int burst = sc.nextInt();

        System.out.print("Priority: ");
        int priority = sc.nextInt();

        Process newNode = new Process(id, burst, priority);

        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }

        System.out.println("Process added.");
    }

    static void display() {
        if (tail == null) {
            System.out.println("No active processes.");
            return;
        }

        Process temp = tail.next;

        do {
            System.out.println(
                    "PID: " + temp.id +
                            " | Remaining Time: " + temp.remainingTime +
                            " | Priority: " + temp.priority
            );

            temp = temp.next;

        } while (temp != tail.next);
    }

    static void simulate() {
        if (tail == null) {
            System.out.println("Add processes first.");
            return;
        }

        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();

        if (quantum <= 0) {
            System.out.println("Time quantum must be positive.");
            return;
        }

        Process first = tail.next;
        Process prev = tail;
        Process current = first;

        int currentTime = 0;

        while (tail != null) {
            int executionTime = Math.min(quantum, current.remainingTime);

            current.remainingTime -= executionTime;
            currentTime += executionTime;

            System.out.println(
                    "Process " + current.id +
                            " executed for " + executionTime +
                            " units. Current time: " + currentTime
            );

            if (current.remainingTime == 0) {
                current.completionTime = currentTime;

                System.out.println("Process " + current.id + " completed.");

                if (current == tail && current.next == current) {
                    tail = null;
                    break;
                }

                prev.next = current.next;

                if (current == tail) {
                    tail = prev;
                }

                current = prev.next;
            } else {
                prev = current;
                current = current.next;
            }

            System.out.println("Active processes after this turn:");
            display();
        }

        calculateTimes(first);
    }

    static void calculateTimes(Process first) {
        int totalWaiting = 0;
        int totalTurnaround = 0;
        int count = 0;

        Process temp = first;

        System.out.println("\n===== PROCESS DETAILS =====");

        do {
            int turnaround = temp.completionTime;
            int waiting = turnaround - temp.burstTime;

            totalWaiting += waiting;
            totalTurnaround += turnaround;
            count++;

            System.out.println(
                    "PID: " + temp.id +
                            " | Burst Time: " + temp.burstTime +
                            " | Waiting Time: " + waiting +
                            " | Turnaround Time: " + turnaround
            );

            temp = temp.next;

        } while (temp != first);

        System.out.printf(
                "Average Waiting Time: %.2f%n",
                (double) totalWaiting / count
        );

        System.out.printf(
                "Average Turnaround Time: %.2f%n",
                (double) totalTurnaround / count
        );
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== ROUND ROBIN SCHEDULING =====");
            System.out.println("1. Add Process");
            System.out.println("2. Display Active Processes");
            System.out.println("3. Simulate Round Robin");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProcess();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    simulate();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
