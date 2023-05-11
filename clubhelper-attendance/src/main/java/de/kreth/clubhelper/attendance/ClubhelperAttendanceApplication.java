package de.kreth.clubhelper.attendance;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import com.vaadin.flow.server.PWA;

import de.kreth.property2java.processor.Format;
import de.kreth.property2java.processor.GenerateProperty2Java;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@PWA(name = "MTV Trampolin Anwesenheit", shortName = "Anwesenheit", 
	description = "Dies ist eine App zur Erfassung von Anwesenheiten für die Trampolingruppe des MTV Groß-Buchholz.")
@GenerateProperty2Java(resources = { "version.properties" }, format = Format.WithInnerPropertyLoader)
public class ClubhelperAttendanceApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.GERMANY);
		SpringApplication.run(ClubhelperAttendanceApplication.class, args);
	}

}
