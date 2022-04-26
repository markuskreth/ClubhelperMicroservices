package de.kreth.clubhelper.model.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.entity.Relative;
import de.kreth.clubhelper.model.dao.RelativeDao;

@RestController
@RequestMapping("/relative")
@PreAuthorize("hasRole('ROLE_trainer')")
public class RelativeController extends AbstractController<Relative, RelativeDao> {

    @Autowired
    private RelativeDao relativeDao;

    public RelativeController() {
	super(Relative.class);
    }

    @GetMapping(value = "/for/{id}")
    public List<Relative> getByParentId(long id) {
	return relativeDao.findByPersonId1OrPerson2Id(id).stream()
		.map(r -> map(id, r))
		.collect(Collectors.toList());
    }

    private Relation map(long forPersonId, Relative relative) {
	Relation r;
	if (relative.getPerson2Bean().getId() == forPersonId) {
	    r = new Relation(relative.getToPerson1Relation(), relative.getPerson1Bean());
	} else {
	    r = new Relation(relative.getToPerson2Relation(), relative.getPerson2Bean());
	}
	r.setChanged(relative.getChanged());
	r.setCreated(relative.getCreated());
	r.setId(relative.getId());
	r.setDeleted(relative.getDeleted());
	return r;
    }

    public class Relation extends Relative {

	private static final long serialVersionUID = -4881464721582462186L;

	private final String relationType;
	private final Person relative;

	private Relation(String relationType, Person relative) {
	    super();
	    this.relationType = relationType;
	    this.relative = relative;

	}

	public String getRelationType() {
	    return relationType;
	}

	public Person getRelative() {
	    return relative;
	}

	@JsonIgnore
	@Override
	public Person getPerson1Bean() {
	    return super.getPerson1Bean();
	}

	@JsonIgnore
	@Override
	public Person getPerson2Bean() {
	    return super.getPerson2Bean();
	}

	@JsonIgnore
	@Override
	public String getToPerson1Relation() {
	    return super.getToPerson1Relation();
	}

	@JsonIgnore
	@Override
	public String getToPerson2Relation() {
	    return super.getToPerson2Relation();
	}
    }
}
