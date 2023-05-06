package de.kreth.clubhelper.entrypoint;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

import de.kreth.property2java.processor.Format;
import de.kreth.property2java.processor.GenerateProperty2Java;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@GenerateProperty2Java(resources = { "version.properties" }, format = Format.WithInnerPropertyLoader)
@PWA(name = "clubhelper", shortName = "clubhelper", offlineResources = {})
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

	private static final long serialVersionUID = 7322641713861309390L;

	public static void main(String[] args) {
		Locale.setDefault(Locale.GERMANY);
		SpringApplication.run(Application.class, args);
	}

}
