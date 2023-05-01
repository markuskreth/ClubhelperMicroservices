package de.kreth.clubhelper.model.controller;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.entity.Measurement;
import de.kreth.clubhelper.model.dao.MeasurementDao;

@RestController
@RequestMapping("/measurement")
@PreAuthorize("hasRole('ROLE_trainer')")
public class MeasurementController extends AbstractControllerPersonRelated<Measurement, MeasurementDao> {

    public MeasurementController() {
	super(Measurement.class);
    }

    @GetMapping("/types")
    public Map<MeasurementType, Set<String>> getAllTypes() {

	EnumMap<MeasurementType, Set<String>> values = new EnumMap<>(MeasurementType.class);

	for (MeasurementType measurementType : MeasurementType.values()) {
	    Set<String> list = dao.findClassificationsByType(measurementType);
	    values.put(measurementType, list);
	}

	return values;
    }
}
