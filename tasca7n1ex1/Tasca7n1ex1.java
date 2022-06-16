package tasca7n1ex1;

public class Tasca7n1ex1 {

	@SuppressWarnings("deprecation") // anotació per evitar els warnigs del IDE per metode obsolet
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreballadorOnline treballador = new TreballadorOnline("alex", "montero", 15);
		TreballadorPresencial treballador2 = new TreballadorPresencial("alex", "montero", 15, 10);

//exercici2
		treballador.metodeObsolet();
		treballador2.metodeObsolet();
	}

}
