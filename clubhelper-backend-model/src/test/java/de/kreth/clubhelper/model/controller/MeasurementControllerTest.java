package de.kreth.clubhelper.model.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.keycloak.adapters.springboot.KeycloakAutoConfiguration;
import org.keycloak.adapters.springboot.KeycloakBaseSpringBootConfiguration;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.entity.Measurement;
import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.model.dao.MeasurementDao;
import de.kreth.clubhelper.model.dao.PersonDao;

@WebMvcTest(excludeAutoConfiguration = {
	SecurityAutoConfiguration.class,
	KeycloakAutoConfiguration.class,
	KeycloakBaseSpringBootConfiguration.class }, controllers = { MeasurementController.class })
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

    private Measurement measurement;

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

	measurement = new Measurement();
	measurement.setId(1);
	measurement.setPerson(person);
	measurement.setMeasurementType(MeasurementType.JumpHeightSeconds);
	measurement.setClassification("10 Strecksprünge");
	measurement.setOnTime(onDate);
	measurement.setMeasured(17.3);

    }

    @Test
    void initializedTest() {
	assertNotNull(mvc);
	assertNotNull(personDao);
	assertNotNull(measurementDao);
    }

    @Test
    void callAttendanceListEmpty() throws Exception {

	mvc.perform(get("/measurement/for/" + person.getId()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
		.andExpect(content().json("[]"));
    }

    @Test
    void callMeasurementListOne() throws Exception {

	List<Measurement> asList = new ArrayList<>();
	asList.add(measurement);

	when(measurementDao.findByPersonId(person.getId())).thenAnswer(new Answer<List<Measurement>>() {

	    @Override
	    public List<Measurement> answer(InvocationOnMock invocation) throws Throwable {
		return asList;
	    }
	});
	StringWriter writer = new StringWriter();
	objectMapper.writeValue(writer, measurement);

	mvc.perform(get("/measurement/for/" + person.getId()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
		.andExpect(content().json(
			"{\"id\":1,\"changed\":null,\"created\":null,\"deleted\":null,\"onTime\":\"2022-04-01T18:55:13\","
				+ "\"measurementType\":\"JumpHeightSeconds\","
				+ "\"classification\":\"10 Strecksprünge\",\"measured\":17.3}",
			true));
    }

}
