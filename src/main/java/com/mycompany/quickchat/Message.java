

package com.mycompany.letschat;

import java.util.Random;

public class Message {

    public String messageID;
    public String recipient;
    public String message;
    public int messageNumber;
    public static int totalMessagesSent = 0;

    // Constructor
    public Message(String recipient, String message, int messageNumber) {
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber;
        this.messageID = generateMessageID();
    }

    // Generate a random 10-digit message ID
    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + rand.nextLong(9000000000L);
        return String.valueOf(id);
    }

    // Check message ID length
    public boolean checkMessageID() {
        return this.messageID.length() == 10;
    }

    // Check recipient number format (+27 and max 10 digits)
    public String checkRecipientCell() {
        if (this.recipient.matches("^\\+27[0-9]{1,10}$")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Create message hash: first 2 digits of ID : messageNumber : first+last words
    public String createMessageHash() {
        String firstTwo = this.messageID.substring(0, 2);
        String[] words = this.message.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        String hash = firstTwo + ":" + this.messageNumber + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    // Validate message length
    public String validateMessageLength() {
        if (this.message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extra = this.message.length() - 250;
            return "Message exceeds 250 characters by " + extra + "; please reduce the size.";
        }
    }

    // Send / Store / Discard message
    public String SentMessage(int option) {
        switch (option) {
            case 1:
                totalMessagesSent++;
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message";
            case 3:
                return "Message successfully stored.";
            default:
                return "Invalid option.";
        }
    }

    // Print full message details
    public String printMessages() {
        return "Message ID: " + this.messageID +
               "\nMessage Hash: " + this.createMessageHash() +
               "\nRecipient: " + this.recipient +
               "\nMessage: " + this.message;
    }

    // Return total messages sent
    public int returnTotalMessages() {
        return totalMessagesSent;
    }
}
