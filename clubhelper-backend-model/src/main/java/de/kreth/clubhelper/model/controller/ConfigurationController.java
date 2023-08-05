package de.kreth.clubhelper.model.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/systemsettings")
@PreAuthorize("hasRole('ROLE_admin')")
public class ConfigurationController {

	@GetMapping
	public @ResponseBody SystemSettings getSystemInfo() {

		Authentication authentication = getAuthentication();

		SystemSettings settings = new SystemSettings();
		settings.loginUser = getLoggedInUser();
		settings.loginUserName = authentication.getName();
		settings.authorities = authentication.getAuthorities();

		if (settings.loginUser != null) {
			settings.familyName = settings.loginUser.getName();
			settings.givenName = settings.loginUser.getName();
			settings.tokenName = settings.loginUser.getName();
		}
		return settings;
	}

	@GetMapping("/secured")
	@Secured("ROLE_TRAINER")
	public @ResponseBody String secured() {
		return getAuthentication().getAuthorities().toString();
	}

	@GetMapping("/trainer")
	@PreAuthorize("hasRole('ROLE_trainer')")
	public @ResponseBody String withoutRolePrefix() {
		return getAuthentication().getAuthorities().toString();
	}

	@GetMapping("/authority")
	@PreAuthorize("hasAuthority('TRAINER')")
	public @ResponseBody String authority() {
		return getAuthentication().getAuthorities().toString();
	}

	@GetMapping("/roletrainer")
	@PreAuthorize("hasRole('ROLE_TRAINER')")
	public @ResponseBody String withRolePrefix() {
		return getAuthentication().getAuthorities().toString();
	}

	private Principal getLoggedInUser() {
		Authentication authentication = getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof Principal) {
			return (Principal) principal;
		} else {
			Map<String, Object> attributes = Collections.emptyMap();
			attributes = ((JwtAuthenticationToken) authentication).getTokenAttributes();
			return null;
		}
	}

	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	private class SystemSettings {
		public Principal loginUser;
		public String tokenName;
		public String gender;
		public String birthdate;
		public String givenName;
		public String familyName;
		public String email;
		public Collection<? extends GrantedAuthority> authorities;
		public String realm;
		public String loginUserName;

	}
}
