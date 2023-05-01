package de.kreth.clubhelper.messungen.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import de.kreth.clubhelper.messungen.remote.MeasurementBusiness;
import de.kreth.clubhelper.vaadincomponents.views.PersonListView;

@PageTitle("Messungen")
@Route(value = "")
public class MessungenMainView extends PersonListView<PersonMeasurementOverviewView> {

	private static final long serialVersionUID = -1076655556793621082L;

	public MessungenMainView(@Autowired MeasurementBusiness measurementBusiness) {
		super(measurementBusiness, PersonMeasurementOverviewView.class);
		add(new FooterComponent());
	}

}
