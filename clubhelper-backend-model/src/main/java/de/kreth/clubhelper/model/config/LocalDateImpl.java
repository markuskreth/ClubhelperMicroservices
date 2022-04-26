package de.kreth.clubhelper.model.config;

import java.time.LocalDate;

class LocalDateImpl implements LocalDateProvider {

    @Override
    public LocalDate today() {
	return LocalDate.now();
    }
}
