package de.kreth.clubhelper.measurement.remote;

import java.util.List;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.Person;
import de.kreth.clubhelper.vaadincomponents.remote.Business;

public interface MeasurementBusiness extends Business {

    @Override
    List<Person> getPersons();

    List<Measurement> getMeasurementsFor(Long personId);

    Measurement getMeasurement(Long measurementId);

    Measurement store(Long personId, Measurement measurement);
}
