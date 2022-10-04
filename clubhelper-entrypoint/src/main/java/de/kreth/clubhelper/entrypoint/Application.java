package de.kreth.clubhelper.entrypoint;

import java.util.Locale;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import de.kreth.property2java.processor.GenerateProperty2Java;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@GenerateProperty2Java(resources = { "version.properties" })
@PWA(name = "clubhelper", shortName = "clubhelper", offlineResources = {})
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {
	Locale.setDefault(Locale.GERMANY);
	SpringApplication.run(Application.class, args);
    }

}
