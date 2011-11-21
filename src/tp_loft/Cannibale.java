/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

/**
 *
 * @author tagazok
 */
public class Cannibale extends Neuneuphile {

    public Cannibale(Loft loft) {
        super(loft);
        // Energie = EnergieMax
        // EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
    }

    public void action() {
        // Si tout seul : bouffe
        // S'il est avec un Neuneu : bouffe le Neuneu
    }
}
