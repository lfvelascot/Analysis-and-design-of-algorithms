package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author COMPURED
 */
public class SundayMorning {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Atraso maximo: " + sundayMonday(s.next()));
    }

    private static int sundayMonday(String hm) {
        String[] hora = hm.split(":");
        int hh = (((Integer.parseInt(hora[0]) + 1) * 60) + (Integer.parseInt(hora[1]))) - 480;
        if (hh < 0) {
            return 0;
        } else {
            return hh;
        }
    }
}

