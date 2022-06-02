package de.kreth.clubhelper.measurement.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import de.kreth.clubhelper.measurement.remote.MeasurementBusiness;
import de.kreth.clubhelper.vaadincomponents.views.PersonListView;

@Route
@RouteAlias("/")
@PageTitle("Personenliste")
public class MeasurementRootView extends PersonListView<PersonMeasurementOverviewView> {

    private static final long serialVersionUID = -1076655556793621082L;

    public MeasurementRootView(@Autowired MeasurementBusiness measurementBusiness) {
	super(measurementBusiness, PersonMeasurementOverviewView.class);
    }

}
