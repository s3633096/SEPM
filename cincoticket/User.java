
public class User {
	private String email;
	private String name;
	private String phone;
	private String password;
	
	public User(String email, String name, String phone, String password) {
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.password = password;
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
}
