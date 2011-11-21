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
    }

    public int consommation() {
        // Renvoie la quantité de nourriture maxi possible
        // puis met l'énergie à zéro
        return 0;
    }

    public int getEnergie() {
        return 0;
    }

    public void setEnergie() {
    }
}
