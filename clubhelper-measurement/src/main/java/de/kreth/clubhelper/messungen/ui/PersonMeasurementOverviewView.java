package de.kreth.clubhelper.messungen.ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.AbstractStreamResource;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.StreamResourceWriter;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.data.Person;
import de.kreth.clubhelper.messungen.remote.MeasurementBusiness;

@Route("view")
@PageTitle("Messungen")
public class PersonMeasurementOverviewView extends Div implements HasUrlParameter<Long> {

	private static final long serialVersionUID = -4739360765719035802L;

	private final MeasurementChartGenerator generator = new MeasurementChartGenerator(MeasurementType.JumpHeightSeconds);
	private final MeasurementBusiness business;
	private final HtmlContainer head;
	private Person person;
	private Image chart;

	public PersonMeasurementOverviewView(@Autowired MeasurementBusiness business) {
		this.business = business;

		this.head = new H1();

		Button addButton = new Button("Hinzufügen", this::addMeasurement);

		VerticalLayout layout = new VerticalLayout();
		add(head);
		chart = new Image();
		
		layout.add(addButton, chart);

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
			
			List<Measurement> measurement = business.getMeasurements(personId);
			generator.setMeasurements(measurement);
			Page page = UI.getCurrent().getPage();
			page.retrieveExtendedClientDetails(details -> {
				int width = details.getWindowInnerWidth();
				int height = details.getWindowInnerHeight();
				height = Math.min(width, height);
				updateChart(width, height);
			});
		}

	}

	private void updateChart(int width, int height) {
		BufferedImage chartAsImage = generator.getChartAsImage(width, height);
		AbstractStreamResource src = new StreamResource("chart", new ImageInputStreamFactory(chartAsImage));
		chart.setSrc(src);
	}

	static class ImageInputStreamFactory implements InputStreamFactory {
		
		private static final long serialVersionUID = 1L;
		private final BufferedImage image;
		
		public ImageInputStreamFactory(BufferedImage image) {
			super();
			this.image = image;
		}

		@Override
		public InputStream createInputStream() {

	        try {
	            // Write the image to a buffer
	            ByteArrayOutputStream imagebuffer = new ByteArrayOutputStream();
	            ImageIO.write(image, "png", imagebuffer);

	            // Return a stream from the buffer
	            return new ByteArrayInputStream(
	                imagebuffer.toByteArray());
	        } catch (IOException e) {
	            return null;
	        }
		}
	}
}
