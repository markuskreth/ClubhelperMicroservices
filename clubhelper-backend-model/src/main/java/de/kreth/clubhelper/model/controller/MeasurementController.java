package de.kreth.clubhelper.model.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.kreth.clubhelper.entity.Measurement;
import de.kreth.clubhelper.model.dao.MeasurementDao;

@RestController
@RequestMapping("/measurement")
@PreAuthorize("hasRole('ROLE_trainer')")
public class MeasurementController extends AbstractControllerPersonRelated<Measurement, MeasurementDao> {

    public MeasurementController() {
	super(Measurement.class);
    }

}
