package nju.software.jxjs.view;

/**
 * 存放于session的统一用户bean
 * @author Administrator
 *
 */
public class User {
	private String role;
	private String username;
	private String password;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
}