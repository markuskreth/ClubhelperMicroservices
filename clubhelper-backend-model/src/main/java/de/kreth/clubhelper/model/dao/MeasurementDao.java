package de.kreth.clubhelper.model.dao;

import org.springframework.data.repository.CrudRepository;

import de.kreth.clubhelper.entity.Measurement;

public interface MeasurementDao
	extends CrudRepository<Measurement, Long>, ClubhelperDaoPersonRelated<Measurement> {

}
