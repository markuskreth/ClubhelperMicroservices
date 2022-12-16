/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.kreth.clubhelper.model.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.kreth.clubhelper.model.Version_Properties;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Java config for Springfox swagger documentation plugin
 *
 * @author Markus Kreth
 */
@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI customOpenAPI() {

	Info info = new Info()
		.title("REST Clubhelper Api")
		.version(Version_Properties.PROJECT_VERSION.getText())
		.termsOfService("Clubhelper backend terms of service")
		.description("This is REST API documentation of the Clubhelper backend.")
		.license(createLicense())
		.contact(createContact());

	return new OpenAPI()
		.components(new Components())
		.info(info);
    }

    private Contact createContact() {
	Contact clubhelperContact = new Contact();
	clubhelperContact.setName("Markus Kreth");
	clubhelperContact.setEmail("markus.kreth@web.de");
	clubhelperContact.setUrl("https://github.com/markuskreth/ClubhelperMicroservices");
	return clubhelperContact;
    }

    private License createLicense() {
	License clubhelperLicense = new License();
	clubhelperLicense.setName("The MIT License (MIT)");
	clubhelperLicense.setUrl("http://opensource.org/licenses/MIT");
	clubhelperLicense.setExtensions(Collections.emptyMap());
	return clubhelperLicense;
    }

}
