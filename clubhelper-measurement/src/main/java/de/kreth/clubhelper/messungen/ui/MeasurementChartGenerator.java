package de.kreth.clubhelper.messungen.ui;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.messungen.remote.MeasurementBusiness;

public class MeasurementChartGenerator {

	private final Map<String, TimeSeries> timeSeries;
	
	public MeasurementChartGenerator(MeasurementType type) {
		super();
		this.timeSeries = new HashMap<>();
	}
	
	/**
	 * replaces data with given.
	 * @param measurements
	 */
	public void setMeasurements(List<Measurement> measurements) {
		timeSeries.clear();

		for (Measurement measurement : measurements) {
			add(measurement);
		}
	}
	
	/**
	 * Adds data to current.
	 * @param measurement
	 */
	public void add(Measurement measurement) {
		LocalDateTime onTime = measurement.getOnTime();
		Day day = new Day(onTime.getDayOfMonth(), onTime.getMonthValue(), onTime.getYear());
		TimeSeries series;
		String classification = measurement.getClassification();
		if (timeSeries.containsKey(classification)) {
			series = timeSeries.get(classification);
		} else {
			series = new TimeSeries(classification);
			timeSeries.put(classification, series);
		}
		TimeSeriesDataItem changed = series.addOrUpdate(day, measurement.getMeasured());
		if (changed != null && changed.getValue().doubleValue() > measurement.getMeasured()) {
			series.addOrUpdate(day, changed.getValue().doubleValue());
		}
	}
	
	/**
	 * Generate Image with given Size.
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage getChartAsImage(int width, int height) {

		TimeSeriesCollection data = new TimeSeriesCollection();
		timeSeries.values().forEach(data::addSeries);
		
		JFreeChart chart = ChartFactory.createTimeSeriesChart("Sprunghöhen", "Datum", "Sekunden", data);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer r = (XYLineAndShapeRenderer) plot.getRenderer();
        r.setDefaultShapesVisible(true);
        DateAxis domain = (DateAxis) plot.getDomainAxis();
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        domain.setDateFormatOverride(f);
        domain.setVerticalTickLabels(true);
		return chart.createBufferedImage(width, height);
	}
}
