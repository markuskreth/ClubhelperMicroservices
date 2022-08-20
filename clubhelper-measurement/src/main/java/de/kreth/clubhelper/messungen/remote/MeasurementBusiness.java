package de.kreth.clubhelper.messungen.remote;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.Authentication;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.data.OrderBy;
import de.kreth.clubhelper.data.Person;
import de.kreth.clubhelper.vaadincomponents.remote.Business;

public interface MeasurementBusiness extends Business {

    List<Person> getPersons(OrderBy order);

    List<Measurement> getMeasurements(Long forPerson);

    Authentication getCurrent();

    Measurement store(Long personId, Measurement measurement);

    Map<MeasurementType, Set<String>> getAllTypes();

}