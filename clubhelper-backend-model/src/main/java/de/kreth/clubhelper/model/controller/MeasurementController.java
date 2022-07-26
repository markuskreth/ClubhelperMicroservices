package de.kreth.clubhelper.model.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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

	Map<MeasurementType, Set<String>> values = new HashMap<>();
	for (MeasurementType type : MeasurementType.values()) {
	    Collection<String> types = dao.findDistinctClassificationByMeasurementType(type);
	    values.put(type, new HashSet<String>(types));
	}
	return values;
    }
}
