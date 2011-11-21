/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

/**
 *
 * @author tagazok
 */
public abstract class Neuneuphile extends Neuneu {

    public Neuneuphile(Loft loft) {
        super(loft);
        // Energie = EnergieMax
        // EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
    }

    public int[] determineCaseCible() {
        // Détermine case cible pour Lapin et Cannibale
        // Démarche : si il y a de la nourriture au plus près, va vers la nourriture,
        // si il y a un Neuneu au plus près, va vers le Neuneu.
        return new int[1];
    }
}
