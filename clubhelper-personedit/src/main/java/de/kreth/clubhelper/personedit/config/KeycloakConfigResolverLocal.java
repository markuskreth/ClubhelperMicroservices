package de.kreth.clubhelper.personedit.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test & !development")
public class KeycloakConfigResolverLocal {

	@Bean
	public KeycloakConfigResolver keyCloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}

}
