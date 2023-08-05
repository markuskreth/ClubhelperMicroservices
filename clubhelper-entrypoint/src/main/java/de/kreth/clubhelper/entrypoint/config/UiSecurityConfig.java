package de.kreth.clubhelper.entrypoint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class UiSecurityConfig {

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		config.applyPermitDefaultValues();

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("*", config);
		return new CorsFilter(source);
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers(
				// Vaadin Flow static resources //
				"/VAADIN/**",
				// the standard favicon URI
				"/favicon.ico",
				// the robots exclusion standard
				"/robots.txt",
				// For Upgrade Vaadin 23
				"/offline-stub.html", "/sw-runtime-resources-precache.js",
				// web application manifest //
				"/manifest.webmanifest", "/sw.js", "/offline-page.html",
				// (development mode) static resources //
				"/frontend/**",
				// (development mode) webjars //
				"/webjars/**",
				// (production mode) static resources //
				"/frontend-es5/**", "/frontend-es6/**");
	}

}
