package de.kreth.clubhelper.messungen.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.kreth.clubhelper.data.Measurement;
import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.messungen.remote.MeasurementBusiness;

public class JFreeChartFixture {

	public static void main(String[] args) throws IOException {
		new JFreeChartFixture().init();
	}
	
	private MeasurementChartGenerator generator;
	private JLabel imageContent;
	
	
	void init () throws IOException {
		
		generator = new MeasurementChartGenerator(MeasurementType.JumpHeightSeconds);
		List<Measurement> initialData = parse();
		generator.setMeasurements(initialData);
		
	    imageContent = new JLabel();

	    BufferedImage image = generator.getChartAsImage(300, 300);
	    imageContent.setIcon(new ImageIcon(image));
	    imageContent.addComponentListener(new ComponentAdapter() {
	    	@Override
	    	public void componentResized(ComponentEvent e) {
	    		update();
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

	void update() {
		Dimension size = imageContent.getSize();
	    BufferedImage image = generator.getChartAsImage(size.width, size.height);
	    imageContent.setIcon(new ImageIcon(image));
//	    imageContent.repaint();
	}
	
	List<Measurement> parse() throws IOException {
		List<Measurement> values = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		try (BufferedReader in = new BufferedReader(new StringReader(csv))) {
			readMeasurements(values, formatter, in);
		}
		return values;
	}

	private void readMeasurements(List<Measurement> values, DateTimeFormatter formatter, BufferedReader in)
			throws IOException {
		String line = in.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line);
		tokenizer.nextToken();
		List<LocalDateTime> dates = new ArrayList<>();
		while (tokenizer.hasMoreTokens()) {
			dates.add(LocalDate.parse(tokenizer.nextToken(), formatter).atTime(18, 0));				
		}
		while ((line = in.readLine()) != null) {
			String[] cells = line.split("\t");
			
			String classification = cells[0];
			for (int i=1; i<cells.length; i++) {
				try {
					double seconds = Double.parseDouble(cells[i]);
					Measurement m = new Measurement();
					m.setClassification(classification);
					m.setMeasured(seconds);
					m.setOnTime(dates.get(i - 1));
					values.add(m);
				} catch (NumberFormatException x) {
					continue;
				}
			}
		}
	}
	
	String csv = "Datum	30.04.2016	20.11.2016	21.11.2016	06.03.2017	13.12.2021	11.11.2022\r\n"
			+ "10Sprünge	13.11	13.20	12.72		16.61	17.11\r\n"
			+ "10Hocken	11.82		12.49	12.80	\r\n"
			+ "P3		11.6		12.1		15.77";
}
