package tasca7n1ex1;

public class TreballadorOnline extends Treballador {
	final static float TARIFA_INTERNET = 100;

	public TreballadorOnline(String nom, String cognom, float preuHora) {
		super(nom, cognom, preuHora);
		// TODO Auto-generated constructor stub
	}

	public float getTARIFA_INTERNET() {
		return TARIFA_INTERNET;
	}

	@Override
	public float calcularSou(float horesTreballades) {
		return horesTreballades * this.getPreuHora() + TARIFA_INTERNET;
	}

	@Deprecated // indica que un metode esta obsolet, suposo que es posa en codi d'alguna versió
				// anterior que es vol conservar, per si de cas.
	public void metodeObsolet() {
		System.out.println("Metode obsolet executat");
	}
}