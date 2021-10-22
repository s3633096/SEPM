## INTRODUCTION
This is the project folder for the CincoTickets Support ticketing system.
This file describes how to build and run the project.

## DEPENDENCIES
This project requires a JDK environment of 8 or higher. To acquire
packages for your system please see: https://openjdk.java.net

## BUILD
javac *.java

## RUN
java -cp . JavaApp

## USE
### Staff Member Account Creation
From the main menu, select option '1' to create a staff member account.
Enter the required information in to the prompts, and if validated
correctly (see password requirements below), you will now be able
to login as a staff member using these credentials.

### Logging In
From the main menu, select option '2' to Login as either a Technician
or a staff member. For staff members, an account can be created as per
above and then those credentials used to log in. Alternatively, we have
provided 2 hardcoded user accounts already in the system for that can
be used for testing:

- Email: 	john_citizen@cinco.com
  Password: 	ZXCVBNMasdfghjkl123456
  
- Email:	fred_jones@cinco.com
  Password:	ASDFGHJKqwertyu1234678
		
To log in as a technician, see below a list of account details.

### Technician Accounts
The following credentials are currently hardcoded
and can be used to access technician accounts.
Their technician levels are also noted below.

- Email: 	harry_styles@cinco.com
  Password: 	123abcABC123abcABC12
  Level:	1

- Email: 	niall_horan@cinco.com
  Password: 	456defDEF456defDEF45
  Level:	1

- Email: 	liam_payne@cinco.com
  Password: 	789ghiGHI789ghiGHI78
  Level:	1

- Email: 	louis_tomlinson@cinco.com
  Password: 	cba321CBA321cbaCBA32
  Level:	2

- Email: 	zayn_malik@cinco.com
  Password: 	654fedFED654fedFED65
  Level:	2

### Change Password
Whilst logged out, from the main menu, select option 3) Change Password. 
Enter the email address for the account whose password you want to change
and then enter and confirm the new password in the following prompts.
Passwords must comply with validation requirements (see below).

Additionally, whilst logged in, the active user can change their password 
by choosing option '3' Change your Password from their menu. The same rules 
as above apply.

### Password validation requirements
The current password requirements for Cinco are as follows:
- Must be a minimum length of 20 characters
- Must contain at least 1 uppercase character
- Must contain at least 1 lowercase character
- Must contain at least 1 number





*** BELOW IS FROM OLD README, REMOVE AFTER INTEGRATING WITH THE ABOVE ***

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
9. To log into an account, select 2 from the menu.
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
To test the Staff Member feature 'Create a ticket' please create a staff
account using option 1 on the main menu, then login using those credentials
with option 2.
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

To test the 'Change your Password' feature, login with a valid account listed
above, and then select option 2) Change your password. Required conditions
will be shown and the password will only change successfully if those conditions
are met. If it fails an error message will be shown and the user directed back to
their menu. If it succeeds a success message will be shown and now future logins 
for this user will use the new password.
*Note that as we have not implemented a database yet, the change will only
pertain to the current session of the application.
