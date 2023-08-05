package de.kreth.clubhelper.model.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.kreth.clubhelper.entity.Attendance;
import de.kreth.clubhelper.entity.Person;

public interface AttendanceDao extends CrudRepository<Attendance, Long>, ClubhelperDaoPersonRelated<Attendance> {

	List<Attendance> findByOnDate(LocalDate onDate);

	List<Attendance> findByOnDateBetween(LocalDate startDate, LocalDate endDate);

	Attendance findByPersonAndOnDate(Person person, LocalDate onDate);

	List<Attendance> findByChangedGreaterThan(LocalDateTime date);
}
