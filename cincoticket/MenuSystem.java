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
		System.out.println("Please select from the following options:");
		System.out.println("1) Login User");
		System.out.println("2) Reset Password");
		System.out.println("3) Exit");

		Integer option = captureInputInt("");

		if (option == 1) {
			Login();

		}
		else if (option == 2){
			PasswordReset();
		}
		else {
			Exit();
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
				if (password.trim().toLowerCase().equals(users[i].getPassword())) {
					active_user = users[i];
				}
				else break;
			}
		}

		if (active_user != null) {
			// Successfull login;
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
		System.out.println("Please select from the following options:");
		System.out.println("1) Create a Ticket");
		System.out.println("2) Exit");

		Integer option = captureInputInt("");

		if (option == 1) {
			CreateTicket();
		}
		else {
			Exit();
		}
	}

	private void PasswordReset() {
		System.out.println("Please provide the email for the account");
		String reset_email = captureInputString("> ");

		System.out.println("A temporary password has been sent to : " + reset_email);

		Start();
	}

	private void CreateTicket() {
		System.out.println("Please enter the details for the ticket:");

		String input_description = captureInputString("Description: ");

		int input_priority = captureInputInt("Priority: 1 (high), 2 (med), 3 (low)");

		System.out.println("The ticket has been added to the queue");

		ShowWelcomeScreen();
	}

	private int captureInputInt(String userMessage) {
		// handles the user input and returns and int
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
		return;
	}

}
