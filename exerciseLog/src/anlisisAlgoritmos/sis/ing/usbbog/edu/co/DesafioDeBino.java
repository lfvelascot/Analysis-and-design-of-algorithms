
package anlisisAlgoritmos.sis.ing.usbbog.edu.co;

import java.util.Scanner;

/**
 * @author Luis Felipe Velasco
 */
public class DesafioDeBino {
    static Scanner s = new Scanner(System.in);
    static int m2 = 0, m3 = 0, m4 = 0, m5 = 0;

    public static void main(String[] args) {
        desafioDeBino(s.nextInt());
    }
    private static void desafioDeBino(int cases) {
        
        for (int i = 0; i < cases; i++) {
            multiplos(s.nextInt());
        }
        System.out.println(m2 + " Multiplo(s) de 2\n"
                + m3 + " Multiplo(s) de 3\n"
                + m4 + " Multiplo(s) de 4\n"
                + m5 + " Multiplo(s) de 5");
    }
    
    private static void multiplos(int n) {
        if (n % 2 == 0) {
            if (n%3 == 0){
                if (n%4 == 0){
                    if (n%5 == 0){
                        m2++;m3++;m4++;m5++;
                    } else{
                        m2++;m3++;m4++;
                    }
                } else if (n%5 == 0){
                    m2++;m3++;m5++;
                } else{
                    m2++;m3++;
                }
            } else if(n%4==0){
                if(n%5==0){
                   m2++;m4++;m5++; 
                } else {
                    m2++;m4++;
                }
            } else if (n%5==0){
                m2++;m5++;
            } else {
                m2++;
            }
        } else if(n%3==0){
            if (n%4==0){
                if ((n%5==0)){
                    m3++;m4++;m5++; 
                } else{
                    m3++;m4++;
                }
            } else if((n%5==0)){
                m3++;m5++;
            } else{
                m3++;
            }
        } else if(n%4 == 0){
            if(n%5 == 0){
                m4++;m5++;
            }else {
                m4++;
            }
 
        } else if(n%5 == 0){
            m5++;
        }
    }
} 

