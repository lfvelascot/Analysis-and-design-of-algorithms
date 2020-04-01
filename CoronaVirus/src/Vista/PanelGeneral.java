
package Vista;

import Controlador.Archivo;
import Controlador.ListaPaises;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.Pais;


public class PanelGeneral extends javax.swing.JPanel {

    private final VentanaPrincipal p;
    private final ListaPaises lp;
    private final Archivo arc;
    private final DefaultListModel modelo;
    private final DefaultListModel modelo2;
    private boolean mod;
    private String nomPaisMod;

    public PanelGeneral(ListaPaises lp, VentanaPrincipal principal) throws IOException {
        this.p = principal;
        this.lp = p.getClp();
        this.arc = p.getA();
        this.modelo = new DefaultListModel();
        this.jListListaPaises = new JList();
        this.modelo2 = new DefaultListModel();
        this.jListListaPaisesMuertos = new JList();
        this.mod = false;
        this.nomPaisMod = "";
        initComponents();
        this.jTextFieldTotalMuertos.setText(lp.totalMuertos());
        this.jTextFielTotalCont.setText(lp.totalContagiados());
        this.jLabelFecha.setText(arc.obtenerFechaModificación());
        actualizarListaContagiados();
        actualizarListaMuertos();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonBuscarPais = new javax.swing.JButton();
        jButtonModificarPaís = new javax.swing.JButton();
        jButtonEliminarNumCont = new javax.swing.JButton();
        jButtonEliminarNumMuertos = new javax.swing.JButton();
        jButtonActualizarPaís1 = new javax.swing.JButton();
        jButtonEliminarPais = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonCrearPais = new javax.swing.JButton();
        jTextFieldNomPais = new javax.swing.JTextField();
        jTextFieldNumMuertos = new javax.swing.JTextField();
        jTextFieldNumCont = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListListaPaises = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTotalMuertos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFielTotalCont = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListListaPaisesMuertos = new javax.swing.JList<>();

        jPanel1.setBackground(new java.awt.Color(229, 228, 236));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jPanel3.setBackground(new java.awt.Color(229, 228, 236));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("MENÚ");

        jButtonBuscarPais.setBackground(new java.awt.Color(241, 192, 150));
        jButtonBuscarPais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonBuscarPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonOFF.png"))); // NOI18N
        jButtonBuscarPais.setText("Buscar País");
        jButtonBuscarPais.setBorder(null);
        jButtonBuscarPais.setBorderPainted(false);
        jButtonBuscarPais.setContentAreaFilled(false);
        jButtonBuscarPais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscarPais.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscarPais.setIconTextGap(-3);
        jButtonBuscarPais.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonSELECTED.png"))); // NOI18N
        jButtonBuscarPais.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonBuscarPais.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonBuscarPais.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonBuscarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPaisActionPerformed(evt);
            }
        });

        jButtonModificarPaís.setBackground(new java.awt.Color(241, 192, 150));
        jButtonModificarPaís.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonModificarPaís.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonOFF.png"))); // NOI18N
        jButtonModificarPaís.setText("Modificar País");
        jButtonModificarPaís.setBorder(null);
        jButtonModificarPaís.setBorderPainted(false);
        jButtonModificarPaís.setContentAreaFilled(false);
        jButtonModificarPaís.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonModificarPaís.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificarPaís.setIconTextGap(-3);
        jButtonModificarPaís.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonSELECTED.png"))); // NOI18N
        jButtonModificarPaís.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonModificarPaís.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonModificarPaís.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonModificarPaís.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarPaísActionPerformed(evt);
            }
        });

        jButtonEliminarNumCont.setBackground(new java.awt.Color(241, 192, 150));
        jButtonEliminarNumCont.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonEliminarNumCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonOFF.png"))); // NOI18N
        jButtonEliminarNumCont.setText("Eliminar Num. Contagiados");
        jButtonEliminarNumCont.setBorder(null);
        jButtonEliminarNumCont.setBorderPainted(false);
        jButtonEliminarNumCont.setContentAreaFilled(false);
        jButtonEliminarNumCont.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEliminarNumCont.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEliminarNumCont.setIconTextGap(-3);
        jButtonEliminarNumCont.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonSELECTED.png"))); // NOI18N
        jButtonEliminarNumCont.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonEliminarNumCont.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonEliminarNumCont.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonEliminarNumCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarNumContActionPerformed(evt);
            }
        });

        jButtonEliminarNumMuertos.setBackground(new java.awt.Color(241, 192, 150));
        jButtonEliminarNumMuertos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonEliminarNumMuertos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonOFF.png"))); // NOI18N
        jButtonEliminarNumMuertos.setText("Eliminar Num. Muertos");
        jButtonEliminarNumMuertos.setBorder(null);
        jButtonEliminarNumMuertos.setBorderPainted(false);
        jButtonEliminarNumMuertos.setContentAreaFilled(false);
        jButtonEliminarNumMuertos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEliminarNumMuertos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEliminarNumMuertos.setIconTextGap(-3);
        jButtonEliminarNumMuertos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonSELECTED.png"))); // NOI18N
        jButtonEliminarNumMuertos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonEliminarNumMuertos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonEliminarNumMuertos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonEliminarNumMuertos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarNumMuertosActionPerformed(evt);
            }
        });

        jButtonActualizarPaís1.setBackground(new java.awt.Color(241, 192, 150));
        jButtonActualizarPaís1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonActualizarPaís1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonOFF.png"))); // NOI18N
        jButtonActualizarPaís1.setText("Actualizar País");
        jButtonActualizarPaís1.setBorder(null);
        jButtonActualizarPaís1.setBorderPainted(false);
        jButtonActualizarPaís1.setContentAreaFilled(false);
        jButtonActualizarPaís1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonActualizarPaís1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonActualizarPaís1.setIconTextGap(-3);
        jButtonActualizarPaís1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonSELECTED.png"))); // NOI18N
        jButtonActualizarPaís1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonActualizarPaís1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonActualizarPaís1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonActualizarPaís1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarPaís1ActionPerformed(evt);
            }
        });

        jButtonEliminarPais.setBackground(new java.awt.Color(241, 192, 150));
        jButtonEliminarPais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonEliminarPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonOFF.png"))); // NOI18N
        jButtonEliminarPais.setText("Eliminar País");
        jButtonEliminarPais.setBorder(null);
        jButtonEliminarPais.setBorderPainted(false);
        jButtonEliminarPais.setContentAreaFilled(false);
        jButtonEliminarPais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEliminarPais.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEliminarPais.setIconTextGap(-3);
        jButtonEliminarPais.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonSELECTED.png"))); // NOI18N
        jButtonEliminarPais.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonEliminarPais.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonEliminarPais.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonEliminarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonBuscarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonEliminarNumCont, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonEliminarNumMuertos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonModificarPaís, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonActualizarPaís1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonEliminarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEliminarNumCont, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEliminarNumMuertos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonModificarPaís, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonActualizarPaís1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEliminarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setText("DATOS DEL PAIS");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Num. Contagiados");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Num. Muertos");

        jButtonCrearPais.setBackground(new java.awt.Color(241, 192, 150));
        jButtonCrearPais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCrearPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonOFF.png"))); // NOI18N
        jButtonCrearPais.setText("Crear País");
        jButtonCrearPais.setBorderPainted(false);
        jButtonCrearPais.setContentAreaFilled(false);
        jButtonCrearPais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCrearPais.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCrearPais.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonSELECTED.png"))); // NOI18N
        jButtonCrearPais.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonCrearPais.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonCrearPais.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonON.png"))); // NOI18N
        jButtonCrearPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearPaisActionPerformed(evt);
            }
        });

        jTextFieldNomPais.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextFieldNumMuertos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTextFieldNumCont.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jListListaPaises.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jListListaPaises);

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setText("LISTA POR CONTAGIADOS");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("TOTAL CONTAGIADOS");

        jTextFieldTotalMuertos.setBackground(new java.awt.Color(255, 204, 204));
        jTextFieldTotalMuertos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextFieldTotalMuertos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalMuertos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 102));
        jLabel9.setText("TOTAL MUERTOS");

        jTextFielTotalCont.setBackground(new java.awt.Color(255, 204, 204));
        jTextFielTotalCont.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextFielTotalCont.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFielTotalCont.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dec0208130c89d6421f5bddbae495df8.gif"))); // NOI18N
        jLabel10.setText("jLabel10");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bannerOFF.png"))); // NOI18N
        jButton1.setText(" ");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bannerON.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bannerON.png"))); // NOI18N
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bannerON.png"))); // NOI18N
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bannerON.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(229, 228, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel12.setText("Ultima fecha de actualización");

        jLabelFecha.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(255, 51, 51));
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha.setText("      ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelFecha)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel11.setText("LISTA POR MUERTOS");

        jListListaPaisesMuertos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(jListListaPaisesMuertos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldNumMuertos)
                                    .addComponent(jButtonCrearPais, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNumCont)
                                    .addComponent(jTextFieldNomPais)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFielTotalCont, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldTotalMuertos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(11, 11, 11)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(47, 47, 47)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNumCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldNumMuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCrearPais, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFielTotalCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldTotalMuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModificarPaísActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarPaísActionPerformed
        modificarPais();
    }//GEN-LAST:event_jButtonModificarPaísActionPerformed

    private void jButtonActualizarPaís1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarPaís1ActionPerformed
        try {
            actualizarPais();
        } catch (IOException ex) {
            Logger.getLogger(PanelGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonActualizarPaís1ActionPerformed

    private void jButtonCrearPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearPaisActionPerformed
        try {
            createPais();
        } catch (IOException ex) {
            Logger.getLogger(PanelGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCrearPaisActionPerformed

    private void jButtonBuscarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPaisActionPerformed
        buscarPais();
    }//GEN-LAST:event_jButtonBuscarPaisActionPerformed

    private void jButtonEliminarNumContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarNumContActionPerformed
        try {
            eliminarNumContagiados();
        } catch (IOException ex) {
            Logger.getLogger(PanelGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarNumContActionPerformed

    private void jButtonEliminarNumMuertosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarNumMuertosActionPerformed
        try {
            eliminarNumMuertos();
        } catch (IOException ex) {
            Logger.getLogger(PanelGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarNumMuertosActionPerformed

    private void jButtonEliminarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPaisActionPerformed
        try {
            eliminarPais();
        } catch (IOException ex) {
            Logger.getLogger(PanelGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarPaisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonActualizarPaís1;
    private javax.swing.JButton jButtonBuscarPais;
    private javax.swing.JButton jButtonCrearPais;
    private javax.swing.JButton jButtonEliminarNumCont;
    private javax.swing.JButton jButtonEliminarNumMuertos;
    private javax.swing.JButton jButtonEliminarPais;
    private javax.swing.JButton jButtonModificarPaís;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JList<String> jListListaPaises;
    private javax.swing.JList<String> jListListaPaisesMuertos;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFielTotalCont;
    private javax.swing.JTextField jTextFieldNomPais;
    private javax.swing.JTextField jTextFieldNumCont;
    private javax.swing.JTextField jTextFieldNumMuertos;
    private javax.swing.JTextField jTextFieldTotalMuertos;
    // End of variables declaration//GEN-END:variables

    private boolean validarCampos() {
        return !(jTextFieldNomPais.getText().equals("") || jTextFieldNumCont.getText().equals("") || jTextFieldNumMuertos.getText().equals(""));
    }

    private void createPais() throws IOException {
        if (validarCampos()) {
            try {
                Pais paisNuevo = new Pais(jTextFieldNomPais.getText(),
                        Integer.parseInt(jTextFieldNumCont.getText()),
                        Integer.parseInt(jTextFieldNumMuertos.getText()));
                if (lp.crearPais(paisNuevo)) {
                    JOptionPane.showMessageDialog(this, "PAIS CREADO CON EXITO\n"
                            + paisNuevo.impresionConsola());
                    limpiarCampos();
                    actualizarListaContagiados();actualizarListaMuertos();
                    actualizarValores();

                } else {
                    JOptionPane.showMessageDialog(this, "EL PAIS INGRESADO YA SE ENCUENTRA EN LA LISTA");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "EN LAS CASILLAS DE NUMERO DE CONTAGIADOS Y DE MUERTOS SOLO SE ADMITEN VALORES NUMERICOS ENTEROS");
            }
        } else {
            JOptionPane.showMessageDialog(this, "TODOS LOS CAMPOS DEBEN ESTAR LLENOS");
        }
    }

    private void actualizarValores() throws IOException {
        jTextFieldTotalMuertos.setText(lp.totalMuertos());
        jTextFielTotalCont.setText(lp.totalContagiados());
        jLabelFecha.setText(arc.obtenerFechaModificación());
    }

    private void limpiarCampos() {
        jTextFieldNomPais.setText("");
        jTextFieldNumCont.setText("");
        jTextFieldNumMuertos.setText("");
    }

    private void buscarPais() {
        String nombrePais = JOptionPane.showInputDialog("Introduzca el nombre del pais a buscar");
        if (nombrePais != null) {
            Pais paisBuscado = lp.buscarPais(nombrePais);
            if (paisBuscado == null) {
                JOptionPane.showMessageDialog(this, "No se encontro a " + nombrePais + " en la lista.");
            } else {
                JOptionPane.showMessageDialog(this, "PAIS ENCONTRADO CON EXITO\n"
                        + paisBuscado.impresionConsola());
            }
        }
    }

    private void actualizarListaContagiados() {
        if (!lp.estaVacia()) {
            modelo.removeAllElements();
            for (int i = 0; i < lp.tamanio(); i++) {
                Pais aux = lp.getPais(i);
                String nombreP = aux.getNomPais();
                Integer numC = aux.getNumContagiados();
                modelo.addElement(nombreP + "  - " + numC + "\n");
                jListListaPaises.setModel(modelo);
            }
        }
    }
   
     private void actualizarListaMuertos() {
        if (!lp.estaVacia()) {
            modelo2.removeAllElements();
            ArrayList<Pais> listaMuertos = lp.listaPorMuertos();
            for (int i = 0; i < listaMuertos.size(); i++) {
                Pais aux = listaMuertos.get(i);
                String nombreP = aux.getNomPais();
                Integer numM = aux.getNumMuertos();
                modelo2.addElement(nombreP + "  - " + numM + "\n");
                jListListaPaisesMuertos.setModel(modelo2);
            }
        }
    }
    

    private void eliminarNumContagiados() throws IOException {
        String nombrePais = JOptionPane.showInputDialog("Introduzca el nombre del pais a modificar");
        if (nombrePais != null) {
            if (lp.eliminarDatos(nombrePais, 1)) {
                Pais paisBuscado = lp.buscarPais(nombrePais);
                JOptionPane.showMessageDialog(this, "PAIS MODIFICADO CON EXITO\n"
                        + paisBuscado.impresionConsola());
                actualizarListaContagiados();actualizarListaMuertos();
                actualizarValores();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro a " + nombrePais + " en la lista.");
            }
        }
    }

    private void eliminarNumMuertos() throws IOException {
        String nombrePais = JOptionPane.showInputDialog("Introduzca el nombre del pais a modificar");
        if (nombrePais != null) {
            if (lp.eliminarDatos(nombrePais, 2)) {
                Pais paisBuscado = lp.buscarPais(nombrePais);
                JOptionPane.showMessageDialog(this, "PAIS MODIFICADO CON EXITO\n"
                        + paisBuscado.impresionConsola());
                actualizarListaContagiados();actualizarListaMuertos();
                actualizarValores();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro a " + nombrePais + " en la lista.");
            }
        }

    }

    private void modificarPais() {
        nomPaisMod = JOptionPane.showInputDialog("Introduzca el nombre del pais a modificar:");
        if (nomPaisMod != null) {
            Pais modfied = lp.buscarPais(nomPaisMod);
            if (p == null) {
                JOptionPane.showMessageDialog(this, "No se encontro a " + nomPaisMod + " en la lista.");
            } else {
                mod = true;
                JOptionPane.showMessageDialog(this, "Al terminar de realizar la modificación de los datos, por favor de click en el boton 'Actualizar Pais'.");
                jTextFieldNomPais.setText(modfied.getNomPais());
                jTextFieldNumCont.setText(String.valueOf(modfied.getNumContagiados()));
                jTextFieldNumMuertos.setText(String.valueOf(modfied.getNumMuertos()));
            }
        }
    }

    private void actualizarPais() throws IOException {
        if (mod && nomPaisMod != null) {
            if (validarCampos()) {
                try {
                    Pais paisMod = new Pais(jTextFieldNomPais.getText(),
                            Integer.parseInt(jTextFieldNumCont.getText()),
                            Integer.parseInt(jTextFieldNumMuertos.getText()));
                    if (lp.modificarPais(paisMod, nomPaisMod)) {
                        JOptionPane.showMessageDialog(this, "PAIS MODIFICADO CON EXITO\n"
                                + paisMod.impresionConsola());
                        limpiarCampos();
                        actualizarListaContagiados();actualizarListaMuertos();
                        actualizarValores();
                    } else {
                        JOptionPane.showMessageDialog(this, "PROBLEMAS EN LA MODIFICACIÓN DEL PAIS");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "EN LAS CASILLAS DE NUMERO DE CONTAGIADOS Y DE MUERTOS SOLO SE ADMITEN VALORES NUMERICOS ENTEROS");
                }
                mod = false;
                nomPaisMod = "";
            } else {
                JOptionPane.showMessageDialog(this, "TODOS LOS CAMPOS DEBEN ESTAR LLENOS");
            }
        } else {
            JOptionPane.showMessageDialog(this, " No se ha realizado la busqueda previa\n para actualizar los datos del país");
        }

    }

    private void eliminarPais() throws IOException {
        String nomPais = JOptionPane.showInputDialog("Introduzca el nombre del pais a eliminar:");
        if (nomPais != null) {
            Pais deleted = lp.buscarPais(nomPais);
            if (deleted == null) {
                JOptionPane.showMessageDialog(this, "No se encontro a " + nomPais + " en la lista.");
            } else {
                JOptionPane.showMessageDialog(this, "PAIS ELIMINADO CON EXITO\n"
                        + deleted.impresionConsola());
                lp.eliminarPais(nomPais);
                actualizarListaContagiados();actualizarListaMuertos();
                actualizarValores();
            }
        }

    }
}
