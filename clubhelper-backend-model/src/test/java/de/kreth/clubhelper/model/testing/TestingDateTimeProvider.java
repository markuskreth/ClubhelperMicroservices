package de.kreth.clubhelper.model.testing;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import de.kreth.clubhelper.model.config.LocalDateTimeProvider;

public class TestingDateTimeProvider implements LocalDateTimeProvider {

    Supplier<LocalDateTime> supplier;

    public TestingDateTimeProvider() {
	this(() -> LocalDateTime.now());
    }

    public TestingDateTimeProvider(Supplier<LocalDateTime> supplier) {
	super();
	this.supplier = supplier;
    }

    @Override
    public LocalDateTime now() {
	return supplier.get();
    }

}
