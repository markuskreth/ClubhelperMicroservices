package de.kreth.clubhelper.messungen.remote;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import de.kreth.clubhelper.data.Person;
import de.kreth.clubhelper.data.Measurement;

public class Importer {

	public static void main(String[] args) throws Exception {
//		String nameExample = "Sprunghöhe - Kreth,Jasmin";
		String dir = "E:\\Markus\\Downloads";
		new Importer().importDir(dir);
	}

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.M.yyyy");
	private RestTemplate rest;
	private List<Person> personen;
	
	public Importer() {
		rest = new RestTemplate();
		personen = Arrays.asList(rest.getForObject("http://localhost:8080/person", Person[].class));
	}
	
	public void importDir(String dirName) throws Exception {
		File dir = new File(dirName);
		String[] csvFiles = dir.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith("Sprungh");
			}
		});
		for (String string : csvFiles) {
			String name = string.substring(string.indexOf(" - ") + 3);
			name = name.substring(0, name.indexOf("."));
			System.out.println(name);
			Path asPath = Path.of(dirName, string);
			try (BufferedReader in = Files.newBufferedReader(asPath)) {
				List<Measurement> measurements = readMeasurements(in);
				Person match = findPersonByName(name);
				if (match != null) {
					writeMeasurement(match, measurements);
				}
			}
		}
	}
	

	private Person findPersonByName(String name) {
		String[] nameParts = name.split(",");
		nameParts[0] = nameParts[0].trim();
		nameParts[1] = nameParts[1].trim();
		for (Person person : personen) {
			if (person.getSurname().equalsIgnoreCase(nameParts[0]) 
					&& person.getPrename().equalsIgnoreCase(nameParts[1])) {
				return person;
			}
		}
		return null;
	}

	private void writeMeasurement(Person name, List<Measurement> measurements) {
		for (Measurement m : measurements) {
			Measurement stored;
			try {
				stored = rest.postForObject("http://localhost:8080/measurement/for/" + name.getId(), m, Measurement.class);
			} catch (HttpClientErrorException e) {
				System.out.println("Error: " + e.getStatusCode() + "-" + name.getPrename() + " " + name.getSurname() + ": " + m);
				return;
			}
			if (stored.hasValidId()) {
				System.out.println("Stored " + name.getPrename() + " " + name.getSurname() + ": " + m.getOnTime().toLocalDate());
			} else {
				System.out.println("Failed " + name.getPrename() + " " + name.getSurname() + ": " + m);
			}
		}
	}

	private List<Measurement> readMeasurements(BufferedReader in)
			throws IOException {
		String line = in.readLine();
		while (line.contains(",,")) {
			line = in.readLine();
		}
		StringTokenizer tokenizer = new StringTokenizer(line, ",");
		tokenizer.nextToken();
		List<LocalDateTime> dates = new ArrayList<>();
		while (tokenizer.hasMoreTokens()) {
			String nextToken = tokenizer.nextToken();
			dates.add(LocalDate.parse(nextToken, formatter).atTime(18, 0));				
		}
		List<Measurement> values = new ArrayList<>();
		while ((line = in.readLine()) != null) {
			String[] cells = line.split(",");
			
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
		return values;
	}
}
