package de.kreth.clubhelper.measurement.data;

import java.util.Arrays;
import java.util.List;

public enum ClassificationType {
    Streckspruenge, Hocken, Graetschen, Hechten, Pflicht, Kuer;

    private static final List<Character> pflichtCharacters = Arrays.asList('P', 'M', 'W');

    public String format(String description) {
	switch (this) {
	case Streckspruenge:
	    return "Strecksprünge";
	case Hocken:
	    return "Hocken";
	case Graetschen:
	    return "Grätschen";
	case Hechten:
	    return "Hechten";
	case Pflicht:
	    return formatPflicht(description);
	case Kuer:
	    checkKuerDescription(description);
	    return description.strip();
	default:
	    throw new IllegalStateException(); // Must not happen.
	}
    }

    public String getErrorDescription(String description) {
	if (description == null) {
	    return "Must not be null";
	}
	if (!description.matches(".*[a-zA-Z]+.*")) {
	    return "Kür Beschreibung muss zumindest einen Buchstaben enthalten.";
	}
	if (description.strip().length() < 3) {
	    return "Kür Beschreibung muss zumindest 2 Zeichen enthalten.";
	}
	throw new IllegalArgumentException(description + " is correct.");
    }

    public boolean isCorrect(String description) {
	if (description == null) {
	    return false;
	}
	if (!description.matches(".*[a-zA-Z]+.*")) {
	    return false;
	}
	if (description.strip().length() < 3) {
	    return false;
	}
	return true;
    }

    void checkKuerDescription(String description) {
	if (description == null || !description.matches(".*[a-zA-Z]+.*")) {
	    throw new IllegalStateException("Kür Beschreibung muss zumindest einen Buchstaben enthalten.");
	}
	if (description.strip().length() < 3) {
	    throw new IllegalStateException("Kür Beschreibung muss zumindest 2 Zeichen enthalten.");
	}

    }

    String formatPflicht(String description) {
	if (description == null) {
	    throw new IllegalStateException("Kür Beschreibung muss zumindest einen Buchstaben enthalten.");
	}
	StringBuilder string = new StringBuilder(description.trim());

	if (string.length() == 0) {
	    throw new IllegalStateException("Pflicht Beschreibung darf nicht leer sein.");
	}
	Character firstChar = Character.toUpperCase(string.charAt(0));
	if (!pflichtCharacters.contains(firstChar)) {
	    throw new IllegalStateException(
		    "Pflicht Beschreibung muss mit einem dieser Buchstaben beginnen: " + pflichtCharacters);
	}
	string.setCharAt(0, firstChar.charValue());
	return string.toString();
    }
}
