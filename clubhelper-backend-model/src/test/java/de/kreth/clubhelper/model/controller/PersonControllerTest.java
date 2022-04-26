package de.kreth.clubhelper.model.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import de.kreth.clubhelper.entity.GroupDef;
import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.model.dao.PersonDao;
import de.kreth.clubhelper.model.testing.TestingDateTimeProvider;

@DataJpaTest
public class PersonControllerTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonDao personDao;
    private TestingDateTimeProvider localDateTimeProvider;

    private PersonController controller;
    private Person person;
    private LocalDateTime now;
    private GroupDef active;
    private GroupDef ehemalig;

    private GroupDef attendante;

    private GroupDef trainer;

    private GroupDef competitors;

    @BeforeEach
    void initController() {

	now = LocalDateTime.of(2020, 11, 12, 21, 32, 13);
	localDateTimeProvider = new TestingDateTimeProvider(() -> LocalDateTime.of(2020, 11, 12, 21, 38, 13));

	controller = new PersonController();
	controller.setPersonDao(personDao);
	controller.setLocalDateTimeProvider(localDateTimeProvider);

	person = new Person();
	person.setBirth(LocalDate.of(2000, 1, 1));
	person.setGender(2);
	person.setPrename("prename");
	person.setSurname("surname");
	person.setChanged(now);
	person.setCreated(now);

	prepareDatabase();

	person.getGroups().add(active);
    }

    private void prepareDatabase() {
	active = new GroupDef();
	active.setName("ACTIVE");
	active.setChanged(now);
	active.setCreated(now);

	attendante = new GroupDef();
	attendante.setName("Angehörige");
	attendante.setChanged(now);
	attendante.setCreated(now);

	trainer = new GroupDef();
	trainer.setName("Übungsleiter");
	trainer.setChanged(now);
	trainer.setCreated(now);

	ehemalig = new GroupDef();
	ehemalig.setName("EHEMALIGE");
	ehemalig.setChanged(now);
	ehemalig.setCreated(now);

	competitors = new GroupDef();
	competitors.setName("Wettkämpfer");
	competitors.setChanged(now);
	competitors.setCreated(now);

	active = entityManager.persist(active);
	attendante = entityManager.persist(attendante);
	trainer = entityManager.persist(trainer);
	ehemalig = entityManager.persist(ehemalig);
	competitors = entityManager.persist(competitors);

	EntityManager em = entityManager.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<GroupDef> cq = cb.createQuery(GroupDef.class);
	Root<GroupDef> rootEntry = cq.from(GroupDef.class);
	CriteriaQuery<GroupDef> all = cq.select(rootEntry);
	TypedQuery<GroupDef> allQuery = em.createQuery(all);
	List<GroupDef> resultList = allQuery.getResultList();
	assertEquals(5, resultList.size());
    }

    @Test
    void testDaoInsert() {
	Person saved = personDao.save(person);
	assertNotNull(personDao.findById(saved.getId()));
    }

    @Test
    void testPost() {
	controller.insert(person);

	List<Person> list = findAllEntity();
	assertEquals(1, list.size());
	Person next = list.get(0);

	assertEquals(localDateTimeProvider.now(), next.getChanged());
	assertNotEquals(now, next.getCreated());
    }

    private List<Person> findAllEntity() {

	EntityManager em = entityManager.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Person> cq = cb.createQuery(Person.class);
	Root<Person> rootEntry = cq.from(Person.class);
	CriteriaQuery<Person> all = cq.select(rootEntry);
	TypedQuery<Person> allQuery = em.createQuery(all);
	return allQuery.getResultList();
    }

    @Test
    void testPutChangeGroup() {
	Person saved = entityManager.persist(person);
	assertEquals(saved.getChanged(), now);

	saved.getGroups().clear();
	saved.getGroups().add(ehemalig);
	controller.update(saved.getId(), saved);

	List<Person> list = findAllEntity();
	assertEquals(1, list.size());
	Person next = list.get(0);

	assertEquals(localDateTimeProvider.now(), next.getChanged());
	assertEquals(1, next.getGroups().size());
	assertEquals(ehemalig, next.getGroups().get(0));

    }

    @Test
    void testDelete() {

	Person saved = entityManager.persist(person);
	assertEquals(saved.getChanged(), now);

	controller.delete(saved.getId());

	List<Person> list = findAllEntity();
	assertEquals(1, list.size());
	Person next = list.get(0);

	assertTrue(next.isDeleted());
	assertEquals(localDateTimeProvider.now(), next.getDeleted());
	assertFalse(controller.getAll().iterator().hasNext(), "Deleted should not be found.");

	assertEquals(1, controller.getAllIncludingDeleted().size());
    }
}
