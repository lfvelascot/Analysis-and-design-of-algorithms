
package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Luis Felipe Velasco ;
 */
public class Diskjtra {
    static Scanner s = new Scanner(System.in);
    static ArrayList<String> joyas = new ArrayList<String>();

    public static void main(String[] args) {
        String joya = s.next();
        while (joya.contains("(") || joya.contains(")")) {
            addJoya(joya);
            joya = s.next();
        }
        System.out.println(joyas.size());
    }

    private static void addJoya(String joya) {
        if (!existsJoya(joya)) {
            joyas.add(joya);
        }
    }

    private static boolean existsJoya(String joya) {
        for (int i = 0; i < joyas.size(); i++) {
            if (joya.equals(joyas.get(i))) {
                return true;
            }
        }
        return false;
    }

}

