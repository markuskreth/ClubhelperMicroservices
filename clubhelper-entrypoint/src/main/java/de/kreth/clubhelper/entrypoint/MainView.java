package de.kreth.clubhelper.entrypoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import de.kreth.clubhelper.entrypoint.config.SecurityUtils;

@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends Div {

    private static final long serialVersionUID = 1L;
    private final List<ClubhelperApp> apps = new ArrayList<>();
    private final AppService service;

    public MainView(@Autowired AppService service) {
	this.service = service;
	this.setSizeFull();
	doRefresh();
    }

    public void doRefresh() {
	this.removeAll();

	SecurityContext context = SecurityContextHolder.getContext();
	Authentication authentication = context.getAuthentication();
	showUserInformation(authentication);
	add(new Paragraph());
	apps.clear();
	List<ClubhelperApp> allRegisteredApps = service.getAllRegisteredApps();

	apps.addAll(allRegisteredApps);

	List<String> roles = authentication.getAuthorities().stream()
		.map(GrantedAuthority::getAuthority)
		.collect(Collectors.toList());

	apps.stream()
		.filter(a -> filterByAuthentication(a, roles))
		.map(ClubhelperButton::createAppButton)
		.forEach(MainView.this::add);
	add(new Paragraph());
	add(new FooterComponent());
    }

    private void showUserInformation(Authentication authentication) {
	if (SecurityUtils.isUserLoggedIn()) {

	    Object principal = authentication.getPrincipal();
	    if (principal instanceof KeycloakPrincipal) {
		@SuppressWarnings("unchecked")
		KeycloakPrincipal<KeycloakSecurityContext> keycloak = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
		KeycloakSecurityContext context = keycloak.getKeycloakSecurityContext();
		AccessToken token = context.getToken();
		StringBuilder text = new StringBuilder("Angemeldet: ");
		text.append(token.getGivenName()).append(" ")
			.append(token.getFamilyName()).append(" (")
			.append(token.getEmail()).append(")");
		add(new H2(text.toString()));
		add(ClubhelperButton.createButton("/logout", "Abmelden"));
	    } else {
		add(new H2("Angemeldet: " + authentication.getName()));
		add(ClubhelperButton.createButton("/logout", "Abmelden"));
	    }
	} else {
	    add(ClubhelperButton.createButton("/login", "Anmelden"));
	}
    }

    private boolean filterByAuthentication(ClubhelperApp app, List<String> roles) {
	if (app.validForAllRoles()) {
	    return true;
	}
	boolean isAuthenticated = false;
	for (String string : roles) {
	    if (app.validForRole(string)) {
		isAuthenticated = true;
		break;
	    }
	}
	return isAuthenticated;
    }

}
