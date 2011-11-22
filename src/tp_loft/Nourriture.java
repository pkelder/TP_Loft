/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

/**
 *
 * @author tagazok
 */
public class Nourriture extends Element {

    protected String type;
    protected int valeurEnergetique;

    public Nourriture(String type, int valeurEnergetique) {
    	this.type=type;
    	this.valeurEnergetique=valeurEnergetique;
    }

    public int consommation() {
        // Renvoie la quantité de nourriture maxi possible
        // puis met l'énergie à zéro
        int tmp=this.valeurEnergetique;
        this.valeurEnergetique=0;
        return tmp;
    }

    public String getType() {
        return this.type;
    }
    
    public int getEnergie() {
        return this.valeurEnergetique;
    }

    public void setEnergie(int E) {
    	this.valeurEnergetique=E;
    }
}
