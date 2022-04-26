package de.kreth.clubhelper.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "pflichten")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pflicht extends BaseEntity implements Serializable, Comparable<Pflicht> {

    private static final long serialVersionUID = -5461809622545899132L;

    private String name;

    private boolean fixed;

    private int ordered;

    private String comment;

    public Pflicht() {
    }

    public Pflicht(String name, boolean fixed, int ordered, String comment) {
	this.name = name;
	this.fixed = fixed;
	this.ordered = ordered;
	this.comment = comment;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public boolean isFixed() {
	return fixed;
    }

    public void setFixed(boolean fixed) {
	this.fixed = fixed;
    }

    public int getOrdered() {
	return ordered;
    }

    public void setOrdered(int ordered) {
	this.ordered = ordered;
    }

    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

    @Override
    public int hashCode() {
	final int prime = 71;
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
	return name;
    }

    @Override
    public int compareTo(Pflicht o) {
	return Integer.compare(ordered, o.ordered);
    }
}
