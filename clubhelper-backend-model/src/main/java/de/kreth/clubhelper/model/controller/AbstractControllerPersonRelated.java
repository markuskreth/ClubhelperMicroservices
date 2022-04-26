package de.kreth.clubhelper.model.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.kreth.clubhelper.entity.BaseEntity;
import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.entity.PersonRelated;
import de.kreth.clubhelper.model.dao.ClubhelperDaoPersonRelated;
import de.kreth.clubhelper.model.dao.PersonDao;

/**
 * Default Controller implementing all functionality for all {@link Data} types.
 *
 * @param <T> Data type
 */
@RestController
//@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'STAFF')")
public abstract class AbstractControllerPersonRelated<T extends BaseEntity & PersonRelated, D extends CrudRepository<T, Long> & ClubhelperDaoPersonRelated<T>>
	extends AbstractController<T, D> {

    private PersonDao personDao;

    protected AbstractControllerPersonRelated(Class<T> element) {
	super(element);
    }

    @Autowired
    public void setPersonDao(PersonDao personDao) {
	this.personDao = personDao;
    }

    /**
     * Rest: GET - return List of object having the (Person object) id as property.
     * <p>
     * Mapping: /for/{id}
     *
     * @param id Id matching all objects property.
     * @return List of object with certain property matching id.
     */
    @GetMapping(value = "/for/{id}")
    public List<T> getByParentId(@PathVariable("id") long id) {
	if (dao instanceof ClubhelperDaoPersonRelated) {
	    List<T> findByPersonId = dao.findByPersonId(id);
	    return findByPersonId;
	}
	return Collections.emptyList();
    }

    @PutMapping(value = "/for/{id}")
    public void putForParent(@PathVariable("id") long id, @RequestBody T toUpdate) {

	Optional<Person> person = personDao.findById(id);
	if (!person.isPresent()) {
	    throw new IllegalStateException("Person with ID=" + id + " is not persistent.");
	}
	if (toUpdate.getPerson() == null) {
	    toUpdate.setPerson(person.get());
	} else if (toUpdate.getPerson().getId() != id) {
	    throw new IllegalStateException("Requestet Path ID is not equal to " + toUpdate + " Person Id.");
	}

	LocalDateTime now = LocalDateTime.now();

	toUpdate.setChanged(now);

	beforeSave(toUpdate);
	dao.save(toUpdate);
    }

    @PostMapping(value = "/for/{id}")
    public T postForPerson(@PathVariable("id") Long id, @RequestBody T toCreate) {
	Optional<Person> person = personDao.findById(id);
	if (person.isPresent()) {

	    LocalDateTime now = LocalDateTime.now();

	    toCreate.setChanged(now);

	    if (toCreate.getCreated() == null) {
		toCreate.setCreated(now);
	    }

	    toCreate.setPerson(person.get());

	    if (toCreate.getId() < 0) {
		beforeSave(toCreate);
		return dao.save(toCreate);
	    }
	    T byId = getById(toCreate.getId());
	    if (byId != null) {
		toCreate.setDeleted(null);
		beforeSave(toCreate);
		return dao.save(toCreate);
	    }
	    beforeSave(toCreate);
	    return dao.save(toCreate);
	}
	throw new IllegalStateException("Person with ID=" + id + " is not persistent.");
    }

    protected void beforeSave(T toSave) {

    }
}