package de.kreth.clubhelper.model.aspects;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.kreth.clubhelper.entity.BaseEntity;
import de.kreth.clubhelper.entity.DeletedEntry;
import de.kreth.clubhelper.model.dao.DeletedEntriesDao;
import de.kreth.clubhelper.model.utils.TimeProvider;

@Aspect
@Component
public class DeletedStorageAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private DeletedEntriesDao deletedEntriesDao;
    private TimeProvider time;

    @Autowired
    public void setTime(TimeProvider time) {
	this.time = time;
    }

    @Autowired
    public DeletedStorageAspect(DeletedEntriesDao deletedEntriesDao) {
	super();
	this.deletedEntriesDao = deletedEntriesDao;
    }

    @Pointcut("execution (public * de.kreth.clubhelper.model.controller.AbstractController.delete(..))")
    private void invocation() {
    }

    @AfterReturning(pointcut = "invocation()", returning = "deleted")
    public void storeDeleted(JoinPoint joinPoint, BaseEntity deleted) {

	logger.debug("Deleted: " + deleted);
	Class<?> class1 = deleted.getClass();

	while (!class1.getSuperclass().equals(Object.class)
		&& !Modifier.isAbstract(class1.getSuperclass().getModifiers()))
	    class1 = class1.getSuperclass();

	String tableName = class1.getSimpleName();
	long id = deleted.getId();
	LocalDateTime now = time.getNow();

	DeletedEntry entry = new DeletedEntry();
	entry.setTablename(tableName);
	entry.setEntryId(id);
	entry.setChanged(now);
	entry.setCreated(now);
	logger.info("Inserted Deleteentry: {}", entry);
	deletedEntriesDao.save(entry);
    }

}
