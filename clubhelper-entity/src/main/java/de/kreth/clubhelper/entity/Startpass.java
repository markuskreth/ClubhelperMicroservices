package de.kreth.clubhelper.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the startpaesse database table.
 * 
 */
@Entity
@Table(name = "startpaesse")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Startpass extends BaseEntity implements Serializable, PersonRelated {

    private static final long serialVersionUID = 1L;

    @Column(name = "startpass_nr")
    private String startpassNr;

    @OneToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    // bi-directional many-to-one association to StartpassStartrechte
    @OneToMany(mappedBy = "startpaesse")
    private List<StartpassStartrechte> startpassStartrechte;

    public StartpassStartrechte addStartpassStartrechte(StartpassStartrechte startpassStartrechte) {
	if (this.startpassStartrechte == null) {
	    this.startpassStartrechte = new ArrayList<>();
	}
	this.startpassStartrechte.add(startpassStartrechte);
	startpassStartrechte.setStartpaesse(this);

	return startpassStartrechte;
    }

    public StartpassStartrechte removeStartpassStartrechte(StartpassStartrechte startpassStartrechte) {
	if (this.startpassStartrechte == null) {
	    this.startpassStartrechte = new ArrayList<>();
	}
	this.startpassStartrechte.remove(startpassStartrechte);
	startpassStartrechte.setStartpaesse(null);

	return startpassStartrechte;
    }

    public String getStartpassNr() {
	return startpassNr;
    }

    public void setStartpassNr(String startpassNr) {
	this.startpassNr = startpassNr;
    }

    @Override
    public Person getPerson() {
	return person;
    }

    @Override
    public void setPerson(Person person) {
	this.person = person;
    }

    public List<StartpassStartrechte> getStartpassStartrechte() {
	return startpassStartrechte;
    }

    public void setStartpassStartrechte(List<StartpassStartrechte> startpassStartrechte) {
	this.startpassStartrechte = startpassStartrechte;
    }

    @Override
    public int hashCode() {
	final int prime = 79;
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
	return "Startpass [startpassNr=" + startpassNr + "]";
    }

}
