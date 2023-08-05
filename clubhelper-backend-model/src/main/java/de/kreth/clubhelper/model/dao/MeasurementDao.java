package de.kreth.clubhelper.model.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.entity.Measurement;

public interface MeasurementDao extends CrudRepository<Measurement, Long>, ClubhelperDaoPersonRelated<Measurement> {

	@Query(value = "select distinct m.classification from Measurement m where m.measurementType = ?1")
	Set<String> findClassificationsByType(MeasurementType measurementType);
}
