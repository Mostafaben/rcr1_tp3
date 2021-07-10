import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.picking.PickedInfo;
import edu.uci.ics.jung.visualization.picking.PickedState;
import edu.uci.ics.jung.visualization.renderers.DefaultVertexLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Graph<String, String> graph = null;
		Vector<String> nodes = new Vector<String>();
		Vector<String> arcs = new Vector<String>();
		Vector<Vector<Integer>> matrix = new Vector<Vector<Integer>>();
		HashMap data = new HashMap();
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		try {
			InputStream inputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(inputStreamReader);
			String Line;
			nodes = new Vector();
			while ((Line = br.readLine()) != null && !Line.startsWith("#")) {
				nodes.add(Line);
				System.out.println(Line);
			}
			if (Line != null) {
				while ((Line = br.readLine()) != null && !Line.startsWith("#")) {
					arcs.add(Line);
					System.out.println(Line);
				}
			}
			if (Line != null) {
				matrix = new Vector<Vector<Integer>>();
				Vector<Integer> NL = new Vector<Integer>();
				while ((Line = br.readLine()) != null && (Line.trim().length() != 0)) {
					String[] NodeLinks = Line.split(";");
					for (int i = 0; i < NodeLinks.length; i++) {
						NL.add(Integer.valueOf(NodeLinks[i].trim()));
					}
					matrix.add(NL);

				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		propagationMarquages r = new propagationMarquages();
		graph = new DirectedSparseGraph<String, String>();
		GraphManager.createGraph(matrix, nodes, arcs, graph);
		boolean checkInput = false;
		String nbSol = null;
		String nbButs = null;
		while (checkInput == false) {
			System.out.println("searching for one node or two");
			nbButs = scanner.nextLine();
			if (nbButs.equals("1") || nbButs.equals("2")) {
				checkInput = true;
			} else
				System.out.println("Invalid DATA, try again\n");
		}
		checkInput = false;
		while (checkInput == false) {
			System.out.println("press 1 for one solution and 2 for all solutions");
			nbSol = scanner.nextLine();
			if (nbSol.equals("1") || nbSol.equals("2")) {
				checkInput = true;
			} else
				System.out.println("Invalid DATA, try again\n");
		}
		if (nbButs.equals("1")) {
			Vector<Solution> solution = new Vector<Solution>();
			System.out.println("starting node : ");
			String startingNode = scanner.nextLine();
			System.out.println("goal node : ");
			String endingNode = scanner.nextLine();
			System.out.println("Relation : ");
			String relationName = scanner.nextLine();
			if (nbSol.equals("1")) {
				solution = r.propagationRep1(matrix, nodes, arcs, startingNode, endingNode, relationName);
			} else if (nbSol.equals("2")) {
				solution = r.propagationRepN(matrix, nodes, arcs, startingNode, endingNode, relationName);
			}
			if (!solution.isEmpty())
				System.out.println("Solution is: " + solution);
			else
				System.out.println("No solution found.");
		} else if (nbButs.equals("2")) {
			Vector<Solution> solRelation1 = new Vector<Solution>();
			Vector<Solution> solRelation2 = new Vector<Solution>();
			System.out.println("Starting Node: ");
			String startingNode = scanner.nextLine();
			System.out.println("Goal Node1: ");
			String goalNode1 = scanner.nextLine();
			System.out.println("Goal Node2: ");
			String goalNode2 = scanner.nextLine();
			System.out.println("Relation : ");
			String relationName = scanner.nextLine();
			if (nbSol.equals("2")) {
				solRelation1 = r.propagationRepN(matrix, nodes, arcs, startingNode, goalNode1, relationName);
				solRelation2 = r.propagationRepN(matrix, nodes, arcs, startingNode, goalNode2, relationName);
			} else if (nbSol.equals("1")) {
				solRelation1 = r.propagationRep1(matrix, nodes, arcs, startingNode, goalNode1, relationName);
				solRelation2 = r.propagationRep1(matrix, nodes, arcs, startingNode, goalNode2, relationName);
			}
			if (!solRelation1.isEmpty())
				System.out.println("Solution for relation 1 is: " + solRelation1);
			else
				System.out.println("No solution found for relation 1.");
			if (!solRelation2.isEmpty())
				System.out.println("Solution for relation 1 is: " + solRelation2);
			else
				System.out.println("No solution found for relation 2.");
		}
	}
}
