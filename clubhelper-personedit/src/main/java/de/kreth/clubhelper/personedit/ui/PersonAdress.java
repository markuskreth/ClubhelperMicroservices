package de.kreth.clubhelper.personedit.ui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;

import de.kreth.clubhelper.data.Adress;
import de.kreth.clubhelper.personedit.data.DetailedPerson;
import de.kreth.clubhelper.personedit.remote.Business;
import de.kreth.clubhelper.personedit.ui.components.WithUnsavedChangesSupport;

public class PersonAdress extends Div implements PersonEditorComponent, WithUnsavedChangesSupport {

    private static final long serialVersionUID = 6206418422244291021L;
    private Business business;

    private TextField adress1;
    private TextField adress2;
    private TextField plz;
    private TextField city;
    private Binder<Adress> binder;
    private DetailedPerson personDetails;
    private Adress adress;

    public PersonAdress(Business business) {
	this.business = business;
	adress1 = new TextField();
	adress1.setLabel("Adresse 1");
	adress1.setPlaceholder("Straße");
	adress2 = new TextField();
	adress2.setLabel("Adresse 2");
	plz = new TextField();
	plz.setMaxLength(5);
	plz.setPlaceholder("PLZ");
	plz.setLabel("PLZ");
	city = new TextField();
	city.setLabel("Stadt");
	city.setPlaceholder("Stadt");

	adress1.setValueChangeMode(ValueChangeMode.TIMEOUT);
	adress1.setValueChangeTimeout(700);

	adress2.setValueChangeMode(ValueChangeMode.TIMEOUT);
	adress2.setValueChangeTimeout(700);

	plz.setValueChangeMode(ValueChangeMode.TIMEOUT);
	plz.setValueChangeTimeout(700);

	city.setValueChangeMode(ValueChangeMode.TIMEOUT);
	city.setValueChangeTimeout(700);

	Button storeButton = new Button("Speichern", this::storeChanges);
	storeButton.getStyle().set("margin", "3px");
	storeButton.setEnabled(false);

	FormLayout layout = new FormLayout(adress1, adress2, plz, city, storeButton);
	add(layout);

	binder = new Binder<>();
	binder.forField(adress1).asRequired("Straße muss gesetzt sein.").bind(Adress::getAdress1, Adress::setAdress1);
	binder.forField(adress2).bind(Adress::getAdress2, Adress::setAdress2);
	binder.forField(plz).asRequired("Postleitzahl muss gesetzt sein.").bind(Adress::getPlz, Adress::setPlz);
	binder.forField(city).asRequired("Ort muss gesetzt sein.").bind(Adress::getCity, Adress::setCity);

	binder.addValueChangeListener(ev -> storeButton.setEnabled(hasChangedAndIsOk()));
    }

    private boolean hasChangedAndIsOk() {
	return binder.hasChanges() && binder.validate().isOk();
    }

    private void storeChanges(ClickEvent<Button> ev) {
	storeChanges();
    }

    private void storeChanges() {
	if (binder.writeBeanIfValid(adress)) {
	    business.store(personDetails, adress, Adress.class);
	}
    }

    @Override
    public void init(DetailedPerson personDetails) {
	this.personDetails = personDetails;
	this.adress = business.getPersonAdress(personDetails.getId());
	binder.readBean(adress);
    }

    @Override
    public boolean hasUnsavedChanges() {
	return binder.hasChanges();
    }

}
