package de.kreth.clubhelper.data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the person database table.
 */
public class Person extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8361264400619997123L;

	private LocalDate birth;
	private String prename;
	private String surname;

	private Integer gender;
	private List<GroupDef> groups;

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getPrename() {
		return prename;
	}

	public void setPrename(String prename) {
		this.prename = prename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Integer getGender() {
		return gender;
	}
	
	public boolean isMember(GroupDef group) {
		return groups != null && groups.contains(group);
	}

	public List<GroupDef> getGroups() {
		if (groups == null) {
			groups = new ArrayList<>();
		}
		return groups;
	}

	@Override
	public int hashCode() {
		final int prime = 59;
		int result = super.hashCode();
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + getId() + ", prename=" + prename + ", surname=" + surname + "]";
	}

}
