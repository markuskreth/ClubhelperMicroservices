package de.kreth.clubhelper.data;

import java.io.Serializable;

public class CompetitionType implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String type;

	private ClubEvent clubEvent;

	public Type getType() {
		if (this.type == null) {
			return null;
		}
		return Type.valueOf(type);
	}

	public void setType(Type type) {
		if (type == null) {
			this.type = null;
		} else {
			this.type = type.name();
		}
	}

	public void setClubEvent(ClubEvent clubEvent) {
		this.clubEvent = clubEvent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ClubEvent getClubEvent() {
		return clubEvent;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static enum Type {
		EINZEL, SYNCHRON, DOPPELMINI, MANNSCHAFT, LIGA
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		CompetitionType other = (CompetitionType) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return type;
	}
}
