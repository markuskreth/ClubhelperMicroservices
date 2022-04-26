package de.kreth.clubhelper.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.kreth.clubhelper.entity.DeletedEntry;

public interface DeletedEntriesDao extends CrudRepository<DeletedEntry, Long> {

    List<DeletedEntry> findByChangedGreaterThan(Date date);
}
