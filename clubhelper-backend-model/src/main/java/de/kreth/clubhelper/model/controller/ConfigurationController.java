package de.kreth.clubhelper.model.controller;

import java.util.Collection;
import java.util.List;

import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.idm.authorization.Permission;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
		    KeycloakSecurityContext context = settings.loginUser.getKeycloakSecurityContext();
		    settings.realm = context.getRealm();
		    AccessToken token = context.getToken();
		    settings.email = token.getEmail();
		    settings.familyName = token.getFamilyName();
		    settings.givenName = token.getGivenName();
		    settings.birthdate = token.getBirthdate();
		    settings.gender = token.getGender();
		    settings.tokenName = token.getName();
	
		    AuthorizationContext authorizationContext = context.getAuthorizationContext();
		    if (authorizationContext != null) {
		    	settings.permissions = authorizationContext.getPermissions();
		    }
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

    private KeycloakPrincipal<KeycloakSecurityContext> getLoggedInUser() {
	Authentication authentication = getAuthentication();
	Object principal = authentication.getPrincipal();
	if (principal instanceof KeycloakPrincipal) {
	    return (KeycloakPrincipal<KeycloakSecurityContext>) principal;
	} else {
	    return null;
	}
    }

    private Authentication getAuthentication() {
	return SecurityContextHolder.getContext().getAuthentication();
    }

    private class SystemSettings {
	public String tokenName;
	public String gender;
	public String birthdate;
	public String givenName;
	public String familyName;
	public String email;
	public Collection<? extends GrantedAuthority> authorities;
	public List<Permission> permissions;
	public String realm;
	public String loginUserName;
	KeycloakPrincipal<KeycloakSecurityContext> loginUser;

    }
}
