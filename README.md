QuickChat – Part 2 README Documentation
Student: Edlyn Seleke
Student Number: ST10507517
Module: PROG5121– Programming
Assignment: Part 2 – Sending Messages

1. Introduction
This document explains the design, functionality, and implementation of Part 2 of the QuickChat application.
Part 2 builds on the registration and login system created in Part 1 and introduces new features such as:

Sending messages
Validating message content
Generating unique message IDs
Creating message hashes
Storing or discarding messages
Displaying message details
Tracking total messages sent
Implementing a menu system
Ensuring users can only send messages after successful login
The goal of Part 2 is to demonstrate understanding of loops, string manipulation, validation, and object‑oriented programming.

2. System Overview
QuickChat now includes:
QuickChat.java – The main program for Part 2
Message.java – A new class responsible for message creation, validation, and tracking
User.java, Login.java, Registration.java – Reused from Part 1

The program flow is:
User logs in
If login succeeds → QuickChat menu appears
User chooses how many messages they want to send
User selects menu options (Send, Show Recent, Quit)
Messages are validated, processed, and displayed
Total messages sent is tracked and shown

3. Menu System
After login, the user sees:
Code
Welcome to QuickChat.
1) Send Messages
2) Show recently sent messages
3) Quit
Menu Requirements
The menu must repeat until the user chooses Quit

Option 2 must display “Coming Soon.”

Option 1 allows the user to send messages

The user can only send the number of messages they selected at the start

4. Message Class Overview
The Message.java class contains all logic for message creation and validation.

4.1 Attributes
messageID – A randomly generated 10‑digit number

recipient – The cellphone number of the message recipient

message – The actual message text

messageNumber – The index of the message (1st, 2nd, etc.)

totalMessagesSent – A static counter tracking all sent messages

5. Message Validation
5.1 Message ID
Must be exactly 10 digits
Automatically generated using Random
Used for tracking and hashing

5.2 Recipient Number
Recipient numbers must:

Start with +27

Contain 1–10 digits after +27

Be validated using regex

Why regex is used:  
Regex (Regular Expression) is a pattern‑matching tool used to validate text.
It ensures the recipient number follows the exact required format.

Example regex used:

Code
^\\+27[0-9]{1,10}$
This ensures:

The number begins with +27

Only digits follow

Length is correct

5.3 Message Length
Messages must:
Not exceed 250 characters

Return:

Success: “Message ready to send.”

Failure: “Message exceeds 250 characters by X; please reduce the size.”

6. Message Hash Generation
The Message Hash is a unique string created using:
The first two digits of the message ID
A colon
The message number
A colon
The first and last words of the message
Converted to uppercase

Example:

Code
00:0:HITHANKS
This hash helps identify messages quickly and uniquely.

7. Sending, Storing, and Discarding Messages
After writing a message, the user chooses:

Code
1) Send Message
2) Disregard Message
3) Store Message
The system returns:

Send: “Message successfully sent.”

Disregard: “Press 0 to delete the message”

Store: “Message successfully stored.”

If the user chooses Send, the total message counter increments.

8. Displaying Message Details
After each message is processed, the system prints:
Message ID
Message Hash
Recipient
Message

This ensures full transparency and allows the user to review their message.

9. Total Messages Sent
Once all messages have been sent, the system displays:
Code
Total messages sent: X
This value is tracked using a static counter inside the Message class.

10. Unit Testing Requirements
Part 2 requires several unit tests, including:
Message length validation
Recipient number validation
Message hash correctness
Message ID generation
Send/Store/Discard functionality
Total messages sent

Unit testing ensures:
The program works correctly
Errors are caught early
All requirements are met
Code quality is maintained

11. CI/CD (GitHub Actions)
The assignment requires setting up GitHub Actions to:
Automatically run tests whenever code is updated
Ensure continuous integration
Improve code reliability

This is part of modern software development practices.

12. Conclusion
Part 2 of QuickChat expands the application into a functional messaging system with:

Input validation
Message tracking
Hash generation
Menu navigation
User interaction
Automated testing

The system demonstrates strong understanding of loops, regex, object‑oriented programming, and user‑driven workflows.
