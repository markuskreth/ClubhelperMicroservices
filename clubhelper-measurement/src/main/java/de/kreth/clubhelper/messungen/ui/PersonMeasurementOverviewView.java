package de.kreth.clubhelper.messungen.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.data.Person;
import de.kreth.clubhelper.messungen.remote.MeasurementBusiness;

@Route("view")
@PageTitle("Messungen")
public class PersonMeasurementOverviewView extends Div implements HasUrlParameter<Long> {

    private static final long serialVersionUID = -4739360765719035802L;
    private final MeasurementBusiness business;
    private final HtmlContainer head;
    private final Map<MapKey, Map<LocalDate, List<Measurement>>> measurements = new HashMap<>();
    private Person person;

    public PersonMeasurementOverviewView(@Autowired MeasurementBusiness business) {
	this.business = business;

	this.head = new H1();

	Button addButton = new Button("Hinzufügen", this::addMeasurement);

	FormLayout layout = new FormLayout();
	add(head);
	layout.add(addButton);

	Map<MeasurementType, Set<String>> types = business.getAllTypes();
	add(layout);
    }

    private void addMeasurement(ClickEvent<Button> event) {

	Measurement measurement = new Measurement();
	measurement.setOnTime(LocalDateTime.now());
	Dialog dialog = new Dialog();

	Button store = new Button("Speichern", ev -> {
	    dialog.close();
	    storeMeasurement(measurement);
	});
	Button close = new Button("Abbrechen", ev -> dialog.close());

	MeasurementLayout layout = new MeasurementLayout(measurement, true);
	FormLayout content = new FormLayout(layout, store, close);
	dialog.add(content);
	dialog.open();

    }

    private void storeMeasurement(Measurement measurement) {
	business.store(person.getId(), measurement);
    }

    @Override
    public void setParameter(BeforeEvent event, Long personId) {

	measurements.clear();
	if (personId != null) {
	    this.person = business.getPerson(personId);
	    head.add(person.getPrename() + " " + person.getSurname());
	    List<Measurement> measurements = business.getMeasurements(personId);
	    for (Measurement measurement : measurements) {
		MapKey key = new MapKey(measurement);
		Map<LocalDate, List<Measurement>> measurementList = getListForKey(key);
		List<Measurement> list = measurementList.get(measurement.getOnTime().toLocalDate());
		if (list == null) {
		    list = new ArrayList<>();
		    measurementList.put(measurement.getOnTime().toLocalDate(), list);
		}
		list.add(measurement);
	    }
	}

	DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).localizedBy(Locale.GERMANY);

	FormLayout content = new FormLayout();
	for (Entry<MapKey, Map<LocalDate, List<Measurement>>> entry : measurements.entrySet()) {
	    boolean printedClassification = false;
	    Map<LocalDate, List<Measurement>> val = entry.getValue();
	    LocalDate latest = val.keySet().stream().max(Comparator.comparing(LocalDate::toEpochDay)).get();
	    for (Entry<LocalDate, List<Measurement>> e : val.entrySet()) {
		boolean printedDate = false;
		LocalDate onDate = e.getKey();
		List<Measurement> list = e.getValue();

		if (latest.equals(onDate)) {
		    Optional<Measurement> best = list.stream().max(Comparator.comparing(Measurement::getMeasured));
		    if (best.isPresent()) {
			Measurement measurement = best.get();
			content.add(new MeasurementLayout(measurement));
		    }
		} else {

		    for (Measurement measurement : list) {
			if (!printedClassification) {
			    content.add(new H1(measurement.getClassification()));
			} else if (!printedDate) {
			    content.add(new H2(onDate.format(formatter)));
			}
			content.add(new MeasurementLayout(measurement));
		    }
		}
	    }
	}

	add(content);
    }

    private Map<LocalDate, List<Measurement>> getListForKey(MapKey key) {
	Map<LocalDate, List<Measurement>> measurementList;
	if (this.measurements.containsKey(key)) {
	    measurementList = this.measurements.get(key);
	} else {
	    measurementList = new HashMap<>();
	    this.measurements.put(key, measurementList);
	}
	return measurementList;
    }

    class MapKey implements Comparable<MapKey> {

	final Measurement measurement;

	MapKey(Measurement measurement) {
	    this.measurement = measurement;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + Objects.hash(measurement.getClassification(), measurement.getMeasurementType());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
		return true;
	    }
	    if (obj == null) {
		return false;
	    }
	    if (getClass() != obj.getClass()) {
		return false;
	    }
	    MapKey other = (MapKey) obj;
	    return Objects.equals(measurement.getClassification(), other.measurement.getClassification())
		    && measurement.getMeasurementType() == other.measurement.getMeasurementType();
	}

	@Override
	public int compareTo(MapKey o) {
	    return Comparator.comparing(Measurement::getMeasurementType)
		    .thenComparing(Measurement::getClassification)
		    .compare(this.measurement, o.measurement);
	}

    }
}
