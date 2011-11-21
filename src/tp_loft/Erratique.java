/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

/**
 *
 * @author tagazok
 */
public class Erratique extends Neuneu {

    public Erratique(Loft loft) {
        super(loft);
        // Energie = EnergieMax
        // EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
    }

    public void action() {
        // S'il est tout seul : il bouffe
        // S'il est pas tout seul, il baise puis il bouffe
    }

    public int[] determineCaseCible() {
        return new int[1];
    }
}
