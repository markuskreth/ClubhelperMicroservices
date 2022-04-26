package de.kreth.clubhelper.data;

import java.io.Serializable;

/**
 * The persistent class for the contact database table.
 */
public class Contact extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -7631864028095077913L;

    private ContactType type;
    private String value;

    public ContactType getType() {
	return type;
    }

    public void setType(ContactType type) {
	this.type = type;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    @Override
    public int hashCode() {
	final int prime = 37;
	int result = super.hashCode();
	result = prime * result;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	return super.equals(obj);
    }

    @Override
    public String toString() {
	return "Contact [type=" + type + ", value=" + value + "]";
    }
}
