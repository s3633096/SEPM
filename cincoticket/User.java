
public class User {
	private String email;
	private String name;
	private String phone;
	private String password;
	private boolean isAdmin;
	private boolean isTech;
	
	public User(String email, String name, String phone, String password, boolean isAdmin, boolean isTech) {
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isTech = isTech;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public boolean isTech() {
		return isTech;
	}
}
