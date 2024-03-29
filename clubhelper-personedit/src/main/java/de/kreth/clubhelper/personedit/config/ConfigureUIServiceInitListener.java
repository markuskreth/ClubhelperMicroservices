package de.kreth.clubhelper.personedit.config;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.RouteParameters;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

import org.springframework.stereotype.Component;

import de.kreth.clubhelper.personedit.ui.MainView;
import de.kreth.clubhelper.personedit.ui.PersonEditor;

@Component
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

    private static final long serialVersionUID = 1L;

    @Override
    public void serviceInit(ServiceInitEvent event) {
	event.getSource().addUIInitListener(uiEvent -> {
	    final UI ui = uiEvent.getUI();
	    ui.addBeforeEnterListener(this::beforeEnter);
	});

    }

    /**
     * Reroutes the user if (s)he is not authorized to access the view.
     *
     * @param event before navigation event with event details
     */
    private void beforeEnter(BeforeEnterEvent event) {
	Class<?> navigationTarget = event.getNavigationTarget();

	if (isSecureAndNotAuthentificated(navigationTarget)) {
	    event.rerouteTo("");
	} else if (SecurityUtils.isOnlyAuthenticatedForSelf()) {
	    RouteParameters parameters = new RouteParameters("personId", "2");
//	    event.rerouteTo(PersonEditor.class, parameters);
	    event.forwardTo(PersonEditor.class, parameters);
	}

    }

    private boolean isSecureAndNotAuthentificated(Class<?> navigationTarget) {
	boolean userLoggedIn = SecurityUtils.isUserLoggedIn();
	return MainView.class.equals(navigationTarget) && !userLoggedIn;
    }
}
