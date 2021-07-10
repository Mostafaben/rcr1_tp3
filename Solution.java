
public class Solution {
	private String noeud1;
	private String noeud2;

	public Solution(String noeud1, String noeud2) {
		this.noeud1 = noeud1;
		this.noeud2 = noeud2;
	}

	public String getNoeud2() {
		return noeud2;
	}

	public void setNoeud2(String noeud2) {
		this.noeud2 = noeud2;
	}

	public String getNoeud1() {
		return noeud1;
	}

	public void setNoeud1(String noeud1) {
		this.noeud1 = noeud1;
	}

	public String toString() {
		return noeud1 + " --->>> " + noeud2 + "\n";
	}

}
