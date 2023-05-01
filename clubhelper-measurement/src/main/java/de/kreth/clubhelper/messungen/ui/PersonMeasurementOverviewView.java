package de.kreth.clubhelper.messungen.ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.AbstractStreamResource;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinService;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.data.Person;
import de.kreth.clubhelper.messungen.remote.MeasurementBusiness;
import de.kreth.clubhelper.messungen.ui.MeasurementChartGenerator.Zeitraum;
import de.kreth.clubhelper.messungen.ui.personenmessungen.MeasurementView;

@Route("view")
@PageTitle("Messungen")
public class PersonMeasurementOverviewView extends Div implements HasUrlParameter<Long> {

	private static final long serialVersionUID = -4739360765719035802L;
	private static final String SESSION_ZEITRAUM_KEY = "choosenZeitraum";

	private final MeasurementChartGenerator generator = new MeasurementChartGenerator(MeasurementType.JumpHeightSeconds);
	private final MeasurementBusiness business;
	private final HtmlContainer head;
	private Person person;
	private Image chart;
	private final AtomicBoolean chartVisible = new AtomicBoolean();

	private List<Measurement> measurements;
	private FormLayout bestOf;
	
	public PersonMeasurementOverviewView(@Autowired MeasurementBusiness business) {
		this.business = business;

		this.head = new H1();

		Button addButton = new Button("Hinzufügen", this::addMeasurement);

		VerticalLayout layout = new VerticalLayout();
		add(head, new H3("Messungen"));
		chart = new Image();
		chart.setVisible(false);
		
		HorizontalLayout chartControls = new HorizontalLayout();
		chartControls.setPadding(true);
		chartControls.setAlignItems(FlexComponent.Alignment.END);
		Button toggleChart = new Button("Chart zeigen", this::toggleChart);
		ComboBox<Zeitraum> zeitraum = new ComboBox<>("Zeitraum für Chart", Zeitraum.values());
		
		Object choosenZeitraum = VaadinService.getCurrentRequest().getWrappedSession().getAttribute(SESSION_ZEITRAUM_KEY);
		
		Zeitraum zeitraumToSet = Zeitraum.JEAR1;
		if (choosenZeitraum != null) {
			zeitraumToSet = Zeitraum.valueOf(choosenZeitraum.toString());
		}
		zeitraum.setValue(zeitraumToSet);
		generator.setZeitraum(zeitraumToSet);
		zeitraum.setRenderer(new TextRenderer<>(Zeitraum::getText));
		zeitraum.addValueChangeListener(this::zeitraumChanged);
		chartVisible.set(false);
		
		chartControls.add(toggleChart, zeitraum);
		this.bestOf = new FormLayout();
		
		layout.add(addButton, bestOf, chartControls, chart);

		add(layout);
		
	}

	private void zeitraumChanged(ComponentValueChangeEvent<ComboBox<Zeitraum>, Zeitraum> event) {
		Zeitraum old = generator.getZeitraum();
		generator.setZeitraum(event.getValue());
		VaadinService.getCurrentRequest().getWrappedSession().setAttribute(SESSION_ZEITRAUM_KEY, event.getValue().name());
		if (chartVisible.get() && old != event.getValue()) {
			updateChart();
		}
	}
	
	private void toggleChart(ClickEvent<Button> event) {
		chartVisible.set(!chartVisible.get());
		if (chartVisible.get()) {
			event.getSource().setText("Chart ausblenden");
			chart.setVisible(true);
			updateChart();
		} else {
			event.getSource().setText("Chart zeigen");
			chart.setVisible(false);
		}
	}
	
	private void addMeasurement(ClickEvent<Button> event) {

		Measurement measurement = new Measurement();
		measurement.setMeasurementType(MeasurementType.JumpHeightSeconds);
		measurement.setOnTime(LocalDateTime.now());
		Dialog dialog = new Dialog();

		Button store = new Button("Speichern", ev -> {
			dialog.close();
			storeMeasurement(measurement);
		});
		Button close = new Button("Abbrechen", ev -> dialog.close());

		MeasurementLayout layout = new MeasurementLayout(measurement, business.getAllTypes(), true);
		FormLayout content = new FormLayout(layout, store, close);
		dialog.add(content);
		dialog.open();
		
	}

	private void storeMeasurement(Measurement measurement) {
		Measurement stored = business.store(person.getId(), measurement);
		measurements.add(stored);
		if (chartVisible.get()) {
			updateChart();
		}
		updateBestOf();
	}

	private void updateBestOf() {
		bestOf.removeAll();
		Map<String, Measurement> best = new HashMap<>();
		for(Measurement m: this.measurements) {
			Measurement last = best.get(m.getClassification());
			if (last == null || last.getMeasured()<m.getMeasured()) {
				best.put(m.getClassification(), m);
			}
		}
		
		setResponsiveSteps(best.size());
		
		for (Measurement m : best.values()) {
			bestOf.add(new MeasurementView(m));
		}
	}
	

	private void setResponsiveSteps(int size) {
		List<ResponsiveStep> steps = new ArrayList<>();
        // Use one column by default
		steps.add(new ResponsiveStep("0", 1));
        // Use two columns, if the layout's width exceeds 250px
		steps.add(new ResponsiveStep("250px", 2));
		if (size>2) {
			steps.add(new ResponsiveStep("350px", 3));
		}
		if (size>3) {
			steps.add(new ResponsiveStep("470px", 4));
		}
		if (size>4) {
			steps.add(new ResponsiveStep("570px", 5));
		}
		if (size>5) {
			steps.add(new ResponsiveStep("670px", 6));
		}
		if (size>6) {
			steps.add(new ResponsiveStep("770px", 7));
		}
		if (size>7) {
			steps.add(new ResponsiveStep("890px", 8));
		}
		this.bestOf.setResponsiveSteps(steps);
	}

	@Override
	public void setParameter(BeforeEvent event, Long personId) {

		if (personId != null) {
			this.person = business.getPerson(personId);
			head.add(person.getPrename() + " " + person.getSurname());
			measurements = business.getMeasurements(personId);
			updateBestOf();
			if (chartVisible.get()) {
				updateChart();
			}
		}
	}

	private void updateChart() {
		generator.setMeasurements(measurements);
		Page page = UI.getCurrent().getPage();
		page.retrieveExtendedClientDetails(details -> {
			int width = details.getWindowInnerWidth();
			int height = details.getWindowInnerHeight();
			height = Math.min(width, height);
			updateChart(width, height);
		});
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
