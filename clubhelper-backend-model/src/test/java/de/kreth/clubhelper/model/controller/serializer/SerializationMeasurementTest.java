package de.kreth.clubhelper.model.controller.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.entity.Measurement;
import de.kreth.clubhelper.entity.Person;

@JsonTest
class SerializationMeasurementTest {

    @Autowired
    private ObjectMapper objectMapper;
    private LocalDateTime now;

    @BeforeEach
    void init() {
	now = LocalDateTime.now();
    }

    @Test
    void serializeAndDeserializeMeasurement() throws IOException {
	Measurement m = new Measurement();
	m.setChanged(now);
	m.setCreated(now);
	m.setClassification("Kür");
	m.setMeasurementType(MeasurementType.JumpHeightSeconds);
	m.setOnTime(now);
	m.setId(3L);
	m.setMeasured(17.3);
	m.setPerson(new Person());

	String json = objectMapper.writeValueAsString(m);
	de.kreth.clubhelper.data.Measurement data = objectMapper.readValue(json,
		de.kreth.clubhelper.data.Measurement.class);
	assertEquals(m.getClassification(), data.getClassification());
	assertEquals(m.getMeasured(), data.getMeasured());
	assertEquals(m.getOnTime(), data.getOnTime());
	assertEquals(m.getChanged(), data.getChanged());
    }
}
