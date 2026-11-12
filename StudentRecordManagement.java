package com.gla.LinkedList;

import java.util.Scanner;

public class StudentRecordManagement {

    static class Student {
        int rollNo;
        String name;
        int age;
        String grade;
        Student next;

        Student(int rollNo, String name, int age, String grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    static Student head = null;
    static Scanner sc = new Scanner(System.in);

    static Student inputStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        return new Student(roll, name, age, grade);
    }

    static void addBeginning() {
        Student newNode = inputStudent();

        newNode.next = head;
        head = newNode;

        System.out.println("Student added successfully.");
    }

    static void addEnd() {
        Student newNode = inputStudent();

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        System.out.println("Student added successfully.");
    }

    static void addAtPosition() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addBeginning();
            return;
        }

        Student temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        Student newNode = inputStudent();

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Student added successfully.");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == roll) {
            head = head.next;
            System.out.println("Student deleted.");
            return;
        }

        Student temp = head;

        while (temp.next != null && temp.next.rollNo != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted.");
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == roll) {
                System.out.println("Roll Number: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    static void displayStudents() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }

        Student temp = head;

        while (temp != null) {
            System.out.println("-------------------");
            System.out.println("Roll Number: " + temp.rollNo);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);

            temp = temp.next;
        }
    }

    static void updateGrade() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == roll) {
                System.out.print("Enter New Grade: ");
                temp.grade = sc.nextLine();

                System.out.println("Grade updated.");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== STUDENT RECORD MANAGEMENT =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Display Students");
            System.out.println("7. Update Grade");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBeginning();
                    break;
                case 2:
                    addEnd();
                    break;
                case 3:
                    addAtPosition();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    displayStudents();
                    break;
                case 7:
                    updateGrade();
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
