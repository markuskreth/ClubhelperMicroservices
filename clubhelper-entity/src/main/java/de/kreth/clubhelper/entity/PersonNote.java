package de.kreth.clubhelper.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class PersonNote extends BaseEntity implements PersonRelated {

    @ManyToOne
    private Person person;

    private String notekey = "";

    private String notetext = "";

    public PersonNote() {
    }

    @Override
    public Person getPerson() {
	return person;
    }

    @Override
    public void setPerson(Person person) {
	this.person = person;
    }

    public String getNotekey() {
	return notekey;
    }

    public void setNotekey(String notekey) {
	this.notekey = notekey;
    }

    public String getNotetext() {
	return notetext;
    }

    public void setNotetext(String notetext) {
	this.notetext = notetext;
    }

    @Override
    public String toString() {
	return "PersonNote [id=" + getId() + ", person=" + person + ", notekey=" + notekey + "]";
    }

}
