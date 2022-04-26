package de.kreth.clubhelper.model.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonControllerLocalDateEqualsTest {

	private PersonController controller;
	@BeforeEach
	void init() {
		controller = new PersonController();
	}

	@ParameterizedTest
	@MethodSource("localDateIsEqualValues")
	void localDateIsEqual(boolean expected, LocalDate d1, LocalDate d2) {
		assertEquals(expected, controller.isEqual(d1, d2));
	}
	
	static Stream<Arguments> localDateIsEqualValues() {
		return Stream.of(Arguments.arguments(true, null, null)
				, Arguments.arguments(true, LocalDate.of(2022, 4, 10), LocalDate.of(2022, 4, 10))
				, Arguments.arguments(false, LocalDate.of(2022, 4, 11), LocalDate.of(2022, 4, 10))
				, Arguments.arguments(false, LocalDate.of(2022, 4, 10), LocalDate.of(2022, 4, 11))
				, Arguments.arguments(false, null, LocalDate.of(2022, 4, 10))
				, Arguments.arguments(false, LocalDate.of(2022, 4, 10), null));
	}
	
}
