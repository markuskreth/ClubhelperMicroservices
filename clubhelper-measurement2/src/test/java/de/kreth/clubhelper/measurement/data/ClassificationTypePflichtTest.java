package de.kreth.clubhelper.measurement.data;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ClassificationTypePflichtTest {

    @ParameterizedTest
    @MethodSource("provideIllegalArguments")
    void testIllegalKuerDescriptions(String description) {
	Assertions.assertThrows(IllegalStateException.class, () -> ClassificationType.Pflicht.format(description));
    }

    @ParameterizedTest
    @CsvSource(value = { "P1;P1", "p2;P2", "p10;P10", "\tp9 (3/4 Rück,Cody,Salto c);P9 (3/4 Rück,Cody,Salto c) ",
	    "m5;M5", "M10;M10", "W13;W13" }, delimiter = ';')
    void testCorrectKuerDescriptions(String description, String expected) {
	Assertions.assertEquals(expected, ClassificationType.Pflicht.format(description));
    }

    private static Stream<Arguments> provideIllegalArguments() {
	return Stream.of(
		Arguments.of((String) null),
		Arguments.of(""),
		Arguments.of(" "),
		Arguments.of("X6"),
		Arguments.of("O5"),
		Arguments.of("()4§"));
    }
}
