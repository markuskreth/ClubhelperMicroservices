package de.kreth.clubhelper.messungen.remote;

import java.util.ArrayList;
import java.util.HashMap;
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

	public static Map<MeasurementType, Map<String, List<Measurement>>> toMap(List<Measurement> measurements2) {
		Map<MeasurementType, Map<String, List<Measurement>>> measurements = new HashMap<>();

		for (Measurement measurement : measurements2) {
			MeasurementType measurementType = measurement.getMeasurementType();
			String classification = measurement.getClassification();
			Map<String, List<Measurement>> classificationMap;
			if (measurements.containsKey(measurementType)) {
				classificationMap = measurements.get(measurementType);
			} else {
				classificationMap = new HashMap<>();
				measurements.put(measurementType, classificationMap);
			}
			List<Measurement> classifiationList;
			if (classificationMap.containsKey(classification)) {
				classifiationList = classificationMap.get(classification);
			} else {
				classifiationList = new ArrayList<>();
				classificationMap.put(classification, classifiationList);
			}
			classifiationList.add(measurement);
		}
		return measurements;
	}

}