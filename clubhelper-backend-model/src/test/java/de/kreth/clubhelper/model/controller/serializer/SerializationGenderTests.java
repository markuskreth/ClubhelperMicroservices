package de.kreth.clubhelper.model.controller.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.kreth.clubhelper.entity.Person;

@JsonTest
public class SerializationGenderTests {

    @Autowired
    private ObjectMapper objectMapper;
    private Person person;

    @BeforeEach
    void initTestPerson() {
	person = new Person();
	person.setPrename("Vorname");
	person.setSurname("Nachname");
	person.setBirth(LocalDate.of(2000, 1, 1));
	person.setGender(2);
	person.setCreated(LocalDateTime.of(2020, 10, 10, 10, 10, 10));
	person.setChanged(LocalDateTime.of(2020, 10, 10, 10, 10, 10));
    }

    @Test
    void serializeFemale() throws Exception {
	String personJson = objectMapper.writeValueAsString(person);

	int indexOfGender = personJson.indexOf("gender");
	indexOfGender = personJson.indexOf(":", indexOfGender + 1);
	indexOfGender++;

	int endOfGenderValue = personJson.indexOf(",", indexOfGender + 1);
	if (endOfGenderValue < indexOfGender) {
	    endOfGenderValue = personJson.length();
	}
	String genderValue = personJson.substring(indexOfGender, endOfGenderValue);
	assertEquals("2", genderValue, "Gender not serialized: " + genderValue);
    }

    @Test
    void deserializeFemale() throws Exception {
	String json = "{\n" +
		"	\"id\": 0,\n" +
		"	\"changed\": \"2020-10-10T10:10:10\",\n" +
		"	\"created\": \"2020-10-10T10:10:10\",\n" +
		"	\"deleted\": null,\n" +
		"	\"birth\": \"2000-01-01\",\n" +
		"	\"prename\": \"Vorname\",\n" +
		"	\"surname\": \"Nachname\",\n" +
		"	\"gender\": \"2\",\n" +
		"	\"groups\": null\n" +
		"}";

	Person p = objectMapper.readValue(json, Person.class);

	assertEquals(2, p.getGender());
    }

    @Test
    void serializeNull() throws Exception {
	person.setGender((Integer)null);
	String personJson = objectMapper.writeValueAsString(person);

	int indexOfGender = personJson.indexOf("gender");
	indexOfGender = personJson.indexOf(":", indexOfGender + 1);
	indexOfGender++;
	String genderValue = personJson.substring(indexOfGender);
	assertTrue(genderValue.startsWith("null"), "Gender not serialized: " + genderValue);
    }

    @Test
    void deserializeNull() throws Exception {
	String json = "{\n" +
		"	\"id\": 0,\n" +
		"	\"changed\": \"2020-10-10T10:10:10\",\n" +
		"	\"created\": \"2020-10-10T10:10:10\",\n" +
		"	\"deleted\": null,\n" +
		"	\"birth\": \"2000-01-01\",\n" +
		"	\"prename\": \"Vorname\",\n" +
		"	\"surname\": \"Nachname\",\n" +
		"	\"gender\": null,\n" +
		"	\"groups\": null\n" +
		"}";

	Person p = objectMapper.readValue(json, Person.class);

	assertNull(p.getGender());
    }
}
