package de.kreth.clubhelper.data;

import java.time.LocalDateTime;

public abstract class BaseEntity implements EntityAccessor {
	private long id;
	private LocalDateTime changed;
	private LocalDateTime created;
	private LocalDateTime deleted;

	public BaseEntity() {
		id = -1;
	}

	public LocalDateTime getChanged() {
		return this.changed;
	}

	@Override
	public void setChanged(LocalDateTime changed) {
		this.changed = changed;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	@Override
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getDeleted() {
		return deleted;
	}

	public void setDeleted(LocalDateTime deleted) {
		this.deleted = deleted;
	}

	public boolean isDeleted() {
		return getDeleted() != null;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public boolean hasValidId() {
		return id > 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = (int) (prime * result + id);
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
		BaseEntity other = (BaseEntity) obj;
		if (deleted == null) {
			if (other.deleted != null) {
				return false;
			}
		} else if (!deleted.equals(other.deleted)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("BaseEntity [id=");
		stringBuilder.append(id);
		stringBuilder.append(", changed=");
		stringBuilder.append(changed);
		if (deleted != null) {
			stringBuilder.append(", deleted=");
			stringBuilder.append(deleted);
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
