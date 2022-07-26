package de.kreth.clubhelper.attendance;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import de.kreth.property2java.processor.GenerateProperty2Java;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@GenerateProperty2Java(resources = { "version.properties" })
public class ClubhelperAttendanceApplication {

    public static void main(String[] args) {
	Locale.setDefault(Locale.GERMANY);
	SpringApplication.run(ClubhelperAttendanceApplication.class, args);
    }

}
