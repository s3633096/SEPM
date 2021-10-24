## INTRODUCTION
This is the project folder for the CincoTickets Support ticketing system.
This file describes how to build and run the project.


## DEPENDENCIES
This project requires a JDK environment of 8 or higher. To acquire
packages for your system please see: https://openjdk.java.net


## BUILD & RUN
1. Extract all files from cincotickets.zip to a directory of your choice
2. Using the terminal, change directory to the path where you extracted 
   the files using command > cd [your directory path]
3. Enter the command > javac *.java
   The application files are now compiled and ready to use.
4. To run the application, enter the command > java JavaApp
5. You should be presented with the initial application menu.


## USE
### Account Creation: Staff Members
From the main menu, select option '1' to create a staff member account.
Enter the required information in to the prompts, and if validated
correctly (see password requirements further below), you will now be able
to login as a staff member using these credentials.

*Note that as we have not implemented a database yet, new accounts will 
only pertain to the current session of the application.


### Logging In: Technicians or Staff Members
From the main menu, select option '2' to Login as either a Technician
or a staff member. For staff members, an account can be created as per
above and then those credentials used to log in. Alternatively, we have
provided 2 hardcoded user accounts already in the system that can
be used for testing:

- Email:      john_citizen@cinco.com
  Password:   ZXCVBNMasdfghjkl123456
  
- Email:      fred_jones@cinco.com
  Password:   ASDFGHJKqwertyu1234678

Simply enter the email and password in to the relevant prompts.
If entered correctly, the user will be directed to their menu,
which differs depending if the user is a Technician or a Staff
Member.

To log in as a technician, see below a list of account details.


### Accounts: Technicians
The following credentials are currently hardcoded
and can be used to access technician accounts.
Their technician levels are also noted below.

- Email:      harry_styles@cinco.com
  Password:   123abcABC123abcABC12
  Level:      1

- Email:      niall_horan@cinco.com
  Password:   456defDEF456defDEF45
  Level:      1

- Email:      liam_payne@cinco.com
  Password:   789ghiGHI789ghiGHI78
  Level:      1

- Email:      louis_tomlinson@cinco.com
  Password:   cba321CBA321cbaCBA32
  Level:      2

- Email:      zayn_malik@cinco.com
  Password:   654fedFED654fedFED65
  Level:      2


### Create a Ticket: Staff Members
To create a ticket, log in as a staff member (use a staff hardcoded account 
listed above or alternatively create one using menu option '1' on the 
initial menu).

Once logged in, choose menu option '1'. You will be prompted to enter a 
description and a severity level. The ticket will be created in an 'Open'
state, and remain unassigned until claimed by a technician (yet to be 
implemented). To view the newly created ticket, from the Staff Members main menu,
select option '2'. It will be displayed in this list (note that tickets are sorted 
by severity).


### Change Password: Technicians or Staff Members
Whilst logged out, from the main menu, select option 3) Change Password. 
Enter the email address for the account whose password you want to change
and then enter and confirm the new password in the following prompts.
Passwords must comply with validation requirements (see below).

Additionally, whilst logged in, the active user can change their password 
by choosing option '3' Change your Password from their menu. The same rules 
as above apply.

*Note that as we have not implemented a database yet, password changes will 
only pertain to the current session of the application.


### Password validation requirements
The current password requirements for the application are as follows:
- Must be a minimum length of 20 characters
- Must contain at least 1 upper case character
- Must contain at least 1 lower case character
- Must contain at least 1 number


### Viewing and Closing Tickets: Technicians
When logged in as a Technician, you can see all open tickets assigned the 
Technician using option '1' (Hardcoded sample tickets while we implement the 
functionality, for testing purposes). From here, tickets can be marked as closed by
following the menu prompts.
To view all closed tickets (regardless of assignment), use menu option '4'
when logged in as a Technician.


### Generating a report: Technicians
To generate a report of all tickets during a specified time range, select 
option '3' from main menu. Now enter a start and end date in the format specified and the
system will generate a report of tickets created in the date range, 
differentiated by Resolved or Unresolved (Open or Closed). For resolved 
tickets it will display the email of the staff member who submitted the ticket, 
the email of the technician it was assigned to, and the time taken between creation and 
resolution in days. 
For outstanding tickets, the report will indicate the email of the staff member 
who submitted the ticket, date when it was submitted, and the severity it has been 
classified with.

