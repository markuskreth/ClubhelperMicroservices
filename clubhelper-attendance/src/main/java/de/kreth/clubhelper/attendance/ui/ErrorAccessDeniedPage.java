package de.kreth.clubhelper.attendance.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("accessDeniedPage")
public class ErrorAccessDeniedPage extends Div {

    private static final long serialVersionUID = 6559971421027644505L;

    public ErrorAccessDeniedPage() {
	add(new H1("Zugriff verweigert"));
	add(new Text(
		"Der Zugriff ist nur Trainern und Administratoren gestattet. Falls Sie Zugriff haben sollten, wenden Sie sich bitte an einen Administrator."));
    }
}
