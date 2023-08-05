package de.kreth.clubhelper.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import de.kreth.property2java.processor.Format;
import de.kreth.property2java.processor.GenerateProperty2Java;

@SpringBootApplication
@EntityScan("de.kreth.clubhelper.entity")
@GenerateProperty2Java(resources = "version.properties", format = Format.WithInnerPropertyLoader)
public class ClubhelperModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubhelperModelApplication.class, args);
	}

}
