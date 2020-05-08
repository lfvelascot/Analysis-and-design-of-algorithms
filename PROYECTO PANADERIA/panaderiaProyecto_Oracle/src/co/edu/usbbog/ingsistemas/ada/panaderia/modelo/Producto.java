/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.ingsistemas.ada.panaderia.modelo;

/**
 *
 * @author COMPURED
 */
public class Producto extends PAbstract{
    String fechaC,marca;
    double total;

    /**
     *
     * @param nombre
     * @param fechaVencimiento
     * @param costo
     * @param cantidad
     * @param marca
     * @param fechaC
     */
    public Producto(String nombre, String fechaVencimiento, double costo, int cantidad, String marca,String fechaC,double total) {
        super(nombre, fechaVencimiento, costo, cantidad);
        this.fechaC = fechaC;
        this.marca = marca;
        this.total = total;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
    @Override
    public String toString() {
        return fechaC+" - "+nombre+" "+marca+" - $"+costo+" x "+cantidad+" = "+total;
    }

    public String impresionConsola() {
                return "Fecha de Venta: " + fechaC + ""
                + "\n- Producto: " + nombre
                + "\n- Marca: " + marca + ""
                + "\n- Fecha Vencimiento: " + fechaVencimiento
                + "\n- Valor Unidad: $"+costo+""
                + "\n- Cantidad: "+cantidad+"\n"
                + "TOTAL = $"+total;
    }

}
