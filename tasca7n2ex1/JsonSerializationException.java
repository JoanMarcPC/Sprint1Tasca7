package tasca7n2ex1;

public class JsonSerializationException extends Exception {

	private static final long serialVersionUID = -1205383763291301031L; // (autogenerat) això o supresswarning serial,
																		// pq Exception implementa serializable

	public JsonSerializationException(String message) {
		super(message);
	}
}
