package tasca7n2ex1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJson {
	public String convertToJson(Object object) throws JsonSerializationException {
		try {

			checkIfSerializable(object);
			initializeObject(object);
			return getJsonString(object);

		} catch (Exception e) {
			throw new JsonSerializationException(e.getMessage());
		}
	}

	private void checkIfSerializable(Object object) throws JsonSerializationException {
		if (Objects.isNull(object)) {
			throw new JsonSerializationException("Can't serialize a null object");
		}

		Class<?> clazz = object.getClass(); // el ? siginifica que no sabem el tipus que pot rebre
		if (!clazz.isAnnotationPresent(JsonSerializable.class)) { // si no té l'anotacio
			throw new JsonSerializationException(
					"The class " + clazz.getSimpleName() + " is not annotated with JsonSerializable");
		}
	}

	private void initializeObject(Object object)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = object.getClass();
		for (Method method : clazz.getDeclaredMethods()) { // recorrer els metodes que conté una classe
			if (method.isAnnotationPresent(Init.class)) { // si conté anotació x
				method.setAccessible(true); // el fem accessible
				method.invoke(object);// l'invoquem
			}
		}
	}

	private String getJsonString(Object object) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		Map<String, String> jsonElementsMap = new HashMap<>();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(JsonElement.class)) {
				jsonElementsMap.put(getKey(field), (String) field.get(object));
			}
		}

		String jsonString = jsonElementsMap.entrySet().stream()
				.map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
				.collect(Collectors.joining(","));
		return "{" + jsonString + "}"; // els json tenen aquesta estructura
	}

	private String getKey(Field field) {
		String value = field.getAnnotation(JsonElement.class).key();
		return value.isEmpty() ? field.getName() : value;
	}

	protected String getPath(Object object) {
		Class<?> clazz = object.getClass();

		return clazz.getAnnotation(JsonSerializable.class).ruta();
	}
}
