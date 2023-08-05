package de.kreth.clubhelper.entrypoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;

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

		List<String> roles;
		if (SecurityUtils.isUserLoggedIn()) {
			roles = authentication.getAuthorities().stream()
					.map(GrantedAuthority::getAuthority)
					.collect(Collectors.toList());	
		} else {
			roles = Collections.emptyList();
		}

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
			if (principal instanceof OAuth2AuthenticationToken) {
				OAuth2AuthenticationToken keycloak = (OAuth2AuthenticationToken) principal;
				Map<String, Object> attributes = keycloak.getPrincipal().getAttributes();
				
				StringBuilder text = new StringBuilder("Angemeldet: ");
				text.append(attributes.get("GivenName")).append(" ").append(attributes.get("FamilyName")).append(" (")
						.append(attributes.get("Email")).append(")");
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
