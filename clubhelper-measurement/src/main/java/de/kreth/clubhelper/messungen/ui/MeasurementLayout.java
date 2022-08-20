package de.kreth.clubhelper.messungen.ui;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.MeasurementType;

public class MeasurementLayout extends Div {

    private static final long serialVersionUID = 173597710293933530L;
    private TextField value;
    private TextField classification;
    private TextField onTime;
    private TextField measurementType;

    public MeasurementLayout(Measurement measurement) {
	this(measurement, false);
    }

    public MeasurementLayout(Measurement measurement, boolean printType) {
	MeasurementType type = measurement.getMeasurementType();

	FormLayout content = new FormLayout();
	if (printType) {
	    measurementType = new TextField("Typ: ");
	    measurementType.setValue(type.getTitle());
	    measurementType.setEnabled(false);
	    content.add(measurementType);
	}

	onTime = new TextField("Datum: ");
	onTime.setValue(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(measurement.getOnTime()));
	onTime.setEnabled(false);
	content.add(onTime);

	classification = new TextField("Durchgang: ");
	classification.setValue(measurement.getClassification());
//	classification.setEnabled(false);
	content.add(classification);

	value = new TextField("Wert: ");
	value.setValue(NumberFormat.getNumberInstance().format(measurement.getMeasured()) + " " + type.getUnit());
//	value.setEnabled(false);
	content.add(value);

	add(content);
    }
}
