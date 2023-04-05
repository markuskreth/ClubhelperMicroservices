package de.kreth.clubhelper.messungen.config;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.web.client.RestTemplate;

@KeycloakConfiguration
@ConditionalOnProperty(name = "keycloak.enabled", havingValue = "false", matchIfMissing = false)
public class KeycloakDisabledConfiguration {

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/**");
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
