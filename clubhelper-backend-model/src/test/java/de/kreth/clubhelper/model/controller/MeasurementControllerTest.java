package de.kreth.clubhelper.model.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.entity.Measurement;
import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.model.dao.MeasurementDao;
import de.kreth.clubhelper.model.dao.PersonDao;

@WebMvcTest(excludeAutoConfiguration = { SecurityAutoConfiguration.class }, controllers = {
		MeasurementController.class })
class MeasurementControllerTest {

	@Autowired
	MockMvc mvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	PersonDao personDao;
	@MockBean
	MeasurementDao measurementDao;

	private LocalDateTime onDate;

	private Measurement measurement1;
	private Measurement measurement2;
	private Measurement measurement3;

	private Person person;

	@BeforeEach
	void initTestData() {

		onDate = LocalDateTime.of(2022, Month.APRIL, 1, 18, 55, 13);
//	LocalDateTime created = LocalDateTime.of(2020, 10, 10, 18, 15, 15);
		person = new Person();
		person.setId(1);
		person.setPrename("prename");
		person.setSurname("surname");
//	person.setCreated(created);
//	person.setChanged(created);

		measurement1 = new Measurement();
		measurement1.setId(1);
		measurement1.setPerson(person);
		measurement1.setMeasurementType(MeasurementType.JumpHeightSeconds);
		measurement1.setClassification("10 Strecksprünge");
		measurement1.setOnTime(onDate);
		measurement1.setMeasured(17.3);

		measurement2 = new Measurement();
		measurement2.setId(2);
		measurement2.setPerson(person);
		measurement2.setMeasurementType(MeasurementType.JumpHeightSeconds);
		measurement2.setClassification("10 Strecksprünge");
		measurement2.setOnTime(onDate.plusDays(2));
		measurement2.setMeasured(16.3);

		measurement3 = new Measurement();
		measurement3.setId(2);
		measurement3.setPerson(person);
		measurement3.setMeasurementType(MeasurementType.JumpHeightSeconds);
		measurement3.setClassification("Kür");
		measurement3.setOnTime(onDate.plusDays(2));
		measurement3.setMeasured(16.3);

	}

	@Test
	void initializedTest() {
		assertNotNull(mvc);
		assertNotNull(personDao);
		assertNotNull(measurementDao);
	}

	@Test
	void callAttendanceListEmpty() throws Exception {

		mvc.perform(get("/measurement/for/" + person.getId())).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON.toString()))
				.andExpect(content().json("[]"));
	}

	@Test
	void callMeasurementListOne() throws Exception {

		List<Measurement> asList = new ArrayList<>();
		asList.add(measurement1);
		asList.add(measurement2);

		when(measurementDao.findByPersonId(person.getId())).thenAnswer(i -> asList);
		when(measurementDao.findByPersonIdAndDeletedIsNull(person.getId())).thenAnswer(i -> asList);
		StringWriter writer = new StringWriter();
		objectMapper.writeValue(writer, measurement1);

		mvc.perform(get("/measurement/for/" + person.getId())).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON.toString()))
//		.andExpect(content().encoding(StandardCharsets.UTF_8))
				.andExpect(content().json(
						"[{\"id\":1,\"changed\":null,\"created\":null,\"deleted\":null,\"onTime\":\"2022-04-01T18:55:13\","
								+ "\"measurementType\":\"JumpHeightSeconds\","
								+ "\"classification\":\"10 Strecksprünge\",\"measured\":17.3},"
								+ "{\"id\":2,\"changed\":null,\"created\":null,\"deleted\":null,\"onTime\":\"2022-04-03T18:55:13\","
								+ "\"measurementType\":\"JumpHeightSeconds\","
								+ "\"classification\":\"10 Strecksprünge\",\"measured\":16.3}]",
						true));
	}

	@Test
	void listClassifications() throws Exception {

		List<Measurement> asList = new ArrayList<>();
		asList.add(measurement1);
		asList.add(measurement2);
		asList.add(measurement3);

		Set<String> types = asList.stream().map(Measurement::getClassification).collect(Collectors.toSet());

		when(measurementDao.findAll()).thenAnswer(i -> asList);
		when(measurementDao.findClassificationsByType(ArgumentMatchers.any())).thenAnswer(i -> types);

		MvcResult result = mvc.perform(get("/measurement/types")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON.toString()))
//		.andExpect(content().encoding(StandardCharsets.UTF_8))
				.andReturn();

		String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		JSONAssert.assertEquals("{\"JumpHeightSeconds\":[\"Kür\",\"10 Strecksprünge\"]}", contentAsString, true);
	}
}
