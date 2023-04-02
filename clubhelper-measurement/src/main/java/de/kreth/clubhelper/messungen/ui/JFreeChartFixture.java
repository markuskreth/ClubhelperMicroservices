package de.kreth.clubhelper.messungen.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import de.kreth.clubhelper.data.MeasurementType;

public class JFreeChartFixture {

	public static void main(String[] args) {

		TimeSeries series = new TimeSeries(MeasurementType.JumpHeightSeconds.name());
		series.add(new Day(30, 4, 2016), 13.11);
		series.add(new Day(20, 11, 2016), 13.2);
		series.add(new Day(6, 3, 2017), 12.80);
		series.add(new Day(13, 12, 2021), 16.61);
		TimeSeriesCollection data = new TimeSeriesCollection(series);
	    
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
        		"Sprunghöhen Nika", "Datum", "Sekunden", data, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer r = (XYLineAndShapeRenderer) plot.getRenderer();
        r.setDefaultShapesVisible(true);
        DateAxis domain = (DateAxis) plot.getDomainAxis();
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        domain.setDateFormatOverride(f);
        domain.setVerticalTickLabels(true);
	    JLabel imageContent = new JLabel();

	    BufferedImage image = chart.createBufferedImage(300, 300);
	    imageContent.setIcon(new ImageIcon(image));

	    imageContent.addComponentListener(new ComponentAdapter() {
	    	@Override
	    	public void componentResized(ComponentEvent e) {
	    		Dimension size = e.getComponent().getSize();
	    	    BufferedImage image = chart.createBufferedImage(size.width, size.height);
	    	    imageContent.setIcon(new ImageIcon(image));
//	    	    imageContent.repaint();
	    	}
		});
	    JPanel content = new JPanel(new BorderLayout());
	    content.add(imageContent, BorderLayout.CENTER);

	    JFrame frame = new JFrame("chart");
	    frame.setContentPane(content);
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	}

}
