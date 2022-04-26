package de.kreth.clubhelper.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.kreth.clubhelper.entity.GroupDef;

public interface GroupDao extends CrudRepository<GroupDef, Long> {

    List<GroupDef> findByChangedGreaterThan(Date date);
}
