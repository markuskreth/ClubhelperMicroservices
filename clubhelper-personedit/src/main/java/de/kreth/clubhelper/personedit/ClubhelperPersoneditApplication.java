package de.kreth.clubhelper.personedit;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

import de.kreth.property2java.processor.Format;
import de.kreth.property2java.processor.GenerateProperty2Java;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableCaching
@GenerateProperty2Java(resources = { "version.properties" }, format = Format.WithInnerPropertyLoader)
public class ClubhelperPersoneditApplication {

    public static void main(String[] args) {
	Locale.setDefault(Locale.GERMANY);
	SpringApplication.run(ClubhelperPersoneditApplication.class, args);
    }

}
