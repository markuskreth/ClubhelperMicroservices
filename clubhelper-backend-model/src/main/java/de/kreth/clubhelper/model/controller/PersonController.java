package de.kreth.clubhelper.model.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.kreth.clubhelper.data.OrderBy;
import de.kreth.clubhelper.entity.Attendance;
import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.model.config.LocalDateTimeProvider;
import de.kreth.clubhelper.model.dao.AttendanceDao;
import de.kreth.clubhelper.model.dao.PersonDao;

@RestController
@RequestMapping("/person")
@PreAuthorize("isAuthenticated()")
public class PersonController {

	private LocalDateTimeProvider localDateTimeProvider;

	private PersonDao personDao;
    private AttendanceDao attendanceDao;

	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Autowired
	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}
	
	@Autowired
	public void setLocalDateTimeProvider(LocalDateTimeProvider localDateTimeProvider) {
		this.localDateTimeProvider = localDateTimeProvider;
	}

	@GetMapping
	@PreAuthorize("hasAnyRole('trainer', 'admin')")
	public @ResponseBody List<Person> getAll() {
		return personDao.findByDeletedIsNull();
	}

	@GetMapping(value = "/ordered/{order}")
	@PreAuthorize("hasAnyRole('trainer', 'admin')")
	public @ResponseBody List<Person> getAllOrdered(@PathVariable("order")OrderBy order) {

		List<Person> list;
		switch (order) {
		case ATTENDANCE:
			list = orderByAttendance();
			break;
		case NAME:
			list = personDao.findByDeletedIsNull(Sort.by(Order.asc("surname"), Order.asc("prename")));
			break;
		default:
			list = personDao.findByDeletedIsNull(Sort.by(Order.asc("id")));
			break;
		}
		
		return list;
	}

	private List<Person> orderByAttendance() {

		Map<Person, Long> personMap = getAll()
				.parallelStream()
				.collect(Collectors.toMap(Function.identity(), a -> 0L));
		
		List<Attendance> attendances = attendanceDao
				.findByChangedGreaterThan(LocalDateTime.now().minusYears(2));
		
		Map<Person, LocalDate> personLastDate = new HashMap<>();
		
		for (Attendance attendance : attendances) {
			Person person = attendance.getPerson();
			if (person.isDeleted()) {
				continue;
			}
			Long count = personMap.get(person);
			personMap.put(person, count + 1);
			if (personLastDate.containsKey(person)) {
				if (attendance.getOnDate().isAfter(personLastDate.get(person))) {
					personLastDate.put(person, attendance.getOnDate());
				}
			} else {
				personLastDate.put(person, attendance.getOnDate());
			}
		}

		List<Person> result = new ArrayList<Person>(personMap.keySet());
		result.sort(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				LocalDate date1 = personLastDate.get(o1);
				LocalDate date2 = personLastDate.get(o2);
				if (isEqual(date1, date2)) {
					long count1 = personMap.get(o1).longValue();
					long count2 = personMap.get(o2).longValue();
					return Long.compare(count1, count2);	
				} else if (date1 == null || date2 == null) {
					if (date1 == null) {
						return 1;
					} else {
						return -1;
					}
				} else {
					int compareTo = date2.compareTo(date1);
					if (compareTo == 0) {
						compareTo = Long.compare(o1.getId(), o2.getId());
					}
					return compareTo;
				}
			}
		});
		
		return result;
	}

	boolean isEqual (LocalDate d1, LocalDate d2) {
		if (d1 == null && d2 == null) {
			return true;
		}
		if (d1 != null) {
			return d1.equals(d2);
		} else {
			return d2.equals(d1);
		}
		
	}
	
	@GetMapping(value = "/withdeleted")
	@PreAuthorize("hasAnyRole('trainer', 'admin')")
	public @ResponseBody List<Person> getAllIncludingDeleted() {
		return personDao.findAll();
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody Optional<Person> getById(@PathVariable("id") final long id) {
		return personDao.findById(id);
	}

	@DeleteMapping(value = "/{id}")
	public @ResponseBody Person delete(@PathVariable("id") final long id) {
		Optional<Person> optional = personDao.findById(id);
		if (optional.isPresent()) {
			Person person = optional.get();
//	    for (Contact c : contactController.getByParentId(person.getId())) {
//		contactController.delete(c.getId());
//	    }
//	    for (Adress a : adressController.getByParentId(person.getId())) {
//		adressController.delete(a.getId());
//	    }
			person.setDeleted(localDateTimeProvider.now());
			personDao.save(person);
		}

		return optional.orElseThrow(() -> new RuntimeException("Person not found by id=" + id));
	}

	@PutMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('trainer', 'admin')")
//    @ApiOperation("Change an existing Person. Restricted to trainers and admins.")
	public Person update(@PathVariable("id") final long id, @RequestBody Person person) {
		if (id != person.getId()) {
			throw new IllegalArgumentException("path id must match person id.");
		}
		if (person.getId() == null || person.getId() < 0) {
			throw new IllegalStateException("For update id must be set and person must be persistent.");
		}
		person.setChanged(localDateTimeProvider.now());
		personDao.save(person);
		return person;
	}

	@PostMapping
	@PreAuthorize("hasAnyRole('trainer', 'admin')")
//    @ApiOperation("Insert a new Person. Restricted to trainers and admins.")
	public Person insert(@RequestBody Person p) {

		LocalDateTime now = localDateTimeProvider.now();
		p.setChanged(now);
		p.setCreated(now);
		Person saved = personDao.save(p);
		return saved;
	}

}
