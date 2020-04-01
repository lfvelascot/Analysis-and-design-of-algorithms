
package modelo;

public class Pais implements Comparable<Pais> {
    
    private String nomPais;
    private Integer numContagiados;
    private Integer numMuertos;

    public Pais(String nomPais, Integer numContagiados, Integer numMuertos) {
        this.nomPais = nomPais;
        this.numContagiados = numContagiados;
        this.numMuertos = numMuertos;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public Integer getNumContagiados() {
        return numContagiados;
    }

    public void setNumContagiados(Integer numContagiados) {
        this.numContagiados = numContagiados;
    }

    public Integer getNumMuertos() {
        return numMuertos;
    }

    public void setNumMuertos(Integer numMuertos) {
        this.numMuertos = numMuertos;
    }

    @Override
    public String toString() {
        return nomPais+"-"+numContagiados+"-"+numMuertos+"";
    }
    
    public String impresionConsola(){
        return nomPais+"\n - Num. Contagiados: "+numContagiados+"\n - Num. Muertos: "+numMuertos;
    }

    @Override
    public int compareTo(Pais t) {
        if (numContagiados > t.numContagiados){
            return -1;
        } else if (numContagiados < t.numContagiados){
            return 1;
        } else {
            return 0;
        }
    }
    
    public int compareToMuertos(Pais t) {
        if (numMuertos > t.numMuertos){
            return -1;
        } else if (numMuertos < t.numMuertos){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
    
    
    
    
    
}
