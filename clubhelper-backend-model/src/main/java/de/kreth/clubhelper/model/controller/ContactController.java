package de.kreth.clubhelper.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

import de.kreth.clubhelper.data.ContactType;
import de.kreth.clubhelper.entity.Contact;
import de.kreth.clubhelper.model.dao.ContactDao;

@RestController
@RequestMapping("/contact")
@PreAuthorize("isAuthenticated()")
public class ContactController extends AbstractControllerPersonRelated<Contact, ContactDao> {

    private static final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ContactController() {
	super(Contact.class);
    }

    @Override
    protected void beforeSave(Contact toSave) {
	super.beforeSave(toSave);
	ContactType type = ContactType.valueByName(toSave.getType());
	switch (type) {
	case EMAIL:
	    toSave.setValue(toSave.getValue().strip());
	    break;
	case MOBILE:
	case PHONE:
	    updatePhoneNumber(toSave);
	    break;
	default:
	    break;
	}
    }

    private void updatePhoneNumber(Contact toSave) {
	try {
	    PhoneNumber number = phoneUtil.parse(toSave.getValue(), "DE");
	    if (phoneUtil.isValidNumber(number)) {
		toSave.setValue(phoneUtil.format(number, PhoneNumberFormat.NATIONAL));
	    }
	} catch (NumberParseException e) {
	    logger.warn("Error parsing Phone Number: {}", toSave);
	}
    }
}
