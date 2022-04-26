package de.kreth.clubhelper.model.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.kreth.clubhelper.entity.Startpass;
import de.kreth.clubhelper.model.dao.StartpassDao;

@RestController
@RequestMapping("/startpass")
public class StartpassController extends AbstractControllerPersonRelated<Startpass, StartpassDao> {

    public StartpassController() {
	super(Startpass.class);
    }

}
