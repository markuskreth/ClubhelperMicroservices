package de.kreth.clubhelper.measurement.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ClassificationTypeTest {

    @ParameterizedTest
    @MethodSource("provideSimpleNamingArguments")
    void testStreckspruengeNull(ClassificationType type, String input, String expected) {
	assertEquals(expected, type.format(input));
    }

    private static Stream<Arguments> provideSimpleNamingArguments() {

	byte[] array = new byte[7]; // length is bounded by 7
	new Random().nextBytes(array);
	String generatedString = new String(array, Charset.forName("UTF-8"));

	return Stream.of(
		Arguments.of(ClassificationType.Streckspruenge, null, "Strecksprünge"),
		Arguments.of(ClassificationType.Streckspruenge, "", "Strecksprünge"),
		Arguments.of(ClassificationType.Streckspruenge, " ", "Strecksprünge"),
		Arguments.of(ClassificationType.Streckspruenge, generatedString, "Strecksprünge"),

		Arguments.of(ClassificationType.Hocken, null, "Hocken"),
		Arguments.of(ClassificationType.Hocken, "", "Hocken"),
		Arguments.of(ClassificationType.Hocken, " ", "Hocken"),
		Arguments.of(ClassificationType.Hocken, generatedString, "Hocken"),

		Arguments.of(ClassificationType.Graetschen, null, "Grätschen"),
		Arguments.of(ClassificationType.Graetschen, "", "Grätschen"),
		Arguments.of(ClassificationType.Graetschen, " ", "Grätschen"),
		Arguments.of(ClassificationType.Graetschen, generatedString, "Grätschen"),

		Arguments.of(ClassificationType.Hechten, null, "Hechten"),
		Arguments.of(ClassificationType.Hechten, "", "Hechten"),
		Arguments.of(ClassificationType.Hechten, " ", "Hechten"),
		Arguments.of(ClassificationType.Hechten, generatedString, "Hechten"));
    }
}
