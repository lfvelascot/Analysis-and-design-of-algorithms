
package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class LuDiOh {
    static Scanner s = new Scanner(System.in);
    static int[][] deckMarcos;
    static int[][] deckLeo;

    public static void main(String[] args) {
        int atributes = s.nextInt();
        deckMarcos = new int[s.nextInt()][atributes];
        deckLeo = new int[s.nextInt()][atributes];
        llenarDeck(deckMarcos);
        llenarDeck(deckLeo);
        System.out.println(ganador(s.nextInt()-1,s.nextInt()-1,s.nextInt()-1));
    }

    private static void llenarDeck(int[][] deck) {
        for (int[] deck1 : deck) {
            for (int j = 0; j < deck[0].length; j++) {
                deck1[j] = s.nextInt();
            }
        }
    }

    private static String ganador(int cartaMarco, int cartaLeo, int atributo) {
        if (deckMarcos[(cartaMarco)][(atributo)] > deckLeo[(cartaLeo)][(atributo)]){
            return"Marcos";
        } else if (deckMarcos[(cartaMarco)][(atributo)] < deckLeo[(cartaLeo)][(atributo)]){
            return"Leonardo";
        }else {
            return"Empate";
        }
    }
}

