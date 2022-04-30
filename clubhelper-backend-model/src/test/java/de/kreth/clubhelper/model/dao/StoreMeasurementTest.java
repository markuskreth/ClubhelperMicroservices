package de.kreth.clubhelper.model.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import de.kreth.clubhelper.data.MeasurementType;
import de.kreth.clubhelper.entity.Measurement;
import de.kreth.clubhelper.entity.Person;

@DataJpaTest()
@TestPropertySource(properties = {
	"spring.jpa.hibernate.ddl-auto=none"
})
class StoreMeasurementTest {
    @Autowired
    PersonDao personDao;
    @Autowired
    MeasurementDao measurementDao;

    @Test
    void testLoadPerson1() {
	Optional<Person> person1 = personDao.findById(1L);
	assertTrue(person1.isPresent(), "Person with id=1 not found!");
    }

    @Test
    void insertMeasurement() {
	Measurement m = new Measurement();
	m.setPerson(personDao.findById(1L).get());
	m.setMeasured(234.234);
	m.setMeasurementType(MeasurementType.JumpHeightSeconds);
	m.setOnTime(LocalDateTime.now());
	measurementDao.save(m);
    }
}
