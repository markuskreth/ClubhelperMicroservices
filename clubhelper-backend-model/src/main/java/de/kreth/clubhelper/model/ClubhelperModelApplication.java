package de.kreth.clubhelper.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("de.kreth.clubhelper.entity")
//@EnableWebMvc
public class ClubhelperModelApplication {

    public static void main(String[] args) {
	SpringApplication.run(ClubhelperModelApplication.class, args);
    }

}
