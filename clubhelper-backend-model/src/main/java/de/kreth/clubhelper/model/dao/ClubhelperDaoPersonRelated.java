package de.kreth.clubhelper.model.dao;

import java.util.List;

import de.kreth.clubhelper.entity.EntityAccessor;
import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.entity.PersonRelated;

public interface ClubhelperDaoPersonRelated<T extends PersonRelated & EntityAccessor> extends ClubhelperDao<T> {

    List<T> findByPerson(Person person);

    List<T> findByPersonId(long personId);

}
