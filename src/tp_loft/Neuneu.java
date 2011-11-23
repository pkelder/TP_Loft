/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

import java.util.ArrayList;
import java.util.Iterator;
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
    protected int estMature; // Décrémente à chaque tour. Peut copuler à 0.
    protected static int energieMax;
    protected int posX;
    protected int posY;
    protected Element cible;
    protected ArrayList<Nourriture> listeNourriture;
    protected Loft loft;

    protected Neuneu(Loft loft) {
        // Sexe aléatoire
    }

    protected Neuneu() {
    }

    protected Neuneu(int posX, int posY, Loft loft) {
        this.posX = posX;
        this.posY = posY;
        this.loft = loft;
    }

    public void marcher() {
        boolean hasMoved = false;
        int[] caseDeplacement = new int[2];

        // Décrémente estMature
        this.estMature--;

        // Recherche une case jusqu'à en trouver une de libre
        while (!hasMoved) {
            // Case où se déplacer
            caseDeplacement = determineCaseDeplacement();

            // Déplacement
            this.loft.getGrille()[this.posX][this.posY].supprimerNeuneu(this);
            hasMoved = this.loft.getGrille()[caseDeplacement[0]][caseDeplacement[1]].ajouterNeuneu(this);
        }
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
        deplacementY.add(1);
        deplacementX.add(0);
        deplacementY.add(1);
        deplacementX.add(1);
        deplacementY.add(1);
        deplacementX.add(0);
        deplacementY.add(0);

        // Enlève des déplacements dispo les cases occupées
        Iterator<Integer> i = deplacementX.iterator();
        Iterator<Integer> j = deplacementY.iterator();
        while (i.hasNext()) {
            absTest = this.posX + i.next();
            ordTest = this.posY + j.next();

            // Si la case est en dehors de la grille, on l'enlève
            if (absTest < 0 || absTest >= Loft.largeurLoftX || ordTest < 0 || ordTest >= Loft.longueurLoftY) {
                i.remove();
                j.remove();
            } // Si elle est dans la grille mais pleine, on l'enlève
            else if (this.loft.getGrille()[absTest][ordTest].fullNeuneu() && absTest != this.posX && ordTest != this.posY) {
                i.remove();
                j.remove();
            }
        }

        // Appelle DeterminerCible() pour avoir les coordonnées de l'objectif
        int[] coordCible = determineCaseCible(this.loft);
        // On calcule la distance la plus courte entre les cases dispo restantes et la cible
        int length = deplacementX.size();
        float distanceTest;
        for (int k = 0; k < length; k++) {
            absTest = this.posX + deplacementX.get(k);
            ordTest = this.posY + deplacementY.get(k);
            distanceTest = calculDistance(absTest, ordTest, coordCible[0], coordCible[1]);

            if (distanceTest < distancePlusCourte) {
                distancePlusCourte = distanceTest;
                deplacementPlusCourt = k;
            }
        }

        // On retourne les coordonnées de la case libre dont la distance est la plus courte avec la cible
        int caselibreX = this.posX + deplacementX.get(deplacementPlusCourt);
        int caselibreY = this.posY + deplacementY.get(deplacementPlusCourt);

        result[0] = caselibreX;
        result[1] = caselibreY;

        return result;
    }

    public float calculDistance(int originX, int originY, int cibleX, int cibleY) {
        return (float) Math.sqrt((originY - cibleY) * (originY - cibleY) + (originX - cibleX) * (originX - cibleX));
    }

    public void manger(Element element) {

        if (element.getClass().equals(Nourriture.class)) {

            int conso = ((Nourriture) element).consommation();
            if ((Neuneu.energieMax - this.energie) < conso) {
                this.energie = Neuneu.energieMax;
            } else {
                this.energie += conso;
            }
        } else { // on a un Neuneu: ne pas oublier d'inclure le test: peut manger
            ((Neuneu) element).energie = 0;
            this.energie = Neuneu.energieMax;
        }
    }

    public boolean copuler(Neuneu partenaire) {

        if ((this.estMature == 0) && (partenaire.estMature == 0)) {
            // Diminue l'énergie des partenaires.
            this.energie = Math.max(0, Neuneu.depenseSexe);
            partenaire.energie = Math.max(0, Neuneu.depenseSexe);

            // true si sexe différent, flase si même sexe

            return (this.sexe != partenaire.sexe);
        } else {
            return false;
        }
    }

    public abstract void action();

    public abstract int[] determineCaseCible(Loft loft);

    public int getEnergie() {
        return this.energie;
    }

    public void setEnergie(int E) {
        this.energie = E;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosX(int x) {
        this.posX = x;
    }

    public void setPosY(int y) {
        this.posY = y;
    }
}
