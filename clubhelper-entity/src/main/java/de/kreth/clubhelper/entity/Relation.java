package de.kreth.clubhelper.entity;

public class Relation {

    public enum RelationType {
	RELATIONSHIP("Partner"),
	SIBLINGS("Geschwister"),
	PARENT("Elternteil"),
	CHILD("Kind");

	private final String localized;

	private RelationType(String localized) {
	    this.localized = localized;
	}

	public String getLocalized() {
	    return localized;
	}
    }

    private Person person;

    private String relation;

    public Relation(Person person, String relation) {
	super();
	this.person = person;
	this.relation = relation;
    }

    public RelationType getRelation() {
	return RelationType.valueOf(relation);
    }

    public Person getPerson() {
	return person;
    }

    public void setPerson(Person person) {
	this.person = person;
    }

    public void setRelation(String relation) {
	this.relation = relation;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((person == null) ? 0 : person.hashCode());
	result = prime * result + ((relation == null) ? 0 : relation.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Relation other = (Relation) obj;
	if (person == null) {
	    if (other.person != null) {
		return false;
	    }
	} else if (!person.equals(other.person)) {
	    return false;
	}
	if (relation == null) {
	    if (other.relation != null) {
		return false;
	    }
	} else if (!relation.equals(other.relation)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Relation [person=" + person + ", relation=" + relation + "]";
    }

}
