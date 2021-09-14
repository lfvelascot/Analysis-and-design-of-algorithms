package Grafo;
/**
 * Se importan los elementos de la libreria grafica AWT para las lineas, colores, 
 * fuentes, graficos de los nodos y ami,aciones del grafo
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Luis Felipe Velasco Tao
 */
public class Graficar {

    Color color;

    public Graficar() {

    }
    /**
     * Este metodo grafico se apoya en los elementos graficos de la libreria AWT
     * para dibujar el nodo en el lienzo, usando las coordenadas dadas por el usuario
     * y el nombre o identificador de este (autoincremental)
     * @param circulo = elemento grafico que nos ayuda a crear el nodo
     * @param x = coordenada X en el lienzo del nodo
     * @param y = coordenada Y en el lienzo del nodo
     * @param id = texto del nodo
     */
    public static void dibujarCirculo(Graphics circulo, int x, int y, String id) {
        ((Graphics2D) circulo).setColor(Color.red); // Color del nodo
        ((Graphics2D) circulo).setStroke(new BasicStroke(3));//Grosor del contorno del nodo   
        ((Graphics2D) circulo).fillOval(x, y, 15, 15);// Relleno del nodo
        ((Graphics2D) circulo).setColor(Color.BLACK); //Color del contorno del nodo
        ((Graphics2D) circulo).drawOval(x, y, 15, 15); //Ubicación del contorno del nodo
        // Titulo/Nombre del nodo
        ((Graphics2D) circulo).setColor(Color.BLUE);//Color fuente del nombre del nodo
        Font fuente = new Font("Arial", Font.BOLD, 14); // Fuente del nombe del nodo
        circulo.setFont(fuente); // establecela fuente definida
        ((Graphics2D) circulo).drawString(id, x, y); // Dibuja la ubicación del texto del nodo

    }
/**
 *  Este metodo grafico se apoya en los elementos graficos de lalibreria AWT para dibujar
 * la arista entre los nodos seleccionados,usando las cooordenadas de estos
 * y el peso establecido con el usuario
 * @param linea
 * @param x = Coordenada X en el lienzo  del nodo 1 seleccionado por interfaz
 * @param y = Coordenada Y en el lienzo  del nodo 1 seleccionado por interfaz
 * @param x1 = Coordenada X en el lienzo  del nodo 2 seleccionado por interfaz
 * @param y1 = Coordenada X en el lienzo  del nodo 2 seleccionado por interfaz
 * @param peso = Valor de la arista que se va a dibujar entre los dos nodos
 */
    public static void dibujarLinea(Graphics linea, int x, int y, int x1, int y1, int peso) {
        int xAux = 0; // Coordenada auxiliar de la linea a dibujar en el eje X
        int yAux = 0; // Coordenada auxiliar de la linea a dibujar en el eje X
        ((Graphics2D) linea).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);//Grosor de la linea
        ((Graphics2D) linea).setStroke(stroke); // Se le da al elemento grafico linea el objetp generado de tipo Stroke
        ((Graphics2D) linea).drawLine(x + 10, y + 10, x1 + 10, y1 + 10); // Se le suma a cada una de las coordenadas recogidas de los nodos 10 px para que quede en borde de cada nodo
        // Calculo de las dimenciones de las coordenadas auxiliares para la linea 
        // Para el eje X: 
        // - Si el primer nodo se situa antes del segundo nodo, se va a restar la distancia del segundo nodo al primero para encontrar la coordenada en X
        // - Si el primer nodo se situa antes del segundo nodo, se va a restar la distancia del primer nodo al segundo para encontrar la coordenada en X
        if (x <= x1) {
            xAux = ((x1 - x) / 2) + x;
        }
        if (x > x1) {
            xAux = ((x - x1) / 2) + x1;
        }
        // Para el eje Y: 
        // - Si el primer nodo se situa abajo del segundo nodo, se va a restar la distancia del segundo nodo al primero para encontrar la coordenada en Y
        // - Si el primer nodo se situa arriba del  segundo nodo, se va a restar la distancia del primer nodo al segundo para encontrar la coordenada en Y
        if (y < y1) {
            yAux = ((y1 - y) / 2) + y;
        }
        if (y >= y1) {
            yAux = ((y - y1) / 2) + y1;
        }
        Font fuente = new Font("Arial", Font.PLAIN, 12); // Definicion de la variable Fuente creada de la clase Font
        linea.setFont(fuente); // Asignbación de la fuente del texto de la linea creada 
        ((Graphics2D) linea).drawString(String.valueOf(peso), xAux, yAux); //Dibujo de la arista entre los dos nodos,con el peso ingresado por el usuario y las coordenadas para la linea
    }

/**
 * Este es el metodo grafico el cual dibujara o pintara las aristas que conectan a dos nodos por medio del Algoritmo de Dijkstra
 * @param trazo = elemento grafico de la clase Graphics2D, la cual sera la arista entre dos nodos
 * @param x = coordenada en X del primer nodo
 * @param y = coordenada en Y del primer nodo
 * @param x1 = coordenada X del segundo nodo
 * @param y1 = coordenada Y del segundo nodo
 * @param color = se define en la Ventana principal
 */
    public static void dibujarArista(Graphics trazo, int x, int y, int x1, int y1, Color color) {
        ((Graphics2D) trazo).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2); // se crea una linea o trazo entre los dos nodos con su grosor definido
        ((Graphics2D) trazo).setStroke(stroke); // se le asigna el elemento grafico (trazo) creado previamnente
        trazo.setColor(color); // Color de la linea (verde, se puede modificar en  "Ventanas.VentanaPrincipal."
        trazo.drawLine(x + 10, y + 10, x1 + 10, y1 + 10); // se dibuja la linea entre los nodos 
    }
/**
 * Metodo grafico para demostrar que se ha seleccionado un nodo a encontrar su camino más corto hacia otro
 * @param nodoSeleccionado
 * @param x = coordenada X del nodo
 * @param y = coordenada Y del nodo
 * @param id = identificador del nodo
 */
    public static void clickSobreNodo(Graphics nodoSeleccionado, int x, int y, String id,Color c) {
        ((Graphics2D) nodoSeleccionado).setColor(c); // Color delnodo cuando se selecciona para encontrar su camino mas corto hacia otro nodo
        ((Graphics2D) nodoSeleccionado).setStroke(new BasicStroke(2));//Grosor del circulo        
        ((Graphics2D) nodoSeleccionado).fillOval(x, y, 15, 15);//Rellena el nodo seleccionado para encontrar su camino mas corto hacia otro nodo
        ((Graphics2D) nodoSeleccionado).setColor(Color.BLACK);// Color del contorno del nodo seleccionado
        ((Graphics2D) nodoSeleccionado).drawOval(x, y, 15, 15);// Dibuja el nodo de nuevo en la misma ubicación
    }
}
