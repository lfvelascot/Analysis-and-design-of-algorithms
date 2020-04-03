package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

/**
 * @author Luis Felipe Velasco
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Promedio3 {

    static Scanner s = new Scanner(System.in);
    
    private static void notas(double n1, double n2, double n3, double n4) {
        double media = ((n1 * 2) + (n2 * 3) + (n3 * 4) + (n4 * 1)) / 10;
        System.out.println("Media: " + impresion(media));
        if (media >= 7.0) {
            System.out.println("Aluno aprovado.");
        } else if (media >= 5.0 && media <= 6.9) {
            System.out.println("Aluno em exame.");
            examen(s.nextDouble(), media);
        } else {
            System.out.println("Aluno reprovado.");
        }
    }

    private static void examen(double examen, double media) {
        System.out.println("Nota do examen: " + impresion(examen));
        if (((media + examen) / 2) >= 5.0) {
            System.out.println("Aluno aprovado.");
        } else {
            System.out.println("Aluno reprovado.");
        }
        System.out.println("Media final: " + impresion((media + examen)/2));
    }

    private static String impresion(double num) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        String format = decimalFormat.format(num);
        return format;
    }

    public static void main(String[] args) {
        notas(s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextDouble());
    }
}
