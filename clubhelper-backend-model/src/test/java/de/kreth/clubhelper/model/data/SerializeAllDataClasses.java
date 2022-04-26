package de.kreth.clubhelper.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.kreth.clubhelper.entity.BaseEntity;
import de.kreth.clubhelper.entity.EntityAccessor;

@JsonTest
public class SerializeAllDataClasses {

    @Autowired
    ObjectMapper mapper;

    @ParameterizedTest
    @MethodSource("classList")
    void testLoadInstance(Class<?> persistentClass, Class<?> dataClass)
	    throws ReflectiveOperationException, IllegalArgumentException,
	    SecurityException, IOException {
	Object instance = createObject(persistentClass);
	StringWriter persistentJson = new StringWriter();
	mapper.writeValue(persistentJson, instance);
	Object dataInstance = mapper.readValue(new StringReader(persistentJson.toString()), dataClass);
	StringWriter dataJson = new StringWriter();
	mapper.writeValue(dataJson, dataInstance);
	assertEquals(persistentJson.toString(), dataJson.toString());
    }

    private Object createObject(Class<?> persistentClass)
	    throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	Object instance = persistentClass.getConstructor().newInstance();
	if (instance instanceof EntityAccessor) {
	    EntityAccessor entity = (EntityAccessor) instance;
	    entity.setChanged(LocalDateTime.now());
	    entity.setCreated(LocalDateTime.now());
	    if (entity instanceof BaseEntity) {
		BaseEntity base = (BaseEntity) entity;
		base.setId(1L);
		base.setDeleted(LocalDateTime.now());
	    }
	}
	return instance;
    }

    static Stream<Arguments> classList() {
	Reflections reflections = new Reflections(new ConfigurationBuilder()
		.forPackages("de.kreth.clubhelper.entity")
		.addScanners(new SubTypesScanner(true)));

	Set<Class<? extends Serializable>> persistentClasses = reflections.getSubTypesOf(Serializable.class);

	reflections = new Reflections(new ConfigurationBuilder()
		.forPackages("de.kreth.clubhelper.data")
		.addScanners(new SubTypesScanner(true)));
	Set<Class<? extends Serializable>> dataClasses = reflections.getSubTypesOf(Serializable.class);

	return persistentClasses.stream()
		.filter(c -> !Modifier.isAbstract(c.getModifiers()))
		.filter(c -> !c.isEnum())
		.filter(c -> !c.isMemberClass())
		.map(c -> map(c, dataClasses));

    }

    static Arguments map(Class<? extends Serializable> persistentClass,
	    Set<Class<? extends Serializable>> dataClasses) {
	String className = persistentClass.getSimpleName();
	for (Class<? extends Serializable> data : dataClasses) {
	    if (className.equals(data.getSimpleName())) {
		return Arguments.of(persistentClass, data);
	    }
	}
	throw new IllegalStateException("No matching class found for " + persistentClass.getName());
    }

}
