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
        // Appelle DeterminerCible() pour avoir les coordonnées
        // Déplace le Neuneu vers les coordonnées, mais vérifie qu'il ne marche pas sur une case avec 2 Neuneu
        //		Si la case est pas dispo, prend une des deux cases à coté
        // Déplacement : S'enlever de la Case actuelle (celle des coordonnées en attribut du Neuneu)
        //				Se mettre dans la Case correspondant aux nouvelles coordonnées
        //				Mettre à jour les nouvelles coordonnées en attribut du Neuneu
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
        return this.energie ;
    }

    public void setEnergie(int E) {
        this.energie = E;        
    }
    
    public void setPosX(int x) {
        this.posX = x;
    }
    
    public void setPosY(int y) {
        this.posY = y;
    }
}
