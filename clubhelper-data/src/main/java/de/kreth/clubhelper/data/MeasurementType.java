package de.kreth.clubhelper.data;

public enum MeasurementType {

    JumpHeightSeconds("sek.");

    private final String unit;

    private MeasurementType(String unit) {
	this.unit = unit;
    }

    public String getUnit() {
	return unit;
    }
}
