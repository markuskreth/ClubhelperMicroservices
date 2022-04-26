package de.kreth.clubhelper.data;

import java.io.Serializable;

/**
 * The persistent class for the deleted_entries database table.
 */
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
