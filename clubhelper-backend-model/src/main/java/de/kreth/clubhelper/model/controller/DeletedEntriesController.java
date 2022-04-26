package de.kreth.clubhelper.model.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.kreth.clubhelper.entity.DeletedEntry;
import de.kreth.clubhelper.model.dao.DeletedEntriesDao;

@RestController
@RequestMapping("/deletedentries")
public class DeletedEntriesController extends AbstractController<DeletedEntry, DeletedEntriesDao> {

    public DeletedEntriesController() {
	super(DeletedEntry.class);
    }

}
