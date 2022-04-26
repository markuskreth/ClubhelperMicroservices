package de.kreth.clubhelper.model.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.keycloak.adapters.springboot.KeycloakAutoConfiguration;
import org.keycloak.adapters.springboot.KeycloakBaseSpringBootConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import de.kreth.clubhelper.entity.Person;
import de.kreth.clubhelper.model.config.LocalDateTimeProvider;
import de.kreth.clubhelper.model.dao.PersonDao;

@WebMvcTest(excludeAutoConfiguration = {
	DataSourceAutoConfiguration.class,
	JdbcRepositoriesAutoConfiguration.class,
	DataSourceTransactionManagerAutoConfiguration.class,
	JdbcTemplateAutoConfiguration.class,
	SecurityAutoConfiguration.class,
	KeycloakAutoConfiguration.class,
	KeycloakBaseSpringBootConfiguration.class
}, controllers = { PersonController.class })
@Disabled
class PersonMvcTest {

    @MockBean(name = "personDao")
    PersonDao personDao;

    @MockBean
    LocalDateTimeProvider localDateTimeProvider;

    @Autowired
    MockMvc mvc;

    LocalDateTime now;

    private Person p1;
    private Person p2;

    private Person deleted;

    @BeforeEach
    void initMocks() {

	p1 = new Person();
	p1.setId(1);
	p1.setPrename("prename");
	p1.setSurname("surname");
	p1.setBirth(LocalDate.of(2000, 1, 1));
	p1.setGender(1);

	p2 = new Person();
	p2.setId(1);
	p2.setPrename("prename");
	p2.setSurname("surname");
	p2.setBirth(LocalDate.of(2000, 1, 1));
	p2.setGender(1);

	deleted = new Person();
	deleted.setId(1);
	deleted.setPrename("prename");
	deleted.setSurname("surname");
	deleted.setBirth(LocalDate.of(2000, 1, 1));
	deleted.setGender(1);
	deleted.setDeleted(LocalDateTime.of(2020, 11, 11, 11, 11, 11));

	now = LocalDateTime.of(2020, 11, 13, 22, 22, 22);

	when(personDao.findAll()).thenReturn(Arrays.asList(p1, p2, deleted));
	when(personDao.findByDeletedIsNull()).thenReturn(Arrays.asList(p1, p2));
	when(personDao.findById(1L)).thenReturn(Optional.of(p1));
	when(personDao.findById(2L)).thenReturn(Optional.of(p2));
    }

    @Test
    void callAllPersons() throws Exception {
	String jsonListOfPersons = "["
		+ "{\"id\":1,\"changed\":null,\"created\":null,\"deleted\":null,\"birth\":\"2000-01-01\",\"prename\":\"prename\",\"surname\":\"surname\""
		+ ",\"gender\":{\"id\":1},\"groups\":[]},"
		+ "{\"id\":1,\"changed\":null,\"created\":null,\"deleted\":null,\"birth\":\"2000-01-01\",\"prename\":\"prename\",\"surname\":\"surname\""
		+ ",\"gender\":{\"id\":1},\"groups\":[]}]";
	mvc.perform(get("/person").accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML))
		.andExpect(status().isOk())
		.andExpect(content().string(jsonListOfPersons));
    }

    @Test
    void callPerson1() throws Exception {
	String jsonListOfPersons = "{\"id\":1,\"changed\":null,\"created\":null,\"deleted\":null,\"birth\":\"2000-01-01\",\"prename\":\"prename\",\"surname\":\"surname\""
		+ ",\"gender\":{\"id\":1},\"groups\":[]}";

	mvc.perform(get("/person/1").accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML))
		.andExpect(status().isOk())
		.andExpect(content().string(jsonListOfPersons));
    }
}
