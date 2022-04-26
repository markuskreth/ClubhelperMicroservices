package de.kreth.clubhelper.data;

import java.io.Serializable;

/**
 * The persistent class for the groupDef database table.
 */
public class GroupDef extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public int hashCode() {
	final int prime = 53;
	return prime * super.hashCode();
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
	return "GroupDef [id=" + getId() + ", name=" + name + "]";
    }
}
