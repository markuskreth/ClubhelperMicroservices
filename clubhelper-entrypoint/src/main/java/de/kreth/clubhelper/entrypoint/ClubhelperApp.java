package de.kreth.clubhelper.entrypoint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClubhelperApp {

	private final String url;
	private final String name;
	private final List<String> requiredRoles;

	public ClubhelperApp(String url, String name, String... requiredRoles) {
		super();
		this.url = url;
		this.name = name;
		if (requiredRoles == null) {
			this.requiredRoles = Collections.emptyList();
		} else {
			this.requiredRoles = Arrays.asList(requiredRoles);
		}
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public boolean validForAllRoles() {
		return requiredRoles.isEmpty();
	}

	public boolean validForRole(String role) {
		return requiredRoles.contains(role);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ClubhelperApp other = (ClubhelperApp) obj;
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ClubhelperApp [name=" + name + ": " + url + "]";
	}

}
