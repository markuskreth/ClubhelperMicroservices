package de.kreth.clubhelper.model.dao;

import org.springframework.data.repository.CrudRepository;

import de.kreth.clubhelper.entity.Contact;

public interface ContactDao 
	extends CrudRepository<Contact, Long>, ClubhelperDaoPersonRelated<Contact> {

}
