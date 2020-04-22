package usb;

import java.util.Scanner;


public class PassWord {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Para probar los seis casos en el problema
        int i = 6;
        while (i != 0) {
            System.out.println(validarContraseña(s.nextLine()));
            i--;
        }
    }

    private static String validarContraseña(String contrasena) {
        System.out.println("c = " + contrasena);
        if (contrasena.length() >= 6 && contrasena.length() <= 32 && validarLetras(contrasena) && validarNum(contrasena) && validarLetrasMayus(contrasena)) {
            for (int i = 0; i < contrasena.length(); i++) {
                String caracter = String.valueOf(contrasena.charAt(i));
                if (caracter(caracter, ",.¿?!¡':;'@-_%", 0, 0) || caracter.equals(" ")) {
                    return "Senha invalida.";
                }
            }
            return "Senha valida.";
        } else {
            return "Senha invalida.";
        }
    }
    
            

    private static boolean caracter(String letra, String sign, int i, int exts) {
        if (String.valueOf(sign.charAt(i)).equals(letra)) {
            return true;
        } else if (i == exts && !String.valueOf(sign.charAt(i)).equals(letra)) {
            return false;
        } else if (i == exts && String.valueOf(sign.charAt(i)).equals(letra)) {
            return true;
        } else {
            return caracter(letra, sign, i + 1, exts);
        }
    }

    public static boolean validarNum(String contrasena) {
        for (int i = 0;i < contrasena.length();i++){
            String caracter = String.valueOf(contrasena.charAt(i));
            if (caracter(caracter, "0123456789", 0, 9)){
                return true;
            }
        }
        return false;
    }

    public static boolean validarLetras(String contrasena) {
        for (int i = 0; i < contrasena.length(); i++) {
            String caracter = String.valueOf(contrasena.charAt(i));
            if (caracter(caracter, "abcdefghijklmopqrstuvwxyz", 0, 24)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean validarLetrasMayus(String contrasena) {
        for (int i = 0; i < contrasena.length(); i++) {
            String caracter = String.valueOf(contrasena.charAt(i));
            if (caracter(caracter, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, 24)) {
                return true;
            }
        }
        return false;
    }
}
