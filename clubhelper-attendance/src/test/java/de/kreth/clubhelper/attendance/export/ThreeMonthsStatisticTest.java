package de.kreth.clubhelper.attendance.export;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vaadin.flow.server.StreamResource;

import de.kreth.clubhelper.attendance.remote.Business;
import de.kreth.clubhelper.data.Attendance;
import de.kreth.clubhelper.data.Person;

public class ThreeMonthsStatisticTest {

    @Mock
    private Business business;
    private ThreeMonthsStatistic exporter;
    private AutoCloseable closeAfter;
    private String output;
    private List<Person> persons;
    private List<Attendance> data;
    private List<LocalDate> dateList;

    @Before
    public void init() throws IOException {
	this.closeAfter = MockitoAnnotations.openMocks(this);
	this.exporter = new ThreeMonthsStatistic();

	LocalDate until = LocalDate.of(2022, 6, 17);
	LocalDate from = LocalDate.of(2022, 3, 1);

	dateList = createMondaysAndWednesdays(until, from);

	persons = createPersons();

	data = createAttendances(dateList, persons);

	when(business.getAttendanceBetween(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(data);

	StreamResource asResource = exporter.asResource(until, business);
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	asResource.getWriter().accept(out, null);
	output = new String(out.toByteArray(), StandardCharsets.UTF_8);

    }

    @After
    public void shutdown() throws Exception {
	closeAfter.close();
    }

    @Test
    public void testHeadWithDoublicatedOnDates() throws IOException {
	String[] lines = output.split(System.lineSeparator());
	String dateLine = lines[1];
	String[] values = dateLine.split(";");
	assertEquals(2 + dateList.size(), values.length);
    }

    @Test
    public void testNameSortAndCount() throws IOException {

	String[] lines = output.split(System.lineSeparator());
	List<String[]> familyAndGivenName = Arrays.asList(lines).subList(2, lines.length).stream()
		.map(l -> l.split(";"))
		.map(arr -> new String[] { arr[0], arr[1] })
		.collect(Collectors.toList());

	List<String> chars = Arrays.asList("A", "G", "S", "Z");
	int currentCharIndex = 0;
	for (int i = 1; i < familyAndGivenName.size(); i++) {

	    String nameFirstChar = familyAndGivenName.get(i)[0].substring(0, 1);
	    String expected = chars.get(currentCharIndex);
	    if (!expected.contentEquals(nameFirstChar)) {
		currentCharIndex++;
		expected = chars.get(currentCharIndex);
	    }
	    assertEquals("After " + familyAndGivenName.get(i - 1)[0] + " " + expected
		    + " was expected, but was " + familyAndGivenName.get(i)[0], expected, nameFirstChar);
	}
	assertEquals("Input Persons #" + persons.size() + ", printed Persons #" + familyAndGivenName.size(),
		persons.size(), familyAndGivenName.size());
    }

    @Test
    public void testCorrectAttendancePerPeson() throws IOException {

	String[] lines = output.split(System.lineSeparator());

	List<LocalDate> sortedDates = new ArrayList<>(dateList);
	Collections.sort(sortedDates);

	for (Person person : persons) {
	    testPerson(person, data, lines, sortedDates);
	}
    }

    private void testPerson(Person person, List<Attendance> data, String[] lines, List<LocalDate> sortedDates) {
	List<Attendance> personAttendances = data.stream().filter(a -> a.getPerson().equals(person))
		.collect(Collectors.toList());
	String personLine = null;
	for (String string : lines) {
	    if (string.contains(person.getPrename()) && string.contains(person.getSurname())) {
		personLine = string;
		break;
	    }
	}
	assertNotNull("Line for Person not found: " + person, personLine);
	List<String> values = extractValuesFromLine(personLine);
	assertEquals("Count of Values does not match count of expected dates", sortedDates.size() + 2, values.size());
	List<Integer> needCheck = new ArrayList<>();

	for (Attendance attendance : personAttendances) {
	    needCheck.add(sortedDates.indexOf(attendance.getOnDate()));
	}
	for (int i = 2; i < values.size(); i++) {
	    if (needCheck.contains(i - 2)) {
		assertEquals("1", values.get(i));
	    } else {
		assertEquals("", values.get(i));
	    }
	}
    }

    private List<String> extractValuesFromLine(String personLine) {
	List<String> values = new ArrayList<>();
	int start = 0;
	int end = personLine.indexOf(";");
	while (end >= 0) {
	    values.add(personLine.substring(start, end));
	    start = end + 1;
	    end = personLine.indexOf(";", start);
	}
	values.add(personLine.substring(start));
	return values;
    }

    private List<Attendance> createAttendances(List<LocalDate> dateList, List<Person> persons) {

	List<Attendance> data = new ArrayList<>();

	data.addAll(toAttendence(persons.subList(0, 2), dateList.subList(0, 15)));
	data.addAll(toAttendence(persons.subList(2, 4), dateList.subList(15, 31)));

	data.addAll(toAttendence(persons.subList(1, 2), dateList.subList(15, 20)));
	data.addAll(toAttendence(persons.subList(2, 3), dateList.subList(10, 15)));
	return data;
    }

    private List<LocalDate> createMondaysAndWednesdays(LocalDate until, LocalDate from) {
	List<LocalDate> dateList = stream(from, until)
		.filter(d -> DayOfWeek.WEDNESDAY.equals(d.getDayOfWeek()) || DayOfWeek.MONDAY.equals(d.getDayOfWeek()))
		.sorted((d1, d2) -> Integer.compare(d1.hashCode(), d2.hashCode()))
		.collect(Collectors.toList());
	return dateList;
    }

    private List<Attendance> toAttendence(List<Person> persons, List<LocalDate> dates) {
	List<Attendance> result = new ArrayList<Attendance>();
	for (Person person : persons) {
	    for (LocalDate date : dates) {
		Attendance a = new Attendance();
		a.setId(person.getId() + date.hashCode());
		a.setOnDate(date);
		a.setPerson(person);
		result.add(a);
	    }
	}
	return result;
    }

    public Stream<LocalDate> stream(LocalDate startDate, LocalDate endDate) {
	return Stream.iterate(startDate, d -> d.plusDays(1))
		.limit(ChronoUnit.DAYS.between(startDate, endDate) + 1);
    }

    List<Person> createPersons() {
	List<Person> persons = new ArrayList<>();
	persons.add(createPerson(1, "APrename", "ASurname"));
	persons.add(createPerson(100, "ZPrename", "ZSurname"));
	persons.add(createPerson(150, "GPrename", "GSurname"));
	persons.add(createPerson(160, "SPrename", "SSurname"));

	return persons;
    }

    private Person createPerson(int id, String prename, String surname) {

	Person p1 = new Person();
	p1.setId(id);
	p1.setPrename(prename);
	p1.setSurname(surname);
	return p1;
    }

}
