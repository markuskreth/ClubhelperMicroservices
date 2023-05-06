package de.kreth.clubhelper.entrypoint;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.dom.Style;

public class ClubhelperButton extends Anchor {

	private static final long serialVersionUID = 1L;

	public static ClubhelperButton createAppButton(ClubhelperApp app) {
		String url = app.getUrl();
		String name = app.getName();
		return new ClubhelperButton(url, name, new Button());
	}

	public static ClubhelperButton createButton(String url, String name) {
		return new ClubhelperButton(url, name, new Button());
	}

	private ClubhelperButton(String url, String name, Button button) {
		super(url, button);
		setTarget("_self");
		button.setText(name);
		button.setWidth("150px");
		button.setHeight("150px");
		Style style = button.getStyle();
		style.set("margin", "10px");
		getElement().setProperty("title", url);
	}

}
