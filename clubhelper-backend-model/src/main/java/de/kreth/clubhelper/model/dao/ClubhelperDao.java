package de.kreth.clubhelper.model.dao;

import java.util.Date;
import java.util.List;

import de.kreth.clubhelper.entity.EntityAccessor;

public interface ClubhelperDao<T extends EntityAccessor> {
	List<T> findByChangedGreaterThan(Date date);

	List<T> findByDeletedIsNull();

}
