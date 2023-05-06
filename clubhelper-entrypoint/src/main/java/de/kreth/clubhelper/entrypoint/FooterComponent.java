package de.kreth.clubhelper.entrypoint;

import static de.kreth.clubhelper.entrypoint.Version_Properties.BUILD_DATETIME;
import static de.kreth.clubhelper.entrypoint.Version_Properties.PROJECT_VERSION;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;

public class FooterComponent extends FormLayout {

	private static final String FORMLAYOUT_SPACING = "formlayout-spacing";
	private static final long serialVersionUID = 4845822203421115202L;

	private static final Logger LOGGER = LoggerFactory.getLogger(FooterComponent.class);

	public FooterComponent() {

		Label copyright = new Label("\u00a9 Markus Kreth\u00A0");
		copyright.addClassName(FORMLAYOUT_SPACING);
		add(copyright);

		if (propertiesLoaded()) {

			String dateTimeProperty = BUILD_DATETIME.getText();
			SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date date = sourceFormat.parse(dateTimeProperty);
				dateTimeProperty = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(date);
			} catch (ParseException e) {
				LOGGER.warn("Unable to parse dateTimeProperty=" + dateTimeProperty, e);
			}
			Label vers = new Label("\u00A0Version: " + PROJECT_VERSION.getText());
			Label buildTime = new Label("\u00A0Build: " + dateTimeProperty);
			vers.addClassName(FORMLAYOUT_SPACING);
			buildTime.addClassName(FORMLAYOUT_SPACING);
			add(vers, buildTime);
		}

	}

	private boolean propertiesLoaded() {
		return !BUILD_DATETIME.getText().contains("${");
	}

}
