package de.kreth.clubhelper.model.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import de.kreth.clubhelper.data.OrderBy;
import de.kreth.clubhelper.entity.Attendance;
import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.model.dao.AttendanceDao;
import de.kreth.clubhelper.model.dao.PersonDao;

@ExtendWith(MockitoExtension.class)
public class PersonControllerByAttendanceTest {

	private PersonController controller;
	@Mock
	private AttendanceDao dao;
	@Mock
	private PersonDao personDao;

	List<Attendance> values;
	List<Person> persons;
	
	@BeforeEach
	void init() {
		values = new ArrayList<>();
		persons = new ArrayList<>();
		
		controller = new PersonController();
		controller.setAttendanceDao(dao);
		controller.setPersonDao(personDao);
		
		when(dao.findByChangedGreaterThan(any(LocalDateTime.class))).thenReturn(values);
		when(personDao.findByDeletedIsNull()).thenAnswer(new JoinPersonWithAttendanceAnswer());
	}

	@Test
	void orderSimplyByOnDate() {
		Person p1 = new Person();
		p1.setId(1L);
		Person p2 = new Person();
		p2.setId(2L);
		
		Attendance a1_1 = new Attendance();
		a1_1.setPerson(p1);
		a1_1.setOnDate(LocalDate.of(2022, 1, 10));
		
		Attendance a2_1 = new Attendance();
		a2_1.setPerson(p2);
		a2_1.setOnDate(LocalDate.of(2022, 1, 10));
		
		Attendance a2_2 = new Attendance();
		a2_2.setPerson(p2);
		a2_2.setOnDate(LocalDate.of(2022, 1, 12));

		values.add(a1_1);
		values.add(a2_1);
		values.add(a2_2);
		
		List<Person> result = controller.getAllOrdered(OrderBy.ATTENDANCE);

		assertEquals(2, result.size());
		assertEquals(p2, result.get(0));
		assertEquals(p1, result.get(1));
	}

	@Test
	void orderSimplyEarlierOnDate() {
		Person p1 = new Person();
		p1.setId(1L);
		Person p2 = new Person();
		p2.setId(2L);
		
		Attendance a1_1 = new Attendance();
		a1_1.setPerson(p1);
		a1_1.setOnDate(LocalDate.of(2022, 1, 10));
		
		Attendance a2_1 = new Attendance();
		a2_1.setPerson(p2);
		a2_1.setOnDate(LocalDate.of(2022, 1, 12));
		
		values.add(a1_1);
		values.add(a2_1);
		
		List<Person> result = controller.getAllOrdered(OrderBy.ATTENDANCE);

		assertEquals(2, result.size());
		assertEquals(p2, result.get(0));
		assertEquals(p1, result.get(1));
	}

	@Test
	void orderAlteratingEarlierOnDate() {
		Person p1 = new Person();
		p1.setId(1L);
		Person p2 = new Person();
		p2.setId(2L);

		Attendance a1_1 = new Attendance();
		a1_1.setPerson(p1);
		a1_1.setOnDate(LocalDate.of(2022, 1, 10));

		Attendance a1_2 = new Attendance();
		a1_2.setPerson(p1);
		a1_2.setOnDate(LocalDate.of(2022, 1, 13));
		
		Attendance a2_1 = new Attendance();
		a2_1.setPerson(p2);
		a2_1.setOnDate(LocalDate.of(2022, 1, 1));

		Attendance a2_2 = new Attendance();
		a2_2.setPerson(p2);
		a2_2.setOnDate(LocalDate.of(2022, 2, 15));

		values.add(a1_1);
		values.add(a2_1);
		values.add(a1_2);
		values.add(a2_2);
		
		List<Person> result = controller.getAllOrdered(OrderBy.ATTENDANCE);

		assertEquals(2, result.size());
		assertEquals(p2, result.get(0));
		assertEquals(p1, result.get(1));
	}
	

	@Test
	void orderPersonsWithoutAttendanceLast() {
		Person p1 = new Person();
		p1.setId(1L);
		Person p2 = new Person();
		p2.setId(2L);
		Person p3 = new Person();
		p3.setId(3L);
		
		Attendance a1_1 = new Attendance();
		a1_1.setPerson(p1);
		a1_1.setOnDate(LocalDate.of(2022, 1, 10));
		
		Attendance a2_1 = new Attendance();
		a2_1.setPerson(p2);
		a2_1.setOnDate(LocalDate.of(2022, 1, 12));

		values.add(a1_1);
		values.add(a2_1);
		persons.add(p3);
		persons.add(p1);
		persons.add(p2);
		
		List<Person> result = controller.getAllOrdered(OrderBy.ATTENDANCE);

		assertEquals(3, result.size());
		assertEquals(p2, result.get(0));
		assertEquals(p1, result.get(1));
		assertEquals(p3, result.get(2));
	}

	class JoinPersonWithAttendanceAnswer implements Answer<List<Person>> {

		@Override
		public List<Person> answer(InvocationOnMock invocation) throws Throwable {
			List<Person> result = values.stream()
					.map(Attendance::getPerson)
					.filter(f -> !persons.contains(f))
					.distinct()
					.collect(Collectors.toList());
			result.addAll(persons);
			return result;
		}
	}
}
