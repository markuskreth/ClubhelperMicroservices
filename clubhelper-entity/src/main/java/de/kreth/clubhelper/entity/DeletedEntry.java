package de.kreth.clubhelper.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * The persistent class for the deleted_entries database table.
 */
@Entity
@Table(name = "deleted_entries")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DeletedEntry extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -4271189592258131845L;
    private long entryId;
    private String tablename;

    public long getEntryId() {
	return entryId;
    }

    public void setEntryId(long entryId) {
	this.entryId = entryId;
    }

    public String getTablename() {
	return tablename;
    }

    public void setTablename(String tablename) {
	this.tablename = tablename;
    }

    @Override
    public int hashCode() {
	final int prime = 47;
	int result = super.hashCode();
	result = (int) (prime * result + entryId);
	result = prime * result + ((tablename == null) ? 0 : tablename.hashCode());
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
	return "DeletedEntry [entryId=" + entryId + ", tablename=" + tablename + "]";
    }
}
