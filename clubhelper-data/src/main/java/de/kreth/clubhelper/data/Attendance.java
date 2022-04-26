package de.kreth.clubhelper.data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The persistent class for the attendance database table.
 */
public class Attendance extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2385033161272078335L;

    private LocalDate onDate;

    private Person person;

    public LocalDate getOnDate() {
	return this.onDate;
    }

    public Person getPerson() {
	return person;
    }

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
