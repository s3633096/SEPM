import java.util.Scanner;

public final class MenuSystem {
	
	private Scanner userInputScanner;
	private User[] users = new User[5];
	private User active_user;
	
	
	public MenuSystem() {
		this.userInputScanner = new Scanner(System.in);

		SeedUsers();
	}
	
	public void Start() {
		int option = 0;

		while (option != 3) {
			System.out.println("Please select from the following options:");
			System.out.println("1) Login User");
			System.out.println("2) Reset Password");
			System.out.println("3) Exit");
			
			option = captureInputInt("");
		
			if (option == 1) {
				Login();
			}
			
			else if (option == 2){
				PasswordReset();
			}
			
			else Exit();
		}
	}

	
	private void SeedUsers() {
		users[0] = new User("harry_styles@cinco.com", "Harry Styles", "0400123456", "123abcABC123abcABC12");
		users[1] = new User("niall_horan@cinco.com", "Niall Horan", "0400125555", "456defDEF456defDEF45");
		users[2] = new User("liam_payne@cinco.com", "Liam Payne", "0404123499", "789ghiGHI789ghiGHI78");
		users[3] = new User("louis_tomlinson@cinco.com", "Louis Tomlinson", "0407126456", "cba321CBA321cbaCBA32");
		users[4] = new User("zayn_malik@cinco.com", "Zayn Malik", "0411223456", "654fedFED654fedFED65");
	}
	
	private void Login() {

		String email = captureInputString("Username: ");
		String password = captureInputString("Password: ");

		for (int i = 0; i < users.length; i++) {
			if (email.trim().toLowerCase().equals(users[i].getEmail())) {
				if (password.equals(users[i].getPassword())) {
					active_user = users[i];
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
		System.out.println("-------------------------");
		System.out.println(" Welcome " + active_user.getEmail() );
		System.out.println("-------------------------");

		int option = 0;

		while (option != 3) {
			System.out.println("Please select from the following options:");
			System.out.println("1) Create a Ticket");
			System.out.println("2) Change your password");
			System.out.println("3) Log Out");

			option = captureInputInt("");
			
			if (option == 1) {
				CreateTicket();
			}
			if (option == 2) {
				ChangePassword();
			}
			else {
				active_user = null;
				System.out.println("Logging out...");
				return;
			}
		}

	}

	private void PasswordReset() {
		System.out.println("Please provide the email for the account");
		String reset_email = captureInputString("> ");

		System.out.println("A temporary password has been sent to : " + reset_email);

		return;
	}
	
	private void ChangePassword() {
		System.out.println("Please enter a new password for " + active_user.getEmail());
		String newPassword = captureInputString("> ");

		if (validatePassword(newPassword)) {
			active_user.setPassword(newPassword);
			System.out.println("Password successfully changed");
			return;
		}

		else {
			System.out.println("Password not updated as it didn't meet the required conditions");
			System.out.println("Password must contain a minimum of 20 characters, including 1 upper case character,"
					+ " 1 lower case character, and 1 number.");
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

		System.out.println("The ticket has been added to the queue");

		ShowWelcomeScreen();
	}

	private int captureInputInt(String userMessage) {
		// handles the user input and returns an int
		System.out.print(userMessage + " ");
		
		int capturedInt;
		try {
			capturedInt = userInputScanner.nextInt();
			return capturedInt;
		} catch (Exception ex) {
			showInvalidOption();
			userInputScanner.nextLine();
			return 0;
		}

	}
	
	private String captureInputString(String userMessage) {
		// handles the user input and returns a string
		System.out.print(userMessage + " ");
		
		String capturedStr;
		try {
			capturedStr = userInputScanner.next();
			return capturedStr;
		} catch (Exception ex) {
			showInvalidOption();
			userInputScanner.nextLine();
			return "";
		}
	}
	
	private void showInvalidOption() {
		System.out.println("Please select a valid menu option.");
	}

	private void Exit() {
		System.out.println("Exiting application...");
		return;
	}

}
