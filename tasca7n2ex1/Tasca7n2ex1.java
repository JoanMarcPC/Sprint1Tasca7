package tasca7n2ex1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tasca7n2ex1 {
	public static void main(String[] args) {

		ObjectToJson o = new ObjectToJson();
		Persona p1 = new Persona("Manolo", "Martinez", "45", "Calle Balmes");
		String json = "";

		try {
			json = o.convertToJson(p1);

			write(o.getPath(p1), json, false); // agafo la ruta que ve de l'anotació

		} catch (JsonSerializationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public static void write(String directori, String aEscriure, boolean append) {
		BufferedWriter bf;
		try {
			bf = new BufferedWriter(new FileWriter(directori, append));
			bf.write(aEscriure);
			bf.close();
		} catch (IOException e) {
			System.out.println("Buffer problem (Write)");
		}
	}
}
