package Grafo;

/**
 *
 * @author Luis Felipe Velasco Tao
 */
public class Grafo {

    private int matrizCoeficiente[][] = new int[20][20]; //Matriz que almacenara los pesos de las aristas entre dos nodos
    private int matrizAdyacencia[][] = new int[20][20]; // Matriz que almacenara si dos nodos se encuentran conectados o no
    private int coornenadaX[] = new int[20]; // Esta coordenada en X ayudara a ubicar el nodo en el grafo (y al momento de graficarlo)
    private int coordenadaY[] = new int[20]; //Esta coordenada en Y ayudara a ubicar el nodo en el grafo (y al momento de graficarlo)
    private int idNodo[] = new int[20]; // Arreglo en el que se almacenara el nombre del nodo(numeros del 0 al 11)
    private int enGrafo[]; // Constructor del grafo

    public Grafo() {

    }
     
    // Getters y setters del arbol, de aqui se sacaran los datos para realizar los recorridos entre aristas y las matrizes correspondientes
    
    //En esta matriz se almacenaran los pesos de las aristas entre los nodos
    public int getMatrizCoeficiente(int i, int j) {
        return matrizCoeficiente[i][j];
    }
    //En esta matriz se almacenara las conexiones entre los nodos.
    public int getMatrizAdyacencia(int i, int j) {
        return matrizAdyacencia[i][j];
    }
    //Ubicación de un nodo en el grafo en el eje X
    public int getCoordenadaX(int i) {
        return coornenadaX[i];
    }
    //Ubicación de un nodo en el grafo en el eje Y
    public int getCoordenadaY(int i) {
        return coordenadaY[i];
    }
    //Identificador o nombre de cada nodo (valores desde 0 a 11)
    public int getNombre(int i) {
        return idNodo[i];
    }
    // Posicion de un nodo en el grafo
    public int getEnGrafo(int i) {
        return enGrafo[i];
    }

    public void setMatrizCoeficiente(int i, int j, int mc) {
        this.matrizCoeficiente[i][j] = mc;
    }

    public void setMatrizAdyacencia(int i, int j, int ma) {
        this.matrizAdyacencia[i][j] = ma;
    }

    public void setCoordenadaX(int i, int coordenadaX) {
        this.coornenadaX[i] = coordenadaX;
    }

    public void setCoordenadaY(int i, int coordenadaY) {
        this.coordenadaY[i] = coordenadaY;
    }

    public void setNombre(int i, int nombre) {
        this.idNodo[i] = nombre;
    }

    public void setEnGrafo(int i, int posicionGrafo) {
        this.enGrafo[i] = posicionGrafo;
    }
    //Constructor del grafo (nodo - identificador)
    public void crearArbol(int i) {
        enGrafo = new int[i];
    }
    
}
