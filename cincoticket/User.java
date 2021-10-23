
public class User {
	private String email;
	private String name;
	private String phone;
	private String password;
	private int technician;
	
	public User(String email, String name, String phone, String password, int technician) {
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.technician = technician;
	}
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newPassword) {
		password = newPassword;
	}

	public int getTechnicianLevel() {
		return technician;
	}
	
	public boolean isTech() {
		if (technician > 0) 
			return true;
		else 
			return false;
	}
}
