package Grafo;

/**
 *
 * @author Luis Felipe Velasco Tao
 */
public class Nodo {

    private int valor; // Identificador del nod, inicia en -1 y al crear el primer nodo este sera 0.
    private boolean visitado; // Se usa para definir si un nodo fue visitado en el recorrido de un nodo a otro
    private boolean seleccionado; //Identifica si un nodo ha sido elegido para definir su camino a otro
    private int acumulado; // En estavariable se va a guardar el valor de los pesos que se obienen en el recorrido de un nodo a otro
    private Nodo predecesor; // Sirve para definir el nodo que va antes de un nodo n

    public Nodo() {
        this.valor = -1; 
        this.visitado = false;
        this.seleccionado = false;
        this.predecesor = null;
        this.acumulado = 0;

    }
// Bloque de Getters y Seter de los atributos del nodo

    public int getValor() {
        return valor;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public Nodo getPredecesor() {
        return predecesor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public void setSeleccionado(boolean etiqueta) {
        this.seleccionado = etiqueta;
    }

    public void setAcumulado(int acomulado) {
        this.acumulado = acomulado;
    }

    public void setPredecesor(Nodo predecesor) {
        this.predecesor = predecesor;
    }

}
