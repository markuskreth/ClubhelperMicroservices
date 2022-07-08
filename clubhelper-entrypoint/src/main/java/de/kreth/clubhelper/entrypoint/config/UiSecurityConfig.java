package de.kreth.clubhelper.entrypoint.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class UiSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
	KeycloakAuthenticationProvider keyCloakAuthProvider = keycloakAuthenticationProvider();
	keyCloakAuthProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
	auth.authenticationProvider(keyCloakAuthProvider);
    }

    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
	return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
	super.configure(http);
	http.cors().and()
		.addFilterAt(logoutFilter(), LogoutFilter.class)
		.addFilterBefore(keycloakPreAuthActionsFilter(), LogoutFilter.class)
		.csrf().disable()
		.anonymous().disable()
		.authorizeRequests().requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()
		.anyRequest().authenticated().and()
		.logout().addLogoutHandler(keycloakLogoutHandler()).deleteCookies("JSESSIONID")
		.invalidateHttpSession(false)
		.logoutUrl("/logout").logoutSuccessUrl("/");

    }

    @Bean
    public LogoutFilter logoutFilter() throws Exception {
	LogoutFilter logoutFilter = new LogoutFilter("/", keycloakLogoutHandler()) {
	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		    throws IOException, ServletException {
		super.doFilter(request, response, chain);
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
		    if (requiresLogout(((HttpServletRequest) request), ((HttpServletResponse) response))) {
			((HttpServletRequest) request).logout();
		    }
		}
	    }
	};
	logoutFilter.setFilterProcessesUrl("/logout");

	return logoutFilter;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers(
		// Vaadin Flow static resources //
		"/VAADIN/**",
		// the standard favicon URI
		"/favicon.ico",
		// the robots exclusion standard
		"/robots.txt",
		// For Upgrade Vaadin 23
		"/offline-stub.html",
		"/sw-runtime-resources-precache.js",
		// web application manifest //
		"/manifest.webmanifest", "/sw.js", "/offline-page.html",
		// (development mode) static resources //
		"/frontend/**",
		// (development mode) webjars //
		"/webjars/**",
		// (production mode) static resources //
		"/frontend-es5/**", "/frontend-es6/**");
    }

    @Bean
    public static KeycloakConfigResolver keycloakConfigResolver() {
	return new KeycloakSpringBootConfigResolver();
    }

}
