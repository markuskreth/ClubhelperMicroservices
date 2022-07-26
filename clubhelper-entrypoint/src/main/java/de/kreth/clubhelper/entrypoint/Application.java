package de.kreth.clubhelper.entrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.vaadin.flow.server.PWA;

import de.kreth.property2java.processor.GenerateProperty2Java;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@GenerateProperty2Java(resources = { "version.properties" })
@PWA(name = "clubhelper", shortName = "clubhelper", offlineResources = {})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

}
