package de.kreth.clubhelper.messungen.ui;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.DefaultXYDataset;
import org.springframework.beans.factory.annotation.Autowired;

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

	if (personId != null) {
	    this.person = business.getPerson(personId);
	    head.add(person.getPrename() + " " + person.getSurname());
	    Map<MeasurementType, Map<String, List<Measurement>>> measurements = new HashMap<>();

	    for (Measurement measurement : business.getMeasurements(personId)) {
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

	    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
		    .localizedBy(Locale.GERMANY);

	    Map<String, List<Measurement>> jumpHeigths = measurements.get(MeasurementType.JumpHeightSeconds);

	    JFreeChart chart;
	    DefaultXYDataset data = new DefaultXYDataset();
	    data.setGroup(new DatasetGroup(MeasurementType.JumpHeightSeconds.name()));
	    data.chart = ChartFactory.createXYLineChart("Sprunghöhen", "Datum", "Sekunden", data);
	    BufferedImage image = chart.createBufferedImage(300, 100);

	}

	FormLayout content = new FormLayout();

	add(content);
    }

}
