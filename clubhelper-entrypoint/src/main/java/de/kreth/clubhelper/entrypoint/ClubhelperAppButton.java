package de.kreth.clubhelper.entrypoint;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.dom.Style;

public class ClubhelperAppButton extends Anchor {

    private static final long serialVersionUID = 1L;

    public static ClubhelperAppButton create(ClubhelperApp app) {
	Button button = new Button();
	return new ClubhelperAppButton(app, button);
    }

    public ClubhelperAppButton(ClubhelperApp app, Button button) {
	super(app.getUrl(), button);
	setTarget("_self");
	button.setText(app.getName());
	button.setWidth("150px");
	button.setHeight("150px");
	Style style = button.getStyle();
	style.set("margin", "10px");
	getElement().setProperty("title", app.getUrl());
    }

}
