package de.kreth.clubhelper.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.keycloak.adapters.springboot.KeycloakAutoConfiguration;
import org.keycloak.adapters.springboot.KeycloakBaseSpringBootConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import de.kreth.clubhelper.entity.Attendance;
import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.model.controller.AttendanceController;
import de.kreth.clubhelper.model.dao.AttendanceDao;
import de.kreth.clubhelper.model.dao.PersonDao;

@WebMvcTest(excludeAutoConfiguration = {
	SecurityAutoConfiguration.class,
	KeycloakAutoConfiguration.class,
	KeycloakBaseSpringBootConfiguration.class }, controllers = { AttendanceController.class })
class AttendanceControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    PersonDao personDao;
    @MockBean
    AttendanceDao attendanceDao;

    private LocalDate onDate;

    private Attendance attendance;

    private Person person;

    @BeforeEach
    void initTestData() {
	onDate = LocalDate.of(2020, 10, 10);

//	LocalDateTime created = LocalDateTime.of(2020, 10, 10, 18, 15, 15);
	person = new Person();
	person.setId(1);
	person.setPrename("prename");
	person.setSurname("surname");
//	person.setCreated(created);
//	person.setChanged(created);

	attendance = new Attendance();
	attendance.setPerson(person);
	attendance.setId(1);
	attendance.setOnDate(onDate);
//	attendance.setChanged(created);
//	attendance.setCreated(created);

    }

    @Test
    void attencanceTest() {
	assertNotNull(mvc);
	assertNotNull(personDao);
	assertNotNull(attendanceDao);
    }

    @Test
    void callAttendanceListEmpty() throws Exception {

	mvc.perform(get("/attendance/" + onDate.format(DateTimeFormatter.ISO_DATE)))
		.andExpect(status().isOk())
		.andExpect(content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
		.andExpect(content().json("[]"));
    }

    @Test
    void callAttendanceListOne() throws Exception {

	List<Attendance> asList = new ArrayList<>();
	asList.add(attendance);

	when(attendanceDao.findByOnDate(onDate)).thenReturn(asList);

	mvc.perform(get("/attendance/" + onDate.format(DateTimeFormatter.ISO_DATE)))
		.andExpect(status().isOk())
		.andExpect(content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
		.andExpect(content().json(
			"[{\"id\":1,\"changed\":null,\"created\":null,\"deleted\":null,\"onDate\":\"2020-10-10\""
				+ ",\"person\":{\"id\":1,\"changed\":null,\"created\":null,\"deleted\":null,\"birth\":null"
				+ ",\"prename\":\"prename\",\"surname\":\"surname\""
				+ ",\"gender\":null,\"groups\":[]}}]"));
    }

    @Test
    void deleteAttendanceListOne() throws Exception {

	when(attendanceDao.findByPersonAndOnDate(person, onDate)).thenReturn(attendance);
	when(personDao.findById(person.getId())).thenReturn(Optional.of(person));

	mvc.perform(delete("/attendance/" + attendance.getPerson().getId()
		+ "/" + onDate.format(DateTimeFormatter.ISO_DATE)))
		.andExpect(status().isOk());
    }
}
