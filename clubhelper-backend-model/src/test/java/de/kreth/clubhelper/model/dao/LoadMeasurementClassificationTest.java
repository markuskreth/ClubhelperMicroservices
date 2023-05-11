package de.kreth.clubhelper.model.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import de.kreth.clubhelper.data.MeasurementType;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
class LoadMeasurementClassificationTest {

	@Autowired
	private MeasurementDao measurementDao;

	@Test
	void loadAllMeasures() {
		assertNotEquals(0, measurementDao.count());
	}

	@Test
	void loadClassificationsForType() {
		Set<String> list = measurementDao.findClassificationsByType(MeasurementType.JumpHeightSeconds);
		assertFalse(list.isEmpty(), "Es sollten Werte gefunden werden.");
	}
}
