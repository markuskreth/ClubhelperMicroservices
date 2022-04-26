package de.kreth.clubhelper.data;

import java.io.Serializable;

public class PersonNote extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1205022633454190496L;

    private Person person;

    private String notekey = "";

    private String notetext = "";

    public PersonNote() {
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
