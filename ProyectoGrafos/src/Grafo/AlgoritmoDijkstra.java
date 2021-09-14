package Grafo;

import static Ventanas.VentanaPrincipal.jPanel1; // Panel en el que se dibuja el grafo
import static Ventanas.VentanaPrincipal.actualizarGrafo; // Metodo grafico / visual el cual redibujara el grafo (nodos y aristas)
//import static Ventanas.VentanaPrincipal.ingresarNodo;
import java.awt.Color; // Atributo extraido de la libreria para poder representar graficamente en elpanel el recorrido entre dos nodos
import javax.swing.JOptionPane;// Panel alterno por el cual 

/**
 *
 * @author Luis Felipe Velasco Tao
 */
public class AlgoritmoDijkstra {

    private Grafo grafo; //Grafo en el que se esta trabajando
    private int topeInterno; // Este tope lo usaremos para realizar las iteraciones por todos los caminos posibles en el grafo
    private Nodo auxiliar = null; // Sera el nodo que nos ayudara a recorrer el grafo
    private int acumuladoAux; // es un acumulado auxiliar
    private int AcumuladoInterno; // Aqui se va sumando el valor de las aristas entre los nodos
    private Nodo nodo[]; // Vector que tendra el tamaño de los nodos creados (tope) 
    private int tope; // Cantidad de nodos existentes
    private int permanente; // Nodo seleccionado como inicial
    private int nodoFin; // Nodo destino

    /**
//     * onstructor del algortimo de Dijkstra
     * @param grafo = Grafo en el que se esta trabajando
     * @param tope = cantidad de nodos existentes en el grafo
     * @param permanente = nodo seleccionado como inicial
     * @param nodoFin  = nodo seleccionado como destino
     */
    public AlgoritmoDijkstra(Grafo grafo, int tope, int permanente, int nodoFin) {
        this.grafo = grafo;
        this.tope = tope;
        this.nodo = new Nodo[tope];
        this.permanente = permanente;
        this.nodoFin = nodoFin;
    }
    /**
     * 
     * @return Acumulado de los pesos en el nodo final 
     */
    public int getAcumulado() {
        return nodo[nodoFin].getAcumulado();
    }

    public void aDijkstra() {
        // Creamos el vector nodo del tamaño de tope el cual tiene el numero de nodo graficados 
        for (int i = 0; i < tope; i++) {
            nodo[i] = new Nodo(); // Se crea los nodos que serviran para ser recorrdios
        }
        //Se compara si el usuario selcciondo el missmo nodo como destino (comparación de lo obtenido por interfaz por medio de las acciones del mouse)
        if (permanente != nodoFin) {
            jPanel1.paint(jPanel1.getGraphics());// Se obtiene los elementos del grafo
            actualizarGrafo(tope, grafo);// Se actualiza el grafo para realizar cambios
            Graficar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCoordenadaX(permanente), grafo.getCoordenadaY(permanente), null, Color.GREEN);//Se cambia el color del nodo para indicar que sera el inicio del camino a trazae
            nodo[permanente].setVisitado(true);//  Se marca el nodo de inicio como visitado (es decir que en los ciclos para recorrer el grafo no sera tomado en cuenta))
            nodo[permanente].setValor(permanente); // En el arreglo por el cual se realizaran los recorridos se le da valor a la posicion con el nodo seleccionado
            // Se entra aun ciclo DO - WHILE el cual solo terminara hasta temrinar todas las iteraciones posibles que existan para llegar al nodo destino
            do {
                AcumuladoInterno = 0; // Se 
                acumuladoAux = 331; // Peso maximo de una arista = 30 y numero maximo de aristas entre nodo inicio y fin = 11 = 330
                nodo[permanente].setSeleccionado(true); // Se marca el nodo inicial
                // Bucle for el cual recorrera todos los nodos existentes, por lo tal se usa al tope (= n nodos existentes) como limite
                for (int j = 0; j < tope; j++) {
                    // Se reviza por medio de un condicional si el nodo inicial esta conectado con el nodo destino
                    if (grafo.getMatrizAdyacencia(j, permanente) == 1) {
                        AcumuladoInterno = nodo[permanente].getAcumulado() + grafo.getMatrizCoeficiente(j, permanente); // Se suma el peso de la arista obtenida entre dos grafos
                        /**
                         * Se compara si:
                         * - El acumulado del recorrido es menor al que este en el nodo de la posicion J
                         * - El nodo en la posicion J fue visitado 
                         * - El nodo en la posicion J no es el que ha sido seleccionado por el usado
                         * Si estas tres condiciones se cumplen:
                         * - Se le dara el valor del acumulado interno al nodo
                         * - Se marcara como visitado (eso evitara que sea usado en otra itetación)
                         * - Se le asigna el valor que posea J en la iteración al nodo
                         * - Se le asignara como su predecesor al nodo inicial
                         */
                        if (AcumuladoInterno <= nodo[j].getAcumulado() && nodo[j].isVisitado() == true && nodo[j].isSeleccionado() == false) {
                            nodo[j].setAcumulado(AcumuladoInterno);
                            nodo[j].setValor(j);
                            nodo[j].setPredecesor(nodo[permanente]);
                            /**
                             * Si por otro lado el nodo no ha sido visitado, igulamente se asegura que se realice igualmente lo realizado anteriormente 
                             */
                        } else if (nodo[j].isVisitado() == false) {
                            nodo[j].setAcumulado(AcumuladoInterno);
                            nodo[j].setVisitado(true);
                            nodo[j].setValor(j);
                            nodo[j].setPredecesor(nodo[permanente]);
                        }
                    }
                }
                for (int i = 0; i < tope; i++) { // Buscamos cual de los nodos visitado tiene el acomulado menor para escogerlo como permanente 
                    if (nodo[i].isVisitado() == true && nodo[i].isSeleccionado() == false) {
                        if (nodo[i].getAcumulado() <= acumuladoAux) { // Se compara cada uno de los acumulados con el demarcado como auxiliar
                            permanente = nodo[i].getValor();  // Al nodo permanente se le da el valor del nodo en iteración
                            acumuladoAux = nodo[i].getAcumulado(); // Al acumulado auxiliar el cual definimos anteriormente
                        }
                    }
                }
                topeInterno++; // Se aumenta la iteración del bucle Do - While 
            } while (topeInterno < tope + 1); // Se realiza la comparación de si el Tope interno ya ha llegado al limnite del tope total del grafo
            auxiliar = nodo[nodoFin]; // Se almacena el nodo obtenido al final del arreglo en donde alacenamos los nodos
            // Se realiza lacomparación de si este nodo tiene algun enlace creado (comprueba si hay alguna arista que posibilitellegar a él)
            if (auxiliar.getPredecesor() == null) {
                JOptionPane.showMessageDialog(null, "Nodos sin conexion entre si"); // Si esta condición es verdad, se muestra un mensaje en patalla 
            }
            // En este ciclo se pintaran las aristas y los nodos que son la ruta mas optima obtenida y almacenada en el arreglo Auxiliar
            while (auxiliar.getPredecesor() != null) {
                Graficar.dibujarArista(jPanel1.getGraphics(), grafo.getCoordenadaX(auxiliar.getValor()), grafo.getCoordenadaY(auxiliar.getValor()),
                        grafo.getCoordenadaX(auxiliar.getPredecesor().getValor()), grafo.getCoordenadaY(auxiliar.getPredecesor().getValor()), Color.GREEN);
                Graficar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCoordenadaX(auxiliar.getValor()), grafo.getCoordenadaY(auxiliar.getValor()), null, Color.GREEN);
                auxiliar = auxiliar.getPredecesor();
            }
            Graficar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCoordenadaX(nodoFin), grafo.getCoordenadaY(nodoFin), null, Color.GREEN);// Se pinta el nodo auxiliar (nodo destino)
        } else {
            Graficar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCoordenadaX(nodoFin), grafo.getCoordenadaY(nodoFin), null, Color.GREEN); // Se pinta el nodo auxiliar (nodo destino)
        }
    }
}
