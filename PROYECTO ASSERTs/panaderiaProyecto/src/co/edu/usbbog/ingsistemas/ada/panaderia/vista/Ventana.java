/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.ingsistemas.ada.panaderia.vista;

import co.edu.usbbog.ingsistemas.ada.panaderia.controlador.logica.Gestion_Producto;
import java.awt.PopupMenu;
import javax.swing.ImageIcon;

/**
 *
 * @author COMPURED
 */
public class Ventana extends javax.swing.JFrame {

    PanelReportes pr;
    PanelGestion pg;
    PanelPrincipal pp;
    Gestion_Producto gp;
    Ventana v;

    public Ventana() {
        this.setTitle("BAKERY STORE"); // Titulo del frame
        this.gp = new Gestion_Producto();
        this.pp = new PanelPrincipal(this);
        this.pg = new PanelGestion(this);
        this.pr = new PanelReportes(this);
        this.setIconImage(new ImageIcon(getClass().getResource("/co/edu/usbbog/ingsistemas/ada/panaderia/vista/imagenes/logo.png")).getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(740, 500);
        this.add(this.getPp());
        this.setLocationRelativeTo(null); // Posicion de nuestro frame en la panatalla
        this.pack(); // Adecuar el tamaño de nuestro frame al de los elementos que contiene
        this.setVisible(true); // Visibilidad del frame        
        //initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    public PanelPrincipal getPp() {
        return this.pp;
    }

    public PanelReportes getPr() {
        return this.pr;
    }

    public PanelGestion getPg() {
        return this.pg;
    }

    public Gestion_Producto getGp() {
        return this.gp;
    }
    
    public void cambiarTitulo(String titulo){
        this.setTitle("BAKERY STORE "+titulo); // Titulo del frame
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
