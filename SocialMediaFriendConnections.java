package com.gla.LinkedList;

import java.util.Scanner;
import java.util.ArrayList;

public class SocialMediaFriendConnections {

    static class User {
        int id;
        int age;
        String name;

        ArrayList<Integer> friends = new ArrayList<>();

        User next;

        User(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    static User head;
    static Scanner sc = new Scanner(System.in);

    static User find(int id) {
        User temp = head;

        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    static void addUser() {
        System.out.print("User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (find(id) != null) {
            System.out.println("User ID already exists.");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();

        User newNode = new User(id, name, age);

        if (head == null) {
            head = newNode;
        } else {
            User temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("User added.");
    }

    static void addConnection() {
        System.out.print("First User ID: ");
        int id1 = sc.nextInt();

        System.out.print("Second User ID: ");
        int id2 = sc.nextInt();

        User u1 = find(id1);
        User u2 = find(id2);

        if (u1 == null || u2 == null || u1 == u2) {
            System.out.println("Invalid users.");
            return;
        }

        if (!u1.friends.contains(id2)) {
            u1.friends.add(id2);
        }

        if (!u2.friends.contains(id1)) {
            u2.friends.add(id1);
        }

        System.out.println("Friend connection added.");
    }

    static void removeConnection() {
        System.out.print("First User ID: ");
        int id1 = sc.nextInt();

        System.out.print("Second User ID: ");
        int id2 = sc.nextInt();

        User u1 = find(id1);
        User u2 = find(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        u1.friends.remove(Integer.valueOf(id2));
        u2.friends.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed.");
    }

    static void mutualFriends() {
        System.out.print("First User ID: ");
        User u1 = find(sc.nextInt());

        System.out.print("Second User ID: ");
        User u2 = find(sc.nextInt());

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        boolean found = false;

        System.out.println("Mutual Friends:");

        for (int id : u1.friends) {
            if (u2.friends.contains(id)) {
                User friend = find(id);

                if (friend != null) {
                    System.out.println(friend.id + " | " + friend.name);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No mutual friends.");
        }
    }

    static void showFriends() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        User user = find(id);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");

        for (int friendId : user.friends) {
            User friend = find(friendId);

            if (friend != null) {
                System.out.println(friend.id + " | " + friend.name);
            }
        }
    }

    static void searchUser() {
        sc.nextLine();

        System.out.print("Search by (1) Name (2) ID: ");
        int type = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        if (type == 1) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            for (User temp = head; temp != null; temp = temp.next) {
                if (temp.name.equalsIgnoreCase(name)) {
                    print(temp);
                    found = true;
                }
            }
        } else {
            System.out.print("Enter ID: ");
            User user = find(sc.nextInt());

            if (user != null) {
                print(user);
                found = true;
            }
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }

    static void countFriends() {
        for (User temp = head; temp != null; temp = temp.next) {
            System.out.println(
                    temp.name + " (ID " + temp.id + "): " +
                            temp.friends.size() + " friends"
            );
        }
    }

    static void displayUsers() {
        for (User temp = head; temp != null; temp = temp.next) {
            print(temp);
        }
    }

    static void print(User user) {
        System.out.println(
                user.id + " | " +
                        user.name + " | Age: " +
                        user.age
        );
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== SOCIAL MEDIA FRIEND CONNECTIONS =====");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends");
            System.out.println("8. Display All Users");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    addConnection();
                    break;
                case 3:
                    removeConnection();
                    break;
                case 4:
                    mutualFriends();
                    break;
                case 5:
                    showFriends();
                    break;
                case 6:
                    searchUser();
                    break;
                case 7:
                    countFriends();
                    break;
                case 8:
                    displayUsers();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
