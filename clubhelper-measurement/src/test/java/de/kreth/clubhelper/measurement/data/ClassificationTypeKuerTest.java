package de.kreth.clubhelper.measurement.data;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ClassificationTypeKuerTest {

    @ParameterizedTest
    @MethodSource("provideIllegalArguments")
    void testIllegalKuerDescriptions(String description) {
	Assertions.assertThrows(IllegalStateException.class, () -> ClassificationType.Kuer.format(description));
    }

    @ParameterizedTest
    @CsvSource({ "abc", "a1465", "34t4", "\ttext ", "a(4§)" })
    void testCorrectKuerDescriptions(String description) {
	Assertions.assertEquals(description.strip(), ClassificationType.Kuer.format(description));
    }

    private static Stream<Arguments> provideIllegalArguments() {
	return Stream.of(
		Arguments.of((String) null),
		Arguments.of(""),
		Arguments.of(" "),
		Arguments.of("1634"),
		Arguments.of("ab"),
		Arguments.of("()4§"));
    }
}
