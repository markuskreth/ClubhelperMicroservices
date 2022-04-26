package de.kreth.clubhelper.model.dao;

import org.springframework.data.repository.CrudRepository;

import de.kreth.clubhelper.entity.PersonNote;

public interface PersonNoteDao extends CrudRepository<PersonNote, Long>, ClubhelperDaoPersonRelated<PersonNote> {

}
