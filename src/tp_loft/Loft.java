/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

import java.util.ArrayList;

/**
 *
 * @author tagazok
 */
public class Loft {

    protected Case[][] grille;
    protected static int largeurLoftX;
    protected static int longueurLoftY;
    protected ArrayList<Nourriture> bouffeDispo;
    protected static int periodeTour;  // Timer qui lance chaque tour
    protected int nbNeuneuTotal;

    public Loft() {
        // getConf() : longueur, largeur, listeBouffe, périodePrimeTime
    }

    public boolean tour() {
        // Un balayage de la grille pour marcher(), un autre pour action(), 
        // un autre pour nettoyer les trucs à zéro d'énergie
        // Random pour le nombre de bouffe et de neuneu à rajouter, et random de leur position
        // Retourne true si nbNeuneuTotal>1 ou false si nbNeuneuTotal<=1
        return false;
    }

    public void ajoutBouffe() {
        // Choix quantité + type + random position
        // Vérifier case libre
        // utiliser ajoutElement()
    }

    public void ajoutElement(Element element, int posX, int posY) {
    }
}
