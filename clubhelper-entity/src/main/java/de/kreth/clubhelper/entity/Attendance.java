package de.kreth.clubhelper.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the attendance database table.
 */
@Entity
@Table(name = "attendance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Attendance extends BaseEntity implements Serializable, PersonRelated {

	private static final long serialVersionUID = 2385033161272078335L;

	@Column(name = "on_date")
	private LocalDate onDate;

	@ManyToOne
	private Person person;

	public LocalDate getOnDate() {
		return this.onDate;
	}

	@Override
	public Person getPerson() {
		return person;
	}

	@Override
	public void setPerson(Person person) {
		this.person = person;
	}

	public void setOnDate(LocalDate onDate) {
		this.onDate = onDate;
	}

	@Override
	public int hashCode() {
		final int prime = 103;
		int result = super.hashCode();
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Attendance [person=" + person + ", onDate=" + onDate + "]";
	}
}
