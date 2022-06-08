package de.kreth.clubhelper.attendance.export;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.StreamResourceWriter;
import com.vaadin.flow.server.VaadinSession;

import de.kreth.clubhelper.attendance.remote.Business;
import de.kreth.clubhelper.data.Attendance;
import de.kreth.clubhelper.data.Person;

public class ThreeMonthsStatistic implements Exporter {

    private LocalDate untilDate;
    private LocalDate startDate;
    private List<LocalDate> dates;

    @Override
    public String getName() {
	return "Statistik der letzten 3 Monate";
    }

    @Override
    public String getFileName() {
	Month startMonth = startDate.getMonth();
	Month endMonth = untilDate.getMonth();

	return "statistik_" + startMonth + "-" + endMonth + ".csv";
    }

    @Override
    public StreamResource asResource(LocalDate untilDate, Business business) {
	this.untilDate = untilDate;
	this.startDate = untilDate.minusMonths(3).withDayOfMonth(1);
	List<Attendance> list = business.getAttendanceBetween(startDate, untilDate);
	dates = list.stream()
		.map(Attendance::getOnDate)
		.distinct()
		.sorted()
		.collect(Collectors.toList());

	return new StreamResource(getFileName(), new StreamResourceWriter() {

	    private static final long serialVersionUID = 5497114629715893206L;

	    @Override
	    public void accept(OutputStream stream, VaadinSession session) throws IOException {

		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(stream, StandardCharsets.UTF_8))) {
		    writeHead(out);
		    writeData(out, list);
		}

	    }

	});
    }

    int bySurnameAndGivenNameAndOnDate(Attendance o1, Attendance o2) {

	Person p1 = o1.getPerson();
	Person p2 = o2.getPerson();
	int compared = bySurnameAndGivenName(p1, p2);
	if (compared == 0) {
	    compared = o1.getOnDate().compareTo(o2.getOnDate());
	}
	return compared;
    }

    int bySurnameAndGivenName(Person p1, Person p2) {

	if (p1.getSurname().compareTo(p2.getSurname()) == 0) {
	    return p1.getPrename().compareTo(p2.getPrename());
	}
	return p1.getSurname().compareTo(p2.getSurname());
    }

    private void writeData(BufferedWriter out, List<Attendance> list) throws IOException {
	if (list.isEmpty()) {
	    return;
	}

	Map<Person, List<LocalDate>> personAttendance = new HashMap<>();
	for (Attendance attendance : list) {
	    List<LocalDate> values;
	    if (personAttendance.containsKey(attendance.getPerson())) {
		values = personAttendance.get(attendance.getPerson());
	    } else {
		values = new ArrayList<>();
		personAttendance.put(attendance.getPerson(), values);
	    }
	    values.add(attendance.getOnDate());
	}

	List<Person> persons = new ArrayList<>(personAttendance.keySet());
	persons.sort(this::bySurnameAndGivenName);
	for (Person person : persons) {
	    out.newLine();
	    out.append(person.getSurname()).append(";");
	    out.append(person.getPrename());
	    List<LocalDate> values = personAttendance.get(person);
	    for (LocalDate date : dates) {
		if (values.contains(date)) {
		    out.append(";1");
		} else {
		    out.append(";");
		}
	    }
	}
    }

    protected void writeHead(BufferedWriter out) throws IOException {
	out.append("Anwesenheiten Trampolin zwischen " + startDate
		+ " und " + untilDate);
	out.newLine();

	DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

	out.append("Nachname").append(";").append("Vorname");
	for (LocalDate localDate : dates) {
	    out.append(";").append(localDate.format(formatter));
	}
    }

}
