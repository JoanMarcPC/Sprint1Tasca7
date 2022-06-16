package tasca7n2ex1;

@JsonSerializable(ruta = ".//src//tasca7n2ex1//FitxerJson.json") // (ruta = "novaRuta") si no faig aix� agafar� la
																	// default de Jsonserializable
public class Persona {

	@JsonElement
	private String firstName;
	@JsonElement
	private String lastName;
	@JsonElement(key = "personAge") // canvio el "nom" de la variable que es guardara al Json
	private String age;

	private String address; // aquesta no s'afegeix al serializable Json pq no te anotaci� JElement

	public Persona(String firstName, String lastName, String age, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}

	@Init
	private void initNames() {
		this.firstName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
		this.lastName = this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
