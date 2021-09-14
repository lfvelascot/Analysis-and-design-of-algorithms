package Ventanas;

import Grafo.Grafo;
import Grafo.Graficar;
import Grafo.AlgoritmoDijkstra;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Felipe Velasco Tao
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Crear una nueva ventana principal
     */
    Graficar pintar = new Graficar();
    Grafo grafo = new Grafo();

    /**
     * Este metodo se encargara de recuperar el grafo creado, se usara al realizar canbios en el Grafo, de modo que se asegure por medio de interfaz
     * los cambios que este sufra.
     * @param tope: cantidad de nodos existentes
     * @param grafo: grafo en el que se esta trabajando
     */
    public static void actualizarGrafo(int tope, Grafo grafo) {
        //Ciclo encargado de sibujar las aristas almacenadas en el grafo.
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if (grafo.getMatrizAdyacencia(j, k) == 1) {
                    Graficar.dibujarLinea(jPanel1.getGraphics(), grafo.getCoordenadaX(j), grafo.getCoordenadaY(j), grafo.getCoordenadaX(k), grafo.getCoordenadaY(k), grafo.getMatrizCoeficiente(j, k));
                }
            }
        }
        // Se dibujan primero las lineas para luego poner los nodos sobre estas y evitar que el grafo se vea mal.
        // Ciclo encargado de dibujar los nodos 
        for (int j = 0; j < tope; j++) {
            Graficar.dibujarCirculo(jPanel1.getGraphics(), grafo.getCoordenadaX(j), grafo.getCoordenadaY(j), String.valueOf(grafo.getNombre(j)));
        }

    }

    /**
     * Este metodo se encargara de mostrar una ventana en la que el usuario ingresara elnodo que requiera eliminar
     * @param nodoInicio = Nodo ingresado por el usuario
     * @param noExiste = Cadena de texto que sera mostrada si el nodo no existe
     * @param tope = cantidad de nodos existentes
     * @return nodoSelecc : elnodo elcualsera eliminado
     */
    public static int ingresarNodo(String nodoInicio, String noExiste, int tope) {
        // Variable entera que almacenara el nodo ingresado por el usuario
        int nodoSelecc = 0;
        // se encapsula la accion del menu en un bloque TRY - CATCH el cual asegurara que el usuario ingrese un dato valido 
        try {
            // Se cambia el valor ingresado (almacenado en un String) a un entero) siendo ingresado en un campo de texto delpanel
            nodoSelecc = Integer.parseInt(JOptionPane.showInputDialog("" + nodoInicio));
            // Si el nodo noexiste, se volvera a mostrar la ventana hasta que el usuario ingrese un nodo existente
            if (nodoSelecc >= tope) {
                JOptionPane.showMessageDialog(null, "" + noExiste ); // Se muestra el mensaje al usuario
                nodoSelecc = ingresarNodo(nodoInicio, noExiste, tope); // se lanza de nuevo el mismo metodo
            }
            // Si se genera un error en los datos ingresados, se permite realizar de nuevo el proceso
        } catch (Exception ex) {
            nodoSelecc = ingresarNodo(nodoInicio, noExiste, tope);
        }
        return nodoSelecc;
    }
/**
 *  Estemetodo se encagara de recoger el peso de una Arista por medio de una ventana de dialogo
 * @param peso = Valor recogido de tipo String
 * @return pesoArista = valor recogido por medio del metodo
 */
    public int asignarPeso(String peso) {
        // Se crea la variable donde se almacenara el valor
        int pesoArista = 0;
        // Se encapsula las acciones de este metodo para que laventana se muestre hasta que el usuario ingrese un valor correcto y valido para el peso de la arista
        try {
            // Se muestra la ventana y el campo donde se recogera el valor del peso de dicha arista
            pesoArista = Integer.parseInt(JOptionPane.showInputDialog("" + peso));
            // se confirma por medio de un condicionalque este valor sea positivo y no sea mayor a 30
            if (pesoArista < 1 || pesoArista > 30) {
                JOptionPane.showMessageDialog(null, "El peso del nodo debe estar entre 1 y 30"); // Si esta condicion se cumple,se lanzara un mensaje de error 
                pesoArista = asignarPeso(peso); // Se vuelve a mostrar la ventana
            }
            // si hay algun problema al digitar elvalor, se volvera a mostrar la ventana
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Valor ingresado no valido (ingrese solo numeros positivos no mayores a 30)");
            pesoArista = asignarPeso(peso);
        }
        return pesoArista; // se envia el valor del peso a donde se requiera
    }

    /**
     *
     * @param xxx = Coordenada
     * @param yyy = Coordenada
     * @return boolean
     */
    public boolean clickDerechoEnElNodo(int xxx, int yyy) {
        for (int j = 0; j < tope; j++) {// Verificamossi se ha dado click sobre algun nodo
            if ((xxx + 2) > grafo.getCoordenadaX(j) && xxx < (grafo.getCoordenadaX(j) + 13) && (yyy + 2) > grafo.getCoordenadaY(j) && yyy < (grafo.getCoordenadaY(j) + 13)) {
                if (n == 0) {
                    id = j;
                    actualizarGrafo(tope, grafo); // Garantizamos la integridad del grafo actualizandolo
                    Graficar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCoordenadaX(j), grafo.getCoordenadaY(j), null,Color.orange); // Se cambia el color del nodo
                    n++;
                } else {
                    id2 = j;
                    n++;
                    Graficar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCoordenadaX(j), grafo.getCoordenadaY(j), null, Color.orange);
                    if (id == id2) {// Si id == id2 es por que se volvio a dar click sobre el mismos nodo, se cancela el click anterior
                        // De lo contrario se creara un nuevo nodo, y se reiniciaran los valores que recogen las posiciones en el frame
                        n = 0;
                        Graficar.dibujarCirculo(jPanel1.getGraphics(), grafo.getCoordenadaX(id), grafo.getCoordenadaY(id), String.valueOf(grafo.getNombre(id)));
                        id = -1;
                        id2 = -1; 
                    }
                }
                nn = 0;
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param xxx
     * @param yyy
     */
    public void clickIzquierdoSobreElNodo(int xxx, int yyy) {
        for (int j = 0; j < tope; j++) {
            if ((xxx + 2) > grafo.getCoordenadaX(j) && xxx < (grafo.getCoordenadaX(j) + 13) && (yyy + 2) > grafo.getCoordenadaY(j) && yyy < (grafo.getCoordenadaY(j) + 13)) {
                if (nn == 0) {
                    nodoInicio = j;
                    actualizarGrafo(tope, grafo);
                } else {
                    nodoFin = j;
                }
                nn++;
                n = 0;
                id = -1;
                Graficar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCoordenadaX(j), grafo.getCoordenadaY(j), null, Color.GREEN);
                break;
            }

        }

    }

    public VentanaPrincipal() {
        initComponents();
        jDialog1.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jmapa = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        jDialog1.setMinimumSize(new java.awt.Dimension(700, 450));
        jDialog1.setResizable(false);
        jDialog1.getContentPane().setLayout(null);

        jFileChooser2.setMaximumSize(new java.awt.Dimension(21475, 21474));
        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jFileChooser2);
        jFileChooser2.setBounds(10, 20, 670, 390);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROYECTO GRAFOS - USB");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMinimumSize(new java.awt.Dimension(770, 522));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });
        jPanel1.setLayout(null);

        jmapa.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jmapa);
        jmapa.setBounds(10, 10, 860, 370);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 70, 880, 390);

        jButton1.setText("Graficar");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(420, 470, 80, 50);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel7.setText("GRAFOS");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(370, 20, 180, 30);

        jMenu1.setText("Opciones del grafo");

        jMenuItem7.setText("Matiz de adyacencia");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem5.setText("Matriz de coeficientes");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem8.setText("Salir");
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Eliminar");

        jMenuItem10.setText("Eliminar Nodo");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(934, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Aqui se controlan las acciones realizadas con el mouse, garantizando que los procesos no se mexclen.
     * @param evt 
     */
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        int xxx, yyy;
        xxx = evt.getX();
        yyy = evt.getY();
        if (evt.isMetaDown()) {
            clickIzquierdoSobreElNodo(xxx, yyy);
            if (nn == 2) {
                nn = 0;
                AlgoritmoDijkstra Dijkstra = new AlgoritmoDijkstra(grafo, tope, nodoInicio, nodoFin);
                Dijkstra.aDijkstra();
            }
        } else {
            if (!clickDerechoEnElNodo(xxx, yyy)) {// si  clik sobre  nodo es falso entra
                if (tope < 12) {
                    grafo.setCoordenadaX(tope, xxx);
                    grafo.setCoordenadaY(tope, yyy);
                    grafo.setNombre(tope, tope);
                    Graficar.dibujarCirculo(jPanel1.getGraphics(), grafo.getCoordenadaX(tope), grafo.getCoordenadaY(tope), String.valueOf(grafo.getNombre(tope)));
                    tope++;
                } else {
                    JOptionPane.showMessageDialog(null, "Se ha llegado al limite de nodos");
                }
            }
            if (n == 2) {
                // Convertir en una ventana
                n = 0;
                int ta = asignarPeso("Ingrese el peso de la arista");
                if (aristaMayor < ta) {
                    aristaMayor = ta;
                }
                grafo.setMatrizAdyacencia(id2, id, 1);
                grafo.setMatrizAdyacencia(id, id2, 1);
                grafo.setMatrizCoeficiente(id2, id, ta);
                grafo.setMatrizCoeficiente(id, id2, ta);
                Graficar.dibujarLinea(jPanel1.getGraphics(), grafo.getCoordenadaX(id), grafo.getCoordenadaY(id), grafo.getCoordenadaX(id2), grafo.getCoordenadaY(id2), ta);
                Graficar.dibujarCirculo(jPanel1.getGraphics(), grafo.getCoordenadaX(id), grafo.getCoordenadaY(id), String.valueOf(grafo.getNombre(id)));
                Graficar.dibujarCirculo(jPanel1.getGraphics(), grafo.getCoordenadaX(id2), grafo.getCoordenadaY(id2), String.valueOf(grafo.getNombre(id2)));
                id = -1;
                id2 = -1;
            }
        }
    }//GEN-LAST:event_jPanel1MousePressed
/**
 * Boton el cual permite redibujar el grafo (esto sera necesario debido al panel)
 * @param evt 
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tope != 0){
        actualizarGrafo(tope, grafo);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningun elemento creado"); // Lanza un mensaje al usuario si no existe ningun nodo
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
     // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased

    }//GEN-LAST:event_jPanel1KeyReleased

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed

    }//GEN-LAST:event_jFileChooser2ActionPerformed
/**
 * En este metodo se realizara todo elproceso de eliminar un nodo de uestro grafo, eliminandolo
 * tanto de la interfaz (nodo y aristas que tenga), como de nuestra estrucutura de datos (matrices de adyacencia y de coeficientes)
 * @param evt 
 */
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
       // Validamos si existe al menos un nodo existente
        if (tope < 1) {
            JOptionPane.showMessageDialog(null, "Primero se debe crear al menos un nodo"); // Si se cumple la condicion,se lanza un mensaje
        } else {
            // Se le pide al usuario ingresar el nodo que desea eliminar
            int Eliminar = ingresarNodo("Ingrese nodo a eliminar ", "Nodo no existe", tope);
            // Se valida que el nodo ingresado exista: que este entre el rango de nodos existentes, que no sea un valor negativo y que exista algun nodo
            if (Eliminar <= tope && Eliminar >= 0 && tope > 0) {
                // Se realiza un barrido para encontrar el nodo y demarcar sus conexiones con otros nodos como "inesxistentes".
                for (int i = 0; i < tope; i++) {
                    for (int j = 0; j < tope; j++) {
                        if (i == Eliminar || j == Eliminar) {
                            grafo.setMatrizAdyacencia(i, j, -1);
                        }
                    }
                }
                //Corremos las posiciones de los nodos existentes en el eje X (Tanto aristas (ady) y pesos (coe))
                for (int i = 0; i < tope - 1; i++) {
                    for (int j = 0; j < tope; j++) {
                        if (grafo.getMatrizAdyacencia(i, j) == -1) {
                            grafo.setMatrizAdyacencia(i, j, grafo.getMatrizAdyacencia(i + 1, j));
                            grafo.setMatrizAdyacencia(i + 1, j, -1);
                            grafo.setMatrizCoeficiente(i, j, grafo.getMatrizCoeficiente(i + 1, j));
                        }
                    }
                }
                // Corremos las posiciones de los nodos existentes en el eje Y (Tanto aristas (ady) y pesos (coe))
                for (int i = 0; i < tope; i++) {
                    for (int j = 0; j < tope - 1; j++) {
                        if (grafo.getMatrizAdyacencia(i, j) == -1) {
                            grafo.setMatrizAdyacencia(i, j, grafo.getMatrizAdyacencia(i, j + 1));
                            grafo.setMatrizAdyacencia(i, j + 1, -1);
                            grafo.setMatrizCoeficiente(i, j, grafo.getMatrizCoeficiente(i, j + 1));
                        }
                    }
                }
                /**
                 * Mandamos las coordenadas del nodo a eliminar para de este modo
                 * tener ya demarcada la posicion en que se encuentra
                 */
                grafo.setCoordenadaX(Eliminar, -10);
                grafo.setCoordenadaY(Eliminar, -10);
                grafo.setNombre(Eliminar, -10);
                /**
                 *  Bucles anidados por los cuales recorreremos las coordenadas de los nodos para:
                 *  - Mover un lugar las coordenadas de los nodos
                 * - 
                 */
                for (int i = 0; i < tope; i++) {
                    for (int j = 0; j < tope - 1; j++) {
                        if (grafo.getCoordenadaX(j) == -10) {
                            grafo.setCoordenadaX(j, grafo.getCoordenadaX(j + 1));
                            grafo.setCoordenadaX(j + 1, -10);
                            grafo.setCoordenadaY(j, grafo.getCoordenadaY(j + 1));
                            grafo.setCoordenadaY(j + 1, -10);
                            grafo.setNombre(j, grafo.getNombre(j + 1));
                            grafo.setNombre(j + 1, -10);
                        }
                    }
                }
                // Se corren las posiciones de los nodos
                for (int j = 0; j < tope; j++) {
                    grafo.setNombre(j, j);// Renombramos
                }
                /**
                 * Despues de los dos barridos donde marcabamos las conexiones
                 * existentes del nodo a eliminar y el peso que hay en estas aristas
                 * Los eliminamos de las matrices. Asi se actualizara y correran las posiciones de los nodos
                 * que quedan existiendo en el grafo
                 */  
                for (int j = 0; j < tope + 1; j++) {
                    for (int k = 0; k < tope + 1; k++) {
                        if (grafo.getMatrizAdyacencia(j, k) != -1) {
                            grafo.setMatrizAdyacencia(j, k, grafo.getMatrizAdyacencia(j, k));
                        } else {
                            grafo.setMatrizAdyacencia(j, k, 0);
                        }
                        if (grafo.getMatrizCoeficiente(j, k) != -10) {
                            grafo.setMatrizCoeficiente(j, k, grafo.getMatrizCoeficiente(j, k));
                        } else {
                            grafo.setMatrizCoeficiente(j, k, 0);
                        }
                    }
                }
                tope--; // Se disminuye la cantidad de nodos en el grafo 
                jPanel1.paint(jPanel1.getGraphics()); // Se dibujan los elementos en el panel
                actualizarGrafo(tope, grafo); // Con los cambios realizados en los componentes del grafo, redibujados las aristas y los nodos que existen aún
            }
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (tope == 0) {
            JOptionPane.showMessageDialog(null, "Aun no se ha creado un nodo");
        } else {
            this.setEnabled(false);
            new Matrices(tope+1, grafo, 1, this).setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (tope == 0) {
            JOptionPane.showMessageDialog(null, "Aun no se ha creado un nodo");
        } else {
            this.setEnabled(false);
            new Matrices(tope+1, grafo, 2, this).setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }
    private int tope = 0;// Lleva el numero de nodos creados
    private int nodoFin; // Nodo al que se quiere llegar 
    private int nodoInicio; // Nodo desde el que se quiere partir
    int n = 0, nn = 0, id, id2;// Permite controlar que se halla dado click sobre un nodo
    private int aristaMayor; // Peso de la arista más grande 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jmapa;
    // End of variables declaration//GEN-END:variables
}
