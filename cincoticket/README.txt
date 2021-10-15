## INTRODUCTION
This is the project folder for the CincoTickets Support 
ticketing system.  This file describes how to build and run the project.

## DEPENDENCIES
This project requires a JDK environment of 8 or higher
TO acquire packages for your system please see:
https://openjdk.java.net

## BUILD
javac *.java

## RUN
java -cp . JavaApp

## LOGIN

To use the system login menu: 
1. Copy the files to your desktop folder
2. Open Terminal
3. Input: cd Desktop
4. Press Enter
5. Input: javac JavaApp.java
6. Press Enter
7. Input: java JavaApp
8. Press Enter
9. To log into an account, select 1 from the menu.
**The following username and password
combinations can be used to login:
harry_styles@cinco.com : 123abcABC123abcABC12
niall_horan@cinco.com : 456defDEF456defDEF45
**
10. Copy (command c) the email for username. 
11. Paste item (command v) in Terminal and press Enter
12. Copy the corresponding password and paste in Terminal. Press Enter
13. From the user menu select 1

## CLIENT TESTING
To test the Admin feature 'Create a ticket' please login with
username: harry_styles@cinco.com 
password: 123abcABC123abcABC12
From the Welcome Screen choose (1) Create a Ticket.
The system will prompt for a description and severity rating
Once the ticket has been create it will be added to the admins queue 
pending assignment to a technician.  The list of tickets is 
shown when a new ticket is created.

To test the Technician feature 'View open tickets' please login with
username: niall_horan@cinco.com
password: 456defDEF456defDEF45
From the Welcome Screen choose (1) View Open Tickets.
The system with then list all open tickets assigned to the user
in order of severity. 
