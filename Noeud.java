
public class Noeud {

	private String Nom;
	private int Etape;

	public Noeud(String nom, int etape) {
		this.Nom = nom;
		this.Etape = etape;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public String toString() {
		return "Etape: " + Etape + "-- Noeud: " + Nom + "\n";
	}

	public int getEtape() {
		return Etape;
	}

	public void setEtape(int etape) {
		this.Etape = etape;
	}
}
