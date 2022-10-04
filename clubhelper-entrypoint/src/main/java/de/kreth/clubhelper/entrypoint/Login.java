package de.kreth.clubhelper.entrypoint;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route("login")
public class Login extends Div implements BeforeEnterObserver {

    private static final long serialVersionUID = 3018636189274509421L;

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
	beforeEnterEvent.forwardTo(MainView.class);
    }

}
