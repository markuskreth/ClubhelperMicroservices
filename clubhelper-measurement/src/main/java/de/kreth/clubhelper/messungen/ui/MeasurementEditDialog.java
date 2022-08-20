package de.kreth.clubhelper.messungen.ui;

import com.vaadin.flow.component.dialog.Dialog;

import de.kreth.clubhelper.data.Measurement;

public class MeasurementEditDialog extends Dialog {

    private Measurement measurement;

    public MeasurementEditDialog(Measurement measurement) {
	this.measurement = measurement;

    }
}
