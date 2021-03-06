/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.usbbog.ingsistemas.ada.panaderia.vista;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
import co.edu.usbbog.ingsistemas.ada.panaderia.modelo.Producto;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author COMPURED
 */
public class PanelReportes extends javax.swing.JPanel {
    Ventana v;
    Gestion_Producto gp;
    PanelGestion pg;
    private final DefaultTableModel modeloTabla;
    String data[][] = {};
    String header[] = {"Fecha Venta", "Producto", "Valor Unit.", "Cantidad", "TOTAL"};
    Icon mensaje = new ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/miniIcono.png"));

    public PanelReportes(Ventana v) {
        this.v = v;
        this.gp = v.getGp();
        this.pg = v.getPg();
        this.jTableReportes = new JTable();
        initComponents();
        modeloTabla = new DefaultTableModel(data, header) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        jTableReportes.setModel(modeloTabla);
        gp.actualizarLista();
        actualizarTabla();
        actualizarTotal();
        actualizarFecha();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonIrGestion = new javax.swing.JButton();
        jButtonIrInicio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jLabelFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableReportes = new javax.swing.JTable();
        jButtonReporteDia = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(740, 500));
        setLayout(null);

        jButtonIrGestion.setForeground(new java.awt.Color(0, 0, 0));
        jButtonIrGestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonOFF.png"))); // NOI18N
        jButtonIrGestion.setText("Ventas");
        jButtonIrGestion.setBorderPainted(false);
        jButtonIrGestion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonIrGestion.setOpaque(false);
        jButtonIrGestion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonSELECT.png"))); // NOI18N
        jButtonIrGestion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonON.png"))); // NOI18N
        jButtonIrGestion.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonON.png"))); // NOI18N
        jButtonIrGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIrGestionActionPerformed(evt);
            }
        });
        add(jButtonIrGestion);
        jButtonIrGestion.setBounds(610, 470, 130, 30);

        jButtonIrInicio.setForeground(new java.awt.Color(0, 0, 0));
        jButtonIrInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonicono.jpg"))); // NOI18N
        jButtonIrInicio.setBorder(null);
        jButtonIrInicio.setBorderPainted(false);
        jButtonIrInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonIrInicio.setOpaque(false);
        jButtonIrInicio.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botoniconoPressed.jpg"))); // NOI18N
        jButtonIrInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIrInicioActionPerformed(evt);
            }
        });
        add(jButtonIrInicio);
        jButtonIrInicio.setBounds(610, 342, 130, 130);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TOTAL VENTAS:");
        add(jLabel2);
        jLabel2.setBounds(30, 440, 110, 17);

        jButtonActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonOFF.png"))); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.setBorderPainted(false);
        jButtonActualizar.setContentAreaFilled(false);
        jButtonActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonActualizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonSELECT.png"))); // NOI18N
        jButtonActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonON.png"))); // NOI18N
        jButtonActualizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonON.png"))); // NOI18N
        jButtonActualizar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonON.png"))); // NOI18N
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        add(jButtonActualizar);
        jButtonActualizar.setBounds(540, 240, 180, 40);

        jLabelFecha.setBackground(new java.awt.Color(255, 51, 51));
        jLabelFecha.setForeground(new java.awt.Color(255, 0, 51));
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelFecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabelFecha);
        jLabelFecha.setBounds(30, 460, 450, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("LISTA DE VENTAS");
        add(jLabel5);
        jLabel5.setBounds(160, 20, 225, 29);

        jTableReportes.setBackground(new java.awt.Color(255, 255, 255));
        jTableReportes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableReportes.setForeground(new java.awt.Color(0, 0, 0));
        jTableReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableReportes.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jScrollPane2.setViewportView(jTableReportes);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 60, 500, 360);

        jButtonReporteDia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonReporteDia.setForeground(new java.awt.Color(0, 0, 0));
        jButtonReporteDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonOFF.png"))); // NOI18N
        jButtonReporteDia.setText("Reporte por fecha");
        jButtonReporteDia.setBorderPainted(false);
        jButtonReporteDia.setContentAreaFilled(false);
        jButtonReporteDia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonReporteDia.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonSELECT.png"))); // NOI18N
        jButtonReporteDia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonON.png"))); // NOI18N
        jButtonReporteDia.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonON.png"))); // NOI18N
        jButtonReporteDia.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/botonON.png"))); // NOI18N
        jButtonReporteDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteDiaActionPerformed(evt);
            }
        });
        add(jButtonReporteDia);
        jButtonReporteDia.setBounds(540, 200, 180, 40);
        add(jSeparator2);
        jSeparator2.setBounds(110, 50, 310, 20);

        jLabelTotal.setBackground(new java.awt.Color(255, 51, 51));
        jLabelTotal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabelTotal);
        jLabelTotal.setBounds(260, 440, 220, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/wallpaper2.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 740, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIrGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIrGestionActionPerformed
        this.setVisible(false);
        v.setVisible(false);
        v.cambiarTitulo(" - Gestion de ventas");
        v.setSize(744, 532);
        v.add(v.getPg());
        v.setLocationRelativeTo(null);
        v.getPg().limpiarCampos();
        v.getPg().setVisible(true);
        v.setVisible(true);
    }//GEN-LAST:event_jButtonIrGestionActionPerformed

    private void jButtonIrInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIrInicioActionPerformed
        this.setVisible(false);
        v.setVisible(false);
        v.cambiarTitulo("");
        v.setSize(744, 532);
        v.add(v.getPp());
        v.setLocationRelativeTo(null);
        v.getPp().setVisible(true);
        v.setVisible(true);
    }//GEN-LAST:event_jButtonIrInicioActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        gp.actualizarLista();
        actualizarTabla();
        actualizarTotal();
        actualizarFecha();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonReporteDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteDiaActionPerformed
        reporteFecha();
    }//GEN-LAST:event_jButtonReporteDiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonIrGestion;
    private javax.swing.JButton jButtonIrInicio;
    private javax.swing.JButton jButtonReporteDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableReportes;
    // End of variables declaration//GEN-END:variables



    public void actualizarTotal() {
        jLabelTotal.setText("$"+String.valueOf(gp.totalPagos(gp.getLita())));
    }

    public void actualizarFecha() {
        jLabelFecha.setText(gp.obtenerFechaActualizacionDB());
    }

    private void reporteFecha() {
        String fecha = (String) JOptionPane.showInputDialog(this, "Introduzca lafecha a generar reporte (DD/MM/AAAA)", "BAKERY SHOP - Reporte de ventas por fecha", JOptionPane.INFORMATION_MESSAGE, mensaje, null, "");
        if (validarFecha(fecha.split("/"))) {
            fecha = parseFecha(fecha);
            if (!"".equals(fecha)) {
                List<Producto> lista = gp.reportePorDia(fecha);
                if (!lista.isEmpty()) {
                    String l = "";
                    for (int i = 0; i < lista.size(); i++) {
                        l += lista.get(i).toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(this, "REPORTE DE VENTAS " + fecha + "\n" + l+"        TOTAL:"+gp.totalPagos(lista), "BAKERY SHOP - Reporte de ventas por fecha", JOptionPane.INFORMATION_MESSAGE, mensaje);
                } else {
                    JOptionPane.showMessageDialog(this, "NO SE ENCONTRARON VENTAS DEL DIA: " + fecha, "BAKERY SHOP - Mensaje", JOptionPane.INFORMATION_MESSAGE, mensaje);

                }
            } else {
                JOptionPane.showMessageDialog(this, "FORMATO DE FECHA INVALIDO (DD/MM/AAAA)", "BAKERY SHOP - Mensaje", JOptionPane.INFORMATION_MESSAGE, mensaje);
            }
        } else {
             JOptionPane.showMessageDialog(this, "FORMATO DE FECHA INVALIDO (DD/MM/AAAA)", "BAKERY SHOP - Mensaje", JOptionPane.INFORMATION_MESSAGE, mensaje);
        }
    }

    public boolean validarFecha(String[] fecha) {
        try {
            int d = Integer.parseInt(fecha[0]),m = Integer.parseInt(fecha[1]),a = Integer.parseInt(fecha[2]);
            return (d >= 1 && d <= 31) && (m >= 1 && m <= 12);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String parseFecha(String f) {
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        String d = "";
        try {
            fecha = hourdateFormat.parse(f);
            d = hourdateFormat.format(fecha);
        } catch (ParseException ex) {
            System.out.println("ex" + ex);
        }
        return d;
    }

    private void actualizarTabla() {
        if (!gp.estaVacia()) {
            modeloTabla.setRowCount(0);
            for (int i = 0; i < gp.tamanio(); i++) {
                Producto aux = gp.getProducto(i);
                String[] d = {aux.getFechaC(),
                    aux.getNombre() + " " + aux.getMarca(),
                    String.valueOf(aux.getCosto()),
                    String.valueOf(aux.getCantidad()),
                    String.valueOf(aux.getTotal())};
                modeloTabla.addRow(d);
            }
        }
    }

}
