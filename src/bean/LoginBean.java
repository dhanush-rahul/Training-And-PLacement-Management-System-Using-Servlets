package bean;

public class LoginBean {
	
	private String username;
	private String password;
	private String role;
	private String stream;
	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password + ", role=" + role + ", stream=" + stream
				+ "]";
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
