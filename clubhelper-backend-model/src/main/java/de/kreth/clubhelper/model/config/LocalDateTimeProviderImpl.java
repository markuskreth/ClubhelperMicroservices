package de.kreth.clubhelper.model.config;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
class LocalDateTimeProviderImpl implements LocalDateTimeProvider {

    @Override
    public LocalDateTime now() {
	return LocalDateTime.now();
    }

}
