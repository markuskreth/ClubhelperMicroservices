package de.kreth.clubhelper.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.kreth.clubhelper.entity.Adress;

@Repository
public interface AdressDao extends CrudRepository<Adress, Long>, ClubhelperDaoPersonRelated<Adress> {

}
