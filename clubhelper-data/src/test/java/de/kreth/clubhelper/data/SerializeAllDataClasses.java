package de.kreth.clubhelper.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeAllDataClasses {

    private ObjectMapper mapper;

    @BeforeEach
    void initMapper() {
	mapper = new ObjectMapper();
    }

    @MethodSource("classList")
    @ParameterizedTest
    void testLoadInstance(Class<?> dataClass) throws ReflectiveOperationException, IllegalArgumentException,
	    SecurityException, IOException {
	assertNotNull(dataClass);
	Object instance = dataClass.getConstructor().newInstance();
	StringWriter w = new StringWriter();
	mapper.writeValue(w, instance);
    }

    static Stream<Arguments> classList() {
	Reflections reflections = new Reflections(new ConfigurationBuilder()
		.forPackages("de.kreth.clubhelper.data")
		.addScanners(new SubTypesScanner(true)));

	Set<Class<? extends Serializable>> classes = reflections.getSubTypesOf(Serializable.class);

	return classes.stream()
		.filter(c -> !Modifier.isAbstract(c.getModifiers()))
		.filter(c -> !c.isEnum())
		.filter(c -> !c.isMemberClass())
		.map(Arguments::of);
    }
}
