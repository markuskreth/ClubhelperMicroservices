package de.kreth.clubhelper.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.entity.Measurement;

public interface MeasurementDao
	extends CrudRepository<Measurement, Long>, ClubhelperDaoPersonRelated<Measurement> {

    List<String> findDistinctClassificationByMeasurementType(MeasurementType measurementType);
}
