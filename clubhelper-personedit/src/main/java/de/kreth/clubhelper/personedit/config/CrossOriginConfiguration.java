package de.kreth.clubhelper.personedit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnProperty(prefix = "clubhelper", name = "allowedOrigins")
public class CrossOriginConfiguration {

	@Value("clubhelper.allowed.origins")
	String[] allowedOrigins;

	@Bean
	WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry reg) {
				reg.addMapping("/**").allowedOrigins(allowedOrigins);
			}
		};
	}
}
