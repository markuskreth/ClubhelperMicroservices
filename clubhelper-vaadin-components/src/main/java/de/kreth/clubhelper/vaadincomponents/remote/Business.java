package de.kreth.clubhelper.vaadincomponents.remote;

import java.util.Collection;
import java.util.List;

import de.kreth.clubhelper.data.GroupDef;
import de.kreth.clubhelper.data.Person;

public interface Business {

    List<GroupDef> getAllGroups();

    Collection<Person> getPersons();

    Person getPerson(Long personId);

}
