package de.kreth.clubhelper.messungen.ui.personenmessungen;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import de.kreth.clubhelper.data.Measurement;

public class MeasurementView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	public MeasurementView(Measurement measurement) {
//		getStyle().set("background-color","red");
		getStyle().set("border", "1px solid black");
		setAlignItems(Alignment.START);
		
		Label title = new Label(measurement.getClassification());
		title.getStyle().set("font-weight", "bold");
//		title.getStyle().set("background-color","yellow");
		Label date = new Label(measurement.getOnTime().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		
		add(title, date);

		Label measured = new Label(NumberFormat.getInstance().format(measurement.getMeasured()));
		Label unit = new Label(measurement.getMeasurementType().getUnit());
		HorizontalLayout horizontalLayout = new HorizontalLayout(measured, unit);
		
//		horizontalLayout.getStyle().set("background-color","blue");
		add(horizontalLayout);
	}
}
