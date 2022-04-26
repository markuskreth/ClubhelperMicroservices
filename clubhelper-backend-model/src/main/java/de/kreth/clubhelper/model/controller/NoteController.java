package de.kreth.clubhelper.model.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.kreth.clubhelper.entity.PersonNote;
import de.kreth.clubhelper.model.dao.PersonNoteDao;

@RestController
@RequestMapping("/personnote")
@PreAuthorize("hasRole('ROLE_trainer')")
public class NoteController extends AbstractControllerPersonRelated<PersonNote, PersonNoteDao> {

    protected NoteController() {
	super(PersonNote.class);
    }

}
