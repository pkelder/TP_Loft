/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author tagazok
 */
public abstract class Neuneu extends Element {

    public static int HOMME = 1;
    public static int FEMME = 0;
    protected int sexe;
    protected int energie;
    protected static int depenseMarcher;
    protected static int depenseSexe;
    protected int estMature;							// Décrémente à chaque tour. Peut copuler à 0.
    protected static int energieMax;
    protected int posX;
    protected int posY;
    protected Element cible;
    protected ArrayList<Nourriture> listeNourriture;
    protected Loft loft;

    protected Neuneu(Loft loft) {
        // Appelle setNom()
        // Sexe aléatoire 
    }

    public void marcher() {
        // Décrémente estMature
        this.estMature--;

        // Case où se déplacer
        int[] caseDeplacement = determineCaseDeplacement();

        // Déplacement
        this.loft.getGrille()[this.posX][this.posY].supprimerNeuneu(this);
        this.loft.getGrille()[caseDeplacement[0]][caseDeplacement[1]].ajouterNeuneu(this);
        this.posX = caseDeplacement[0];
        this.posY = caseDeplacement[1];
    }

    /*
     * Détermine la case où le Neuneu doit se déplacer
     * La case doit être disponible (moins de 2 neuneus), et à la plus courte distance de la cible
     */
    private int[] determineCaseDeplacement() {
        int absTest;
        int ordTest;
        float distancePlusCourte = Float.MAX_VALUE;
        int deplacementPlusCourt = -1;
        int[] result = new int[2];

        // Liste des déplacements disponibles
        LinkedList<Integer> deplacementX = new LinkedList<Integer>();
        LinkedList<Integer> deplacementY = new LinkedList<Integer>();
        deplacementX.add(1);
        deplacementY.add(0);
        deplacementX.add(1);
        deplacementY.add(-1);
        deplacementX.add(0);
        deplacementY.add(-1);
        deplacementX.add(-1);
        deplacementY.add(-1);
        deplacementX.add(-1);
        deplacementY.add(0);
        deplacementX.add(-1);
        deplacementY.add(0);
        deplacementX.add(-1);
        deplacementY.add(1);
        deplacementX.add(0);
        deplacementY.add(1);

        // Enlève des déplacements dispo les cases occupées
        for (int i = 0; i < 8; i++) {
            absTest = this.posX + deplacementX.get(i);
            ordTest = this.posY + deplacementY.get(i);

            if (this.loft.getGrille()[absTest][ordTest].fullNeuneu()) {
                deplacementX.remove(i);
                deplacementY.remove(i);
            }
        }

        // Appelle DeterminerCible() pour avoir les coordonnées de l'objectif
        int[] coordCible = determineCaseCible();

        // On calcule la distance la plus courte entre les cases dispo restantes et la cible
        int length = deplacementX.size();
        float distanceTest;
        for (int i = 0; i < length; i++) {
            absTest = this.posX + deplacementX.get(i);
            ordTest = this.posY + deplacementY.get(i);
            distanceTest = calculDistance(absTest, ordTest, coordCible[0], coordCible[1]);

            if (distanceTest < distancePlusCourte) {
                distancePlusCourte = distanceTest;
                deplacementPlusCourt = i;
            }
        }

        // On retourne les coordonnées de la case libre dont la distance est la plus courte avec la cible
        result[0] = this.posX + deplacementX.get(deplacementPlusCourt);
        result[1] = this.posY + deplacementY.get(deplacementPlusCourt);

        return result;
    }

    private float calculDistance(int originX, int originY, int cibleX, int cibleY) {
        return (float) Math.sqrt((originY - cibleY) * (originY - cibleY) + (originX - cibleX) * (originX - cibleX));
    }

    public void manger(Element element) {
        // EnergieElementMangé=0
        // Test si Neuneu est mangé : énergieMangeur=max
        // Test si Nourriture : énergieMangeur<=max
    }

    public boolean copuler(Neuneu partenaire) {
        // Diminue l'énergie des partenaires.
        // true si sexe différent, flase si même sexe
        return false;
    }

    public abstract void action();

    public abstract int[] determineCaseCible();

    public int getEnergie() {
        return this.energie;
    }

    public void setEnergie(int e) {
        this.energie = e;
    }

    public void setPosX(int x) {
        this.posX = x;
    }

    public void setPosY(int y) {
        this.posY = y;
    }
}
