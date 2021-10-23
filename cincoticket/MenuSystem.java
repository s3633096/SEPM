import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class MenuSystem {
	
	private Scanner userInputScanner;
	private List<User> users = new ArrayList<User>();
	private List<Ticket> tickets = new ArrayList<Ticket>();
	private User active_user;
	
	public MenuSystem() {
		this.userInputScanner = new Scanner(System.in);
		SeedUsers();
		SeedTickets();
	}
	
	public void Start() {
		int option = 0;

		while (option != 4) {
			System.out.println("Please select from the following options:");
			System.out.println("1) Create Staff Account");
			System.out.println("2) Login");
			System.out.println("3) Change Password");
			System.out.println("4) Exit");
			
			option = captureInputInt("");
			if (option == 1) {
				CreateStaffAccount();
			}
			else if (option == 2) {
				Login();
			}
			else if (option == 3) {
				ChangePassword();
			}
			else if (option == 4)
				Exit();
			else {
				showInvalidOption();
			}
		}
	}

	private void SeedUsers() {
		//Techs as mentioned in spec sheet
		users.add(new User("harry_styles@cinco.com", "Harry Styles", "0400123456", "123abcABC123abcABC12", 1));
		users.add(new User("niall_horan@cinco.com", "Niall Horan", "0400125555", "456defDEF456defDEF45", 1));
		users.add(new User("liam_payne@cinco.com", "Liam Payne", "0404123499", "789ghiGHI789ghiGHI78", 1));
		users.add(new User("louis_tomlinson@cinco.com", "Louis Tomlinson", "0407126456", "cba321CBA321cbaCBA32", 2));
		users.add(new User("zayn_malik@cinco.com", "Zayn Malik", "0411223456", "654fedFED654fedFED65", 2));
		
		//Sample Staff Members
		users.add(new User("john_citizen@cinco.com", "John Citizen", "0400444666", "ZXCVBNMasdfghjkl123456", 0));
		users.add(new User("fred_jones@cinco.com", "Fred Jones", "0400555899", "ASDFGHJKqwertyu1234678", 0));
	}

	private void SeedTickets() {
		tickets.add(new Ticket("High severity test ticket", 1, "john_citizen@cinco.com", "harry_styles@cinco.com", LocalDate.parse("2021-10-20")));
		tickets.add(new Ticket("High severity test ticket", 1, "fred_jones@cinco.com", "harry_styles@cinco.com", LocalDate.parse("2021-06-01")));
		tickets.add(new Ticket("Low severity test ticket", 3, "john_citizen@cinco.com", "harry_styles@cinco.com", LocalDate.parse("2021-09-01")));

		tickets.add(new Ticket("Low severity test ticket", 3, "fred_jones@cinco.com", "niall_horan@cinco.com", LocalDate.parse("2021-10-20")));
		tickets.add(new Ticket("Medium severity test ticket", 2, "john_citizen@cinco.com", "niall_horan@cinco.com", LocalDate.parse("2021-06-01")));
		tickets.add(new Ticket("Low severity test ticket", 3, "fred_jones@cinco.com", "niall_horan@cinco.com", LocalDate.parse("2021-09-01")));

		tickets.add(new Ticket("Medium severity test ticket", 2, "john_citizen@cinco.com", "liam_payne@cinco.com", LocalDate.parse("2021-10-20")));
		tickets.add(new Ticket("Medium severity test ticket", 2, "fred_jones@cinco.com", "liam_payne@cinco.com", LocalDate.parse("2021-06-01")));
		tickets.add(new Ticket("Low severity test ticket", 3, "john_citizen@cinco.com", "liam_payne@cinco.com", LocalDate.parse("2021-09-01")));

		tickets.add(new Ticket("High severity test ticket", 1, "fred_jones@cinco.com", "louis_tomlinson@cinco.com", LocalDate.parse("2021-10-20")));
		tickets.add(new Ticket("Medium severity test ticket", 2, "john_citizen@cinco.com", "louis_tomlinson@cinco.com", LocalDate.parse("2021-06-01")));
		tickets.add(new Ticket("Low severity test ticket", 3, "fred_jones@cinco.com", "louis_tomlinson@cinco.com", LocalDate.parse("2021-09-01")));

		tickets.add(new Ticket("High severity test ticket", 1, "john_citizen@cinco.com", "zayn_malik@cinco.com", LocalDate.parse("2021-10-20")));
		tickets.add(new Ticket("Medium severity test ticket", 2, "fred_jones@cinco.com", "zayn_malik@cinco.com", LocalDate.parse("2021-06-01")));
		tickets.add(new Ticket("Low severity test ticket", 3, "john_citizen@cinco.com", "zayn_malik@cinco.com", LocalDate.parse("2021-09-01")));
		
		tickets.get(0).setStatus(TicketStatus.CLOSED_RESOLVED);
		tickets.get(4).setStatus(TicketStatus.CLOSED_UNRESOLVED);
		tickets.get(7).setStatus(TicketStatus.CLOSED_RESOLVED);
	}

	private void CreateStaffAccount() {
		System.out.println("Enter account creation details below.");
		String input_email = captureInputString("Email Address: ");
		String input_name = captureInputString("Full Name: ");
		String input_phone = captureInputString("Phone Number: ");
		
		System.out.println("Now choose a password with a minimum length of 20 characters, "
				+ "including 1 uppercase letter, 1 lowercase letter, and 1 number.");

		boolean passwordConfirmed = false;
		String input_password = "";
		
		while (passwordConfirmed == false) {
			input_password = captureInputString("Enter Password: ");
			while (!validatePassword(input_password)) {
				System.out.println("Password did not meet the required conditions. Please enter a "
						+ "password with a minimum length of 20 characters, including at least 1 "
						+ "uppercase letter, 1 lowercase letter, and 1 number.");
				input_password = captureInputString("Enter Password: ");
			}
			
			String input_password_confirm = captureInputString("Confirm Password: ");
			
			if (input_password_confirm.equals(input_password)) {
				passwordConfirmed = true;
			}
			else {
				System.out.println("Passwords did not match. Please try again.");
			}
		}
		
		users.add(new User(input_email, input_name, input_phone, input_password, 0));
		System.out.println(String.format("\nStaff account created successfully.\nEmail: %s\nName: %s\nPhone: "
				+ "%s\nPassword: %s\n", input_email, input_name, input_phone, input_password));
	}
	
	private void Login() {

		String email = captureInputString("Username / Email: ");
		String password = captureInputString("Password: ");

		for (User u : users) {
			if (email.trim().toLowerCase().equals(u.getEmail())) {
				if (password.equals(u.getPassword())) {
					active_user = u;
				}
				else break;
			}
		}

		if (active_user != null) {
			// Successful login;
			ShowWelcomeScreen();
		} else {
			System.out.println("Unable to login with provided credentials");
			return;
		}
	}

	private void ShowWelcomeScreen() {
		if (active_user != null) {
			System.out.println("");
			System.out.println("------------------------------------------");
			System.out.println(" Welcome, " + active_user.getName() );
			System.out.println("------------------------------------------");

			int option = 0;
			int logoutOption;
			if (active_user.isTech()) {
				logoutOption = 5;
			}
			else {
				logoutOption = 4;
			}
			
			
			while (option != logoutOption) {
				if (active_user == null) {
					return;
				}
				System.out.println("");
				System.out.println("Please select from the following options:");
				if(!active_user.isTech()) {
					System.out.println("1) Create a Ticket");
					System.out.println("2) View your open tickets");					
					System.out.println("3) Change your password");
					System.out.println("4) Log Out");
				}
				else if(active_user.isTech()) {
					System.out.println("1) View your open tickets");
					System.out.println("2) Change your password");
					System.out.println("3) Create Ticket Report");
					System.out.println("4) View all closed Tickets");
					System.out.println("5) Log Out");
				}
				
	
				option = captureInputInt("");

				if(!active_user.isTech()) {
					if (option == 1) {
						CreateTicket();
					}
					else if (option == 2) {
						ShowUserTickets();
					}
					else if (option == 3) {
						ChangePassword();
					}
					else if (option == 4){
						active_user = null;
						System.out.println("Logging out...");
					}
					else {
						showInvalidOption();
					}
				}
				else {
					if (option == 1) {
						ShowUserTickets();
					}
					else if (option == 2) {
						ChangePassword();
					}
					else if (option == 3) {
						ShowTicketReport();
					}
					else if (option == 4){
						ShowClosedTickets();
					}
					else if (option == 5) {
						active_user = null;
						System.out.println("Logging out...");						
					}
					else {
						showInvalidOption();
					}
				}
			}
			return;
		}
	}
	
	private void ChangePassword() {
		String recovery_email;
		User user = null;
		
		if(active_user != null) {
			user = active_user;
		}
		else {
			System.out.println("");
			recovery_email = captureInputString("Please enter your account email: ").trim().toLowerCase();
			
			for (User u : users) {
				if (recovery_email.equals(u.getEmail())) {
					user = u;
					break;
				}
			}
			
			if (user == null) {
				System.out.println("Unable to find a user account with that email\n");
				return;
			}
		}		


		System.out.println("Please enter a new password for " + user.getEmail() + ".\n Password must contain a "
				+ "minimum of 20 characters, including 1 upper case character, 1 lower case character, and 1 number.\n");
		String newPassword = captureInputString("> ");

		if (validatePassword(newPassword)) {
			user.setPassword(newPassword);
			System.out.println("Password successfully changed\n");
			return;
		}

		else {
			System.out.println("Password not updated as it didn't meet the required conditions");
			System.out.println("Password must contain a minimum of 20 characters, including 1 upper case character,"
					+ " 1 lower case character, and 1 number.\n");
			return;
		}
	}
	
	private boolean validatePassword(String password) {
		// Min 20 chars, at least 1 upper case, 1 lower case and 1 number
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{20,}$";
		
		if (password.matches(regex)) 
			return true;
		
		else 
			return false;
	}

	private void CreateTicket() {
		System.out.println("Please enter the details for the ticket:");

		String input_description = captureInputString("Description: ");

		int input_priority = captureInputInt("Priority: 1 (high), 2 (med), 3 (low)");

		this.tickets.add(
			new Ticket(input_description, input_priority, active_user.getEmail(), "", LocalDate.now())
		);

		System.out.println("The ticket has been added to the queue.");

		ShowUserTickets();
	}

	private void ShowUserTickets() {
		System.out.println("");
		System.out.println("------------------------------------------");
		if (active_user.isTech()) {
			System.out.println("Assigned Tickets (ordered by severity):\n");
		}
		else {
			System.out.println("Currently Open Tickets (ordered by severity):\n");
		}
		
		this.tickets.sort((t1, t2) -> t1.getSeverity() - t2.getSeverity());
		this.tickets.sort((t1, t2) -> t1.getStatus().compareTo(t2.getStatus()));

		List<Ticket> usersTickets = new ArrayList<Ticket>();
		if (active_user.isTech()) {
			int i = 1; // matches ticket index in list
			for (Ticket t : tickets) {
				if (t.getOwnerEmail().equals(this.active_user.getEmail()) && t.getStatus() == TicketStatus.OPEN) {
					usersTickets.add(t);
					System.out.println("#" + i +" "+ t.getDescription() + " | Severity: " + t.getSeverityString() +
							" | Status: " + t.getStatus() + "\n");
					i++;
				}
			}
		
		
			System.out.println("1) Change a Ticket Status");
			System.out.println("2) Return to main menu");

			Integer menuSelection = captureInputInt("");
			if (menuSelection == 1) {
				Integer ticketNumber = captureInputInt("Please type the ticket Number:") - 1;

				Ticket selectedTicket = null;
				try {
					selectedTicket = usersTickets.get(ticketNumber);
				} catch (Exception e) {
					System.out.println("Invalid ticket selection");
				}

				if (selectedTicket != null) {
					System.out.println("");
					System.out.println(selectedTicket.getDescription() +" Status: " + selectedTicket.getStatus().toString());

					System.out.println("1) Set Ticket Status to UNRESOLVED");
					System.out.println("2) Set Ticket Status to RESOLVED");
					System.out.println("3) Return to main menu");

					menuSelection = captureInputInt("");

					if (menuSelection == 1) {
						selectedTicket.setStatus(TicketStatus.CLOSED_UNRESOLVED);
						System.out.println("Ticket Status set to UNRESOLVED");
					}

					else if (menuSelection == 2) {
						selectedTicket.setStatus(TicketStatus.CLOSED_RESOLVED);
						System.out.println("Ticket Status set to RESOLVED");
					}

					else if (menuSelection == 3) {
						return;
					}


				} else {
					System.out.println("Invalid ticket");
				}
			} else {
				return;
			}
		}
		
		else {
			int i = 1; // matches ticket index in list
			for (Ticket t : tickets) {
				if (t.getCreatedByEmail().equals(this.active_user.getEmail()) && t.getStatus() == TicketStatus.OPEN) {
					usersTickets.add(t);
					System.out.println("#" + i +" "+ t.getDescription() + " | Severity: " + t.getSeverityString() +
							" | Status: " + t.getStatus() + "\n");
					i++;
				}
			}
			
			System.out.println("1) Return to main menu");
			Integer menuSelection = captureInputInt("");
			if (menuSelection == 1) {
				return;
			}
			else {
				return;
			}
		}

	}
	
	private void ShowClosedTickets() {
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("All closed and archived tickets:\n(Ordered by severity)\n");
		
		this.tickets.sort((t1, t2) -> t1.getSeverity() - t2.getSeverity());
		this.tickets.sort((t1, t2) -> t1.getStatus().compareTo(t2.getStatus()));

		int i = 1; // matches ticket index in list
		for (Ticket t : tickets) {
			if (t.getOwnerEmail().equals(this.active_user.getEmail()) && t.getStatus() != TicketStatus.OPEN) {
				System.out.println("#" + i +" "+ t.getDescription() + " | Severity: " + t.getSeverityString() +
						" | Status: " + t.getStatus() + "\n");
				i++;
			}
		}
		
		System.out.println("1) Return to main menu");
		Integer menuSelection = captureInputInt("");
		if (menuSelection == 1) {
			return;
		}
		else {
			return;
		}
	}

	private void ShowTicketReport() {
		System.out.println("");
		System.out.println("---------------------");
		System.out.println("Ticket Report");
		System.out.println("---------------------");

		System.out.println("Please enter a starting date for the reporting range as YYYY-MM-DD");
		LocalDate startDate = captureInputDate("");

		System.out.println("Please enter an ending date for the reporting range as YYYY-MM-DD");
		LocalDate endDate = captureInputDate("");

		if (startDate.isAfter(endDate)) {
			System.out.println("Start date is after end date\n");
			return;
		}

		System.out.println("\n------------------------------------------------------------");
		System.out.println("Report range set between " + startDate.toString() + " and " + endDate.toString() +"\n");

		List<Ticket> reportTickets = new ArrayList<Ticket>();

		for (Ticket t : tickets) {
			if (t.getCreatedDate().isAfter(startDate) || t.getCreatedDate().isEqual(startDate)) {
				if (t.getCreatedDate().isBefore(endDate) || t.getCreatedDate().isEqual(endDate)) {
					reportTickets.add(t);
				}
			}
		}
		
		System.out.println("A total of " + reportTickets.size() + " have been created in this timeframe\n");
		System.out.println("Unresolved:");
		int unresolvedCount = 0;
		for (Ticket t : reportTickets) {
			if (t.getStatus() == TicketStatus.OPEN) {
				System.out.println(t.getDescription() + " \nCreated by: " 
					+ t.getCreatedByEmail() + " on " + t.getCreatedDate().toString() 
					+ " Severity: " + t.getSeverityString() + "\n");
				unresolvedCount++;
			}
		}

		System.out.println("Resolved:");
		int resolvedCount = 0;
		for (Ticket t : reportTickets) {
			if (t.getStatus() == TicketStatus.CLOSED_RESOLVED) {
				if (t.getStatus() == TicketStatus.CLOSED_RESOLVED) resolvedCount++;

				System.out.println(t.getDescription() + " \nSubmitted By: " + t.getCreatedByEmail() 
					+ " on " + t.getCreatedDate().toString() +" \nand took " 
					+ ChronoUnit.DAYS.between(t.getCreatedDate(), t.getResolvedDate()) 
					+" days to resolve on: " + t.getResolvedDate().toString()+ " by: " + t.getOwnerEmail() + "\n");
			}
		}

		System.out.println("Unresolved Tickets:" + unresolvedCount + " Resolved tickets: " + resolvedCount);
		System.out.println("------------------------------------------------------------\n\n");

		return;
	}

	private int captureInputInt(String userMessage) {
		// handles the user input and returns an int
		if (userMessage.length() > 0) {
			System.out.print(userMessage + " ");
		}

		this.userInputScanner = new Scanner(System.in);
		int capturedInt;
		try {
			capturedInt = userInputScanner.nextInt();
			return capturedInt;
		} catch (Exception ex) {
			userInputScanner.nextLine();
			return 0;
		}

	}
	
	private String captureInputString(String userMessage) {
		// handles the user input and returns a string
		if (userMessage.length() > 0) {
			System.out.print(userMessage + " ");
		}

		this.userInputScanner = new Scanner(System.in);
		String capturedStr;
		try {
			capturedStr = userInputScanner.nextLine().trim();
			return capturedStr;
		} catch (Exception ex) {
			showInvalidOption();
			userInputScanner.nextLine();
			return "";
		}
	}

	private LocalDate captureInputDate(String userMessage) {
		// handles the user input and returns a Date object
		if (userMessage.length() > 0) {
			System.out.print(userMessage + " ");
		}

		this.userInputScanner = new Scanner(System.in);
		String capturedStr;
		try {
			capturedStr = userInputScanner.nextLine().trim();
			return LocalDate.parse(capturedStr);
		} catch (Exception ex) {
			System.out.print("Please enter a valid date YYYY-MM-DD");
			userInputScanner.nextLine();
			return null;
		}
	}

	private void showInvalidOption() {
		System.out.println("Invalid menu option.");
	}

	private void Exit() {
		System.out.println("Exiting application...");
		return;
	}

}
