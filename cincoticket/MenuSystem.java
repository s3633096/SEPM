import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
		tickets.add(new Ticket("High severity test ticket", 1, "harry_styles@cinco.com"));
		tickets.add(new Ticket("High severity test ticket", 1, "harry_styles@cinco.com"));
		tickets.add(new Ticket("Low severity test ticket", 3, "harry_styles@cinco.com"));

		tickets.add(new Ticket("Low severity test ticket", 3, "niall_horan@cinco.com"));
		tickets.add(new Ticket("Medium severity test ticket", 2, "niall_horan@cinco.com"));
		tickets.add(new Ticket("Low severity test ticket", 3, "niall_horan@cinco.com"));

		tickets.add(new Ticket("Medium severity test ticket", 2, "liam_payne@cinco.com"));
		tickets.add(new Ticket("Medium severity test ticket", 2, "liam_payne@cinco.com"));
		tickets.add(new Ticket("Low severity test ticket", 3, "liam_payne@cinco.com"));

		tickets.add(new Ticket("High severity test ticket", 1, "louis_tomlinson@cinco.com"));
		tickets.add(new Ticket("Medium severity test ticket", 2, "louis_tomlinson@cinco.com"));
		tickets.add(new Ticket("Low severity test ticket", 3, "louis_tomlinson@cinco.com"));

		tickets.add(new Ticket("High severity test ticket", 1, "zayn_malik@cinco.com"));
		tickets.add(new Ticket("Medium severity test ticket", 2, "zayn_malik@cinco.com"));
		tickets.add(new Ticket("Low severity test ticket", 3, "zayn_malik@cinco.com"));
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

		String email = captureInputString("Username: ");
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
			System.out.println(" Welcome " + active_user.getEmail() );
			System.out.println("------------------------------------------");

			int option = 0;

			while (option != 3) {
				if (active_user == null) {
					return;
				}
				System.out.println("");
				System.out.println("Please select from the following options:");
				if(!active_user.isTech()) {
					System.out.println("1) Create a Ticket");
				}
				else if(active_user.isTech()) {
					System.out.println("1) View open tickets");
				}
	
				System.out.println("2) Change your password");
				System.out.println("3) Log Out");
	
				option = captureInputInt("");
				
				if (option == 1) {
					if(!active_user.isTech()) {
						CreateTicket();
					}
					else {
						if (active_user.isTech()) {
							ShowOpenTickets();
						}
					}
				}
				else if (option == 2) {
					ChangePassword();
				}
				else if (option == 3){
					active_user = null;
					System.out.println("Logging out...");
				}
				else {
					showInvalidOption();
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

		this.tickets.add(new Ticket(input_description, input_priority, active_user.getEmail()));

		System.out.println("The ticket has been added to the queue.");

		ShowOpenTickets();
	}

	private void ShowOpenTickets() {
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("The following tickets are assigned to you:");

		this.tickets.sort((t1, t2) -> t1.getSeverity() - t2.getSeverity());

		for (Ticket t : tickets) {
			if (t.getOwnerEmail().equals(this.active_user.getEmail())) {
				System.out.println(t.getSeverity() + ") " + t.getDescription());
			}
		}
		System.out.println("");

		ShowWelcomeScreen();
	}

	private int captureInputInt(String userMessage) {
		// handles the user input and returns an int
		System.out.print(userMessage + " ");
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
		System.out.print(userMessage + " ");

		this.userInputScanner = new Scanner(System.in);
		String capturedStr;
		try {
			capturedStr = userInputScanner.nextLine();
			return capturedStr;
		} catch (Exception ex) {
			showInvalidOption();
			userInputScanner.nextLine();
			return "";
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
