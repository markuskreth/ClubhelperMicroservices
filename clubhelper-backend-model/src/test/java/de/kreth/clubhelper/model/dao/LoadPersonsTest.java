package de.kreth.clubhelper.model.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import de.kreth.clubhelper.entity.GroupDef;
import de.kreth.clubhelper.entity.Person;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
@Sql(value = "classpath:/testdata.sql")
class LoadPersonsTest {
	@Autowired
	PersonDao personDao;
	@Autowired
	GroupDao groupDao;

	private GroupDef aktive;
	private GroupDef trainer;
	private GroupDef competitor;
	private GroupDef admin;

	@BeforeEach
	void loadGroups() {
		aktive = groupDao.findById(1L).get();
		trainer = groupDao.findById(3L).get();
		competitor = groupDao.findById(7L).get();
		admin = groupDao.findById(8L).get();
		assertNotNull(aktive);
		assertNotNull(trainer);
		assertNotNull(competitor);
		assertNotNull(admin);
	}

	@Test
	void testLoadPerson1() {
		Optional<Person> person1 = personDao.findById(1L);
		assertTrue(person1.isPresent(), "Person with id=1 not found!");
		assertTrue(person1.get().isMember(trainer));
	}

	@Test
	void testLoadAll() {
		Iterable<Person> all = personDao.findAll();
		assertTrue(all.iterator().hasNext(), "No data found in Person");
	}

	@Test
	void insertPerson() {
		Person p = new Person();
		p.setId(-1);
		p.setPrename("prename");
		p.setSurname("surname");
		p.setBirth(LocalDate.of(1981, 3, 3));
		p.setGender(1);
		assertNotNull(p.getId());
		personDao.delete(p);
	}
}
