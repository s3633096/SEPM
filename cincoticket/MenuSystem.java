public final class MenuSystem {
	
	private User[] users = new User[5];
	
	public MenuSystem() {
		SeedUsers();
	}
	
	public void Start() {
		System.out.println("Please select from the following options:");
	}

	
	private void SeedUsers() {
		users[0] = new User("harry_styles@cinco.com", "Harry Styles", "0400123456", "123abc");
		users[1] = new User("niall_horan@cinco.com", "Niall Horan", "0400125555", "456def");
		users[2] = new User("liam_payne@cinco.com", "Liam Payne", "0404123499", "789ghi");
		users[3] = new User("louis_tomlinson@cinco.com", "Louis Tomlinson", "0407126456", "abc321");
		users[4] = new User("zayn_malik@cinco.com", "Zayn Malik", "0411223456", "654fed");
	}
	
	private User Login(String email, String password) {
		for (int i = 0; i < users.length; i++) {
			if (email == users[i].getEmail()) {
				if (password == users[i].getPassword()) {
					return users[i];
				}
				else break;
			}
		}
		return null;
	}
}