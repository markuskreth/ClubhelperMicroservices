package de.kreth.clubhelper.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.kreth.clubhelper.entity.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Long> {

    List<Person> findByChangedGreaterThan(Date date);

    List<Person> findByDeletedIsNull();
    
    List<Person> findByDeletedIsNull(Sort sort);

    @Override
    List<Person> findAll();

}
