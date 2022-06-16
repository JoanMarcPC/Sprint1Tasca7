package tasca7n1ex1;

public class TreballadorPresencial extends Treballador {
	private float preuKilometre;

	public TreballadorPresencial(String nom, String cognom, float preuHora, float preuKilometre) {
		super(nom, cognom, preuHora);
		this.preuKilometre = preuKilometre;
	}

	public float getPreuKilometre() {
		return preuKilometre;
	}

	public void setPreuKilometre(float preuKilometre) {
		this.preuKilometre = preuKilometre;
	}

//No anoto override pq es tracta d'una sobrecarrega de constructors i no d'un Override
	public float calcularSou(float horesTreballades, float kmRecorreguts) {
		return horesTreballades * this.getPreuHora() + kmRecorreguts * preuKilometre;

	}

	@Deprecated
	public void metodeObsolet() {
		System.out.println("Metode obsolet executat");
	}
}
