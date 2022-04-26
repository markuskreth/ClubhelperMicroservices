package de.kreth.clubhelper.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.kreth.clubhelper.entity.Relative;

public interface RelativeDao extends CrudRepository<Relative, Long> {

    @Query(value = "SELECT * FROM clubhelper.relative r where r.person1=?1 or r.person2=?1", nativeQuery = true)
    List<Relative> findByPersonId1OrPerson2Id(long personId);

}
