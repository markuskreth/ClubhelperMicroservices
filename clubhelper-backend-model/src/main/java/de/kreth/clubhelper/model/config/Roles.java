package de.kreth.clubhelper.model.config;

public enum Roles {

	TEILNEHMER("user"), 
	TRAINER("trainer"),
	ADMINISTRATOR("admin");

	private final String role;

	private Roles(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
