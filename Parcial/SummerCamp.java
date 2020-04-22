package usb;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    static persona p = null;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n != 0) {
            ArrayList<persona> personas = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                persona p = new persona(s.next(), s.nextInt());
                personas.add(p);
            }
            while (personas.size() != 1) {
                personas = ganador(personas);
            }
            System.out.println("Vencedor(a): " + personas.get(0));
            personas.clear();
            n = s.nextInt();
        }
    }

    private static ArrayList<persona> ganador(ArrayList<persona> personas) {
        if (p != personas.get(0)) {
            p = personas.get(0);
            int token = p.getNum();
            if (token % 2 == 0) {
                System.out.println("PAR = " + token);
                if (token > personas.size()) {
                    int residuo = token % personas.size();
                    System.out.println("p = " + personas.get(residuo).toString());
                    personas.remove(residuo);
                } else {
                    System.out.println("p = " + personas.get(token).toString());
                    personas.remove(token);
                }
            } else {
                System.out.println("INPAR" + token);
                if (token > personas.size()) {
                    int residuo = token % personas.size();
                    System.out.println("re" + residuo);
                    int cont = 1;
                    for (int i = personas.size() - 1; i >= 0; i--) {
                        if (cont == residuo) {
                            System.out.println("p = " + personas.get(i).toString());
                            personas.remove(i);
                            break;
                        }
                        cont++;
                    }
                } else {
                    int cont = 1;
                    for (int i = personas.size() - 1; i >= 0; i--) {
                        if (cont == token) {
                            System.out.println("p = " + personas.get(i).toString());
                            personas.remove(i);
                            break;
                        }
                        cont++;
                    }
                }
            }
        } else {
            p = personas.get(1);
            int token = p.getNum();
            if (token % 2 == 0) {
                System.out.println("PAR = " + token);
                if (token > personas.size()) {
                    if (token % personas.size() == 0) {
                        personas.remove(1);
                    } else if (token % (personas.size() - 1) == 0) {
                        personas.remove(0);
                    } else {
                        int residuo = (token % (personas.size() - 1)) + 1;
                        for (int i = 1; i < personas.size(); i++) {
                            if (i == residuo) {
                                personas.remove(i);
                            }
                        }
                    }
                }
            } else {
                System.out.println("INPAR" + token);
                if (token > personas.size() - 1) {
                    if (token % personas.size() == 0) {
                        personas.remove(1);
                    } else if (token % (personas.size() - 1) == 0) {
                        personas.remove(0);
                    } else {
                        int residuo = (token % (personas.size() - 1)) + 1;
                        for (int i = 1; i < personas.size(); i++) {
                            if (i == residuo) {
                                personas.remove(i);
                            }
                        }
                    }
                }
            }
        }
        return personas;
    }

    public static class persona {

        String nombre;
        int num;

        public persona(String nombre, int num) {
            this.nombre = nombre;
            this.num = num;
        }

        public String getNombre() {
            return nombre;
        }

        public int getNum() {
            return num;
        }

        @Override
        public String toString() {
            return "persona{" + "nombre=" + nombre + ", num=" + num + '}';
        }
    }

}
