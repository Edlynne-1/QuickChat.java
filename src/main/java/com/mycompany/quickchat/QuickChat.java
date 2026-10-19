package com.mycompany.letschat;

import java.util.Scanner;

public class QuickChat {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to QuickChat.");

        // LOGIN FIRST
        System.out.println("Enter username:");
        String username = input.nextLine();

        System.out.println("Enter password:");
        String password = input.nextLine();

        // Dummy user for Part 2 (replace with Part 1 user)
        User user = new User("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyl", "Smith");

        Login login = new Login(user, username, password);

        if (!login.loginUser()) {
            System.out.println("Login failed. You cannot send messages.");
            return;
        }

        System.out.println("Login successful!");

        // Ask how many messages user wants to send
        System.out.println("How many messages do you want to enter?");
        int numMessages = input.nextInt();
        input.nextLine(); // clear buffer

        int messageCounter = 0;

        while (true) {

            System.out.println("\nChoose an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                if (messageCounter >= numMessages) {
                    System.out.println("You have reached your message limit.");
                    continue;
                }

                System.out.println("Enter recipient number:");
                String recipient = input.nextLine();

                System.out.println("Enter your message:");
                String msg = input.nextLine();

                messageCounter++;

                Message message = new Message(recipient, msg, messageCounter);

                // Validate message length
                System.out.println(message.validateMessageLength());

                // Validate recipient
                System.out.println(message.checkRecipientCell());

                // Choose send/store/discard
                System.out.println("Choose an option:");
                System.out.println("1) Send Message");
                System.out.println("2) Disregard Message");
                System.out.println("3) Store Message");

                int sendOption = input.nextInt();
                input.nextLine();

                System.out.println(message.SentMessage(sendOption));

                // Print full message details
                System.out.println("\nFULL MESSAGE DETAILS:");
                System.out.println(message.printMessages());

                // Show total messages sent
                System.out.println("\nTotal messages sent: " + message.returnTotalMessages());
            }

            else if (choice == 2) {
                System.out.println("Coming Soon.");
            }

            else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }

            else {
                System.out.println("Invalid option.");
            }
        }
    }
}
