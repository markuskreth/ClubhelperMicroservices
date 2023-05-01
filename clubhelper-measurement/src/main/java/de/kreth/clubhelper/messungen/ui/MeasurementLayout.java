package de.kreth.clubhelper.messungen.ui;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;
import java.util.Set;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.MeasurementType;

public class MeasurementLayout extends Div {

	private static final long serialVersionUID = 173597710293933530L;
	private NumberField value;
	private TextField classificationText;
	private ComboBox<String> classificationBox;
	private TextField onTime;
	private TextField measurementType;

	public MeasurementLayout(Measurement measurement) {
		this(measurement, null, false);
	}

	public MeasurementLayout(Measurement measurement, Map<String, Set<String>> types, boolean printType) {
		MeasurementType type = measurement.getMeasurementType();

		VerticalLayout content = new VerticalLayout();
		if (printType) {
			measurementType = new TextField("Typ: ");
			measurementType.setValue(type.getTitle());
			measurementType.setEnabled(false);
			content.add(measurementType);
		}

		final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		onTime = new TextField("Datum: ");
		onTime.setValue(formatter.format(measurement.getOnTime()));
		onTime.setEnabled(false);
		content.add(onTime);

		if (types == null || types.isEmpty()) {
			classificationText = new TextField("Durchgang: ");
			classificationText.setValue(measurement.getClassification());
//		classification.setEnabled(false);	
			content.add(classificationText);
		} else {
			classificationBox = new ComboBox<>();
			classificationBox.setItems(types.get(type.name()));
			classificationBox.setValue(measurement.getClassification());
			classificationBox.addCustomValueSetListener(ev -> {
				String detail = ev.getDetail();
				measurement.setClassification(detail);
			});
			classificationBox.addValueChangeListener(ev -> measurement.setClassification(ev.getValue()));
			content.add(classificationBox);
		}

		value = new NumberField("Wert: ");
		value.setSuffixComponent(new Label(type.getUnit()));
		value.setValue(measurement.getMeasured());
		value.addValueChangeListener(ev -> {
			measurement.setMeasured(ev.getValue().doubleValue());
		});
		
//	value.setEnabled(false);
		content.add(value);

		add(content);
	}
}
