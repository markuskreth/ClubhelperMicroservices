package de.kreth.clubhelper.model.controller.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.kreth.clubhelper.entity.Attendance;
import de.kreth.clubhelper.entity.Person;

@JsonTest
@Disabled
public class AttendanceSerializationTest {

    @Autowired
    private ObjectMapper objectMapper;
    private Person person;
    private Attendance attendance;

    @BeforeEach
    void initTestPerson() {
	person = new Person();
	person.setPrename("Vorname");
	person.setSurname("Nachname");
	person.setBirth(LocalDate.of(2000, 1, 1));
	person.setGender(2);
	LocalDateTime creationTime = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
	person.setCreated(creationTime);
	person.setChanged(creationTime);
	attendance = new Attendance();
	attendance.setId(1);
	attendance.setCreated(creationTime);
	attendance.setChanged(creationTime);
	attendance.setOnDate(LocalDate.of(2020, 11, 16));
	attendance.setPerson(person);
    }

    @Test
    void testSerializeAttendance() throws JsonProcessingException {
	String jsonString = objectMapper.writeValueAsString(attendance);
	String expected = "{\"id\":1,\"changed\":\"2020-10-10T10:10:10\","
		+ "\"created\":\"2020-10-10T10:10:10\",\"deleted\":null,"
		+ "\"onDate\":\"2020-11-16\",\"person\":{\"id\":0"
		+ ",\"changed\":\"2020-10-10T10:10:10\","
		+ "\"created\":\"2020-10-10T10:10:10\",\"deleted\":null,"
		+ "\"birth\":\"2000-01-01\",\"prename\":\"Vorname\","
		+ "\"surname\":\"Nachname\",\"gender\":{\"id\":2},\"groups\":[]}}";
	assertEquals(expected, jsonString);
    }

    @Test
    void testDeserializeAttendance() throws JsonMappingException, IOException {
	String json = "{\"id\":1,\"changed\":\"2020-10-10T10:10:10\","
		+ "\"created\":\"2020-10-10T10:10:10\",\"deleted\":null,"
		+ "\"onDate\":\"2020-11-16\",\"person\":{\"id\":0"
		+ ",\"changed\":\"2020-10-10T10:10:10\","
		+ "\"created\":\"2020-10-10T10:10:10\",\"deleted\":null,"
		+ "\"birth\":\"2000-01-01\",\"prename\":\"Vorname\","
		+ "\"surname\":\"Nachname\",\"gender\":null,\"groups\":[]}}";

	Attendance deserialized = objectMapper.readValue(json, Attendance.class);
	assertEquals(attendance, deserialized);
    }
}
