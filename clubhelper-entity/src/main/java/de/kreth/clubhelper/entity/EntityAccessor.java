package de.kreth.clubhelper.entity;


import java.time.LocalDateTime;

public interface EntityAccessor {

	Object getId();

	boolean hasValidId();

	void setChanged(LocalDateTime changed);

	void setCreated(LocalDateTime created);

}
