package com.periodicals.models;

import com.periodicals.models.enums.Roles;

public class User extends Model {

	private String firstName;
	private String lastName;
	private String email; // email is UNIQUE in DB!;
	private String userName;
	private String password;
	private Roles role;
	private Boolean isBanned;


	public User() {
		super();
	}

	public User(Integer id) {
		super(id);
	}

	public User(String email, String password, String firstName, String lastName, String userName, Roles role,
			Boolean isBaned) {

		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.isBanned = isBaned;
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRoleString() {
		return role.toString();
	}

	public Roles getRole() {
		return role;
	}

	public Roles setRole(String role) {
		if (role != null) {
			for (Roles b : Roles.values()) {
				if (role.equalsIgnoreCase(b.name())) {
					return b;
				}
			}
		}
		return null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getIsBaned() {
		return isBanned;
	}

	public void setIsBaned(Boolean isBaned) {
		this.isBanned = isBaned;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", isBaned=" + isBanned + ", email=" + email + "]";
	}

}
