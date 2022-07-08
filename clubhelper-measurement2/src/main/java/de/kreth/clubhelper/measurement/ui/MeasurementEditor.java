package de.kreth.clubhelper.measurement.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;

import de.kreth.clubhelper.measurement.remote.MeasurementBusiness;

public class MeasurementEditor extends Div implements HasUrlParameter<Long> {

    private static final long serialVersionUID = -5998573178775745809L;
    private final MeasurementBusiness business;

    public MeasurementEditor(@Autowired MeasurementBusiness business) {
	super();
	this.business = business;
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {

    }

}
