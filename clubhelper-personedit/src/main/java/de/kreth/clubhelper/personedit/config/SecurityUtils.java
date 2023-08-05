package de.kreth.clubhelper.personedit.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.servlet.http.HttpServletRequest;

import com.vaadin.flow.shared.ApplicationConstants;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
	/**
	 * Tests if the request is an internal framework request. The test consists of
	 * checking if the request parameter is present and if its value is consistent
	 * with any of the request types know.
	 *
	 * @param request {@link HttpServletRequest}
	 * @return true if is an internal framework request. False otherwise.
	 */
	static boolean isFrameworkInternalRequest(HttpServletRequest request) {
		final String parameterValue = request.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER);

		return parameterValue != null && Stream.of(com.vaadin.flow.server.HandlerHelper.RequestType.values())
				.anyMatch(r -> r.getIdentifier().equals(parameterValue));
	}

	static boolean isUserLoggedIn() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null //
				&& !(authentication instanceof AnonymousAuthenticationToken) //
				&& authentication.isAuthenticated(); //
	}

	static boolean isOnlyAuthenticatedForSelf() {
		if (isUserLoggedIn()) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			List<String> authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
					.collect(Collectors.toList());
			Arrays.asList("ROLE_admin", "ROLE_trainer");
			boolean containsAny = authorities.contains("ROLE_admin") || authorities.contains("ROLE_trainer");
			return !containsAny;
		}
		return false;
	}
}
