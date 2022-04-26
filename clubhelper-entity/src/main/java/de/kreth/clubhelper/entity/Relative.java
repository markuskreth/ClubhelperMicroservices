package de.kreth.clubhelper.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





/**
 * The persistent class for the relative database table.
 */
@Entity
@Table(name = "relative")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Relative extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "TO_PERSON1_RELATION")
    private String toPerson1Relation;

    @Column(name = "TO_PERSON2_RELATION")
    private String toPerson2Relation;

    // bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "person1")
    private Person person1Bean;

    // bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "person2")
    private Person person2Bean;

    public Relative() {
    }

    public Relative(long id, String toPerson1Relation, String toPerson2Relation, Person person1Bean,
	    Person person2Bean) {
	super();
	setId(id);
	this.toPerson1Relation = toPerson1Relation;
	this.toPerson2Relation = toPerson2Relation;
	this.person1Bean = person1Bean;
	this.person2Bean = person2Bean;
    }

    public String getToPerson1Relation() {
	return toPerson1Relation;
    }

    public void setToPerson1Relation(String toPerson1Relation) {
	this.toPerson1Relation = toPerson1Relation;
    }

    public String getToPerson2Relation() {
	return toPerson2Relation;
    }

    public void setToPerson2Relation(String toPerson2Relation) {
	this.toPerson2Relation = toPerson2Relation;
    }

    public Person getPerson1Bean() {
	return person1Bean;
    }

    public void setPerson1Bean(Person person1Bean) {
	this.person1Bean = person1Bean;
    }

    public Person getPerson2Bean() {
	return person2Bean;
    }

    public void setPerson2Bean(Person person2Bean) {
	this.person2Bean = person2Bean;
    }

    public Relation getRelationTo(Person person) {
	if (person == null) {
	    return null;
	}
	if (person.equals(person1Bean)) {
	    return new Relation(person2Bean, toPerson2Relation);
	} else if (person.equals(person2Bean)) {
	    return new Relation(person1Bean, toPerson1Relation);
	} else {
	    return null;
	}
    }

    @Override
    public int hashCode() {
	final int prime = 73;
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
	return "Relative [person1Bean=" + person1Bean + ", toPerson2Relation=" + toPerson2Relation + ", person2Bean="
		+ person2Bean + "]";
    }
}
