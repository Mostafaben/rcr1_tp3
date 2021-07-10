import java.util.Vector;

public class propagationMarquages {
	public Vector<Solution> propagationRep1(Vector<Vector<Integer>> matrix, Vector<String> nodes, Vector<String> arcs,
			String startingNode, String GoalNode, String relationName) {
		System.out.println("propagation of markings: \n");
		int i = 0;
		int j;
		int p;
		Vector<Noeud> M1 = new Vector<Noeud>();
		Vector<Noeud> M2 = new Vector<Noeud>();
		Vector<Solution> solution = new Vector<Solution>();
		M1.add(new Noeud(startingNode, 0));
		M2.add(new Noeud(GoalNode, 0));
		while (i < M1.size()) {
			p = nodes.indexOf(M1.get(i).getNom());
			j = 0;
			while (j < matrix.size()) {
				if (p == arcs.indexOf(relationName) + 1)
					break;
				if (matrix.get(j).get(p) == 1)
					M1.add(new Noeud(nodes.get(j), M1.get(i).getEtape() + 1));
				j++;
			}
			i++;
		}
		i = 0;
		while (i < M2.size()) {
			p = nodes.indexOf(M2.get(i).getNom());
			j = 0;
			if (p == arcs.indexOf(relationName) + 1)
				break;
			while (j < matrix.size()) {
				if (matrix.get(j).get(p) == 1)
					M2.add(new Noeud(nodes.get(j), M2.get(i).getEtape() + 1));
				j++;
			}
			i++;
		}
		p = arcs.indexOf(relationName) + 1;
		i = M1.size() - 1;
		int tailleM2 = M2.size() - 1;

		while (i > -1) {

			j = tailleM2;
			while (j > -1) {

				if (matrix.get(nodes.indexOf(M1.get(i).getNom())).get(nodes.indexOf(M2.get(j).getNom())) == p)
					if (matrix.get(nodes.indexOf(M1.get(i).getNom())).get(nodes.indexOf(M1.get(0).getNom())) != 0) {
						solution.add(new Solution(M1.get(i).getNom(), M2.get(j).getNom()));

					} else {
						System.out.println("\n\nAucune solution : Exception\n\n");
					}

				if (matrix.get(nodes.indexOf(M2.get(j).getNom())).get(nodes.indexOf(M1.get(i).getNom())) == p)
					if (matrix.get(nodes.indexOf(M1.get(i).getNom())).get(nodes.indexOf(M1.get(0).getNom())) != 0) {
						solution.add(new Solution(M2.get(j).getNom(), M1.get(i).getNom()));
					} else {
						System.out.println("\n\nAucune solution: Exception\n\n");
					}
				j--;
			}
			i--;
		}

		return solution;
	}

	public Vector<Solution> propagationRepN(Vector<Vector<Integer>> matrice, Vector<String> noeuds, Vector<String> arcs,
			String noeudDepart, String noeudBut, String nomRelation) {
		System.out.println("propagation des marquages: \n");
		int i = 0;
		int j = 0;
		int p;
		Vector<Noeud> M1 = new Vector<Noeud>();
		Vector<Noeud> M2 = new Vector<Noeud>();
		Vector<Solution> solution = new Vector<Solution>();
		M1.add(new Noeud(noeudDepart, 0));
		M2.add(new Noeud(noeudBut, 0));
		while (i < M1.size()) {
			p = noeuds.indexOf(M1.get(i).getNom());
			j = 0;
			while (j < matrice.size()) {
				if (matrice.get(j).get(p) == 1)
					M1.add(new Noeud(noeuds.get(j), M1.get(i).getEtape() + 1));

				j++;
			}
			i++;
		}
		i = 0;
		while (i < M2.size()) {
			p = noeuds.indexOf(M2.get(i).getNom());
			j = 0;
			while (j < matrice.size()) {
				if (matrice.get(j).get(p) == 1)
					M2.add(new Noeud(noeuds.get(j), M2.get(i).getEtape() + 1));
				j++;
			}
			i++;
		}
		p = arcs.indexOf(nomRelation) + 1;
		i = M1.size() - 1;
		int tailleM2 = M2.size() - 1;
		while (i > -1) {

			j = tailleM2;
			while (j > -1) {
				if (matrice.get(noeuds.indexOf(M1.get(i).getNom())).get(noeuds.indexOf(M2.get(j).getNom())) == p)

					if (matrice.get(noeuds.indexOf(M1.get(i).getNom())).get(noeuds.indexOf(M1.get(0).getNom())) != 0) {
						solution.add(new Solution(M1.get(i).getNom(), M2.get(j).getNom()));

					} else {
						System.out.println("\n\nAucune solution : Exception\n\n");
					}
				if (matrice.get(noeuds.indexOf(M2.get(j).getNom())).get(noeuds.indexOf(M1.get(i).getNom())) == p)
					if (matrice.get(noeuds.indexOf(M1.get(i).getNom())).get(noeuds.indexOf(M1.get(0).getNom())) != 0) {
						solution.add(new Solution(M2.get(j).getNom(), M1.get(i).getNom()));
					} else {
						System.out.println("\n\nAucune solution: Exception\n\n");
					}
				j--;
			}
			i--;
		}
		return solution;
	}

}
