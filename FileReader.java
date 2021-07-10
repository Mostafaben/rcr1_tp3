import java.io.*;
import java.util.*;

public class FileReader {

    public static HashMap readFile(String path) {

        HashMap data = new HashMap();
        Vector<String> arcs = new Vector<String>();
        Vector<Vector<Integer>> matrix = new Vector<Vector<Integer>>();
        Vector<String> nodes = new Vector<String>();
        String FichierNR = path;

        try {
            InputStream ips = new FileInputStream(FichierNR);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            nodes = new Vector();
            while ((ligne = br.readLine()) != null && !ligne.startsWith("#")) {
                nodes.add(ligne);
                System.out.println(ligne);
            }

            if (ligne != null) {
                while ((ligne = br.readLine()) != null && !ligne.startsWith("#")) {
                    arcs.add(ligne);
                    System.out.println(ligne);
                }
            }

            if (ligne != null) {
                matrix = new Vector<Vector<Integer>>();
                Vector<Integer> NL = new Vector<Integer>();
                while ((ligne = br.readLine()) != null && (ligne.trim().length() != 0)) {
                    String[] LiensNoeud = ligne.split(";");
                    NL = new Vector<Integer>();
                    for (int i = 0; i < LiensNoeud.length; i++) {
                        NL.add(Integer.valueOf(LiensNoeud[i].trim()));
                    }
                    matrix.add(NL);
                }
            }
            br.close();
            data.put("nodes", nodes);
            data.put("arcs", arcs);
            data.put("matrix", matrix);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return data;
    }
}
