/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

import java.util.ArrayList;

/**
 *
 * @author tagazok
 */
public class Loft {
    /*   Attributes   */

    protected Case[][] grille;
    protected int largeurLoftX;
    protected int longueurLoftY;
    protected ArrayList<Nourriture> bouffeDispo;
    protected int periodePrimeTime;
    protected int tempsJusquaPrimeTime;

    /*   Constructors  */
    public Loft() {
        // getConf() : longueur, largeur, listeBouffe, périodePrimeTime
    }

    /*   Methods   */
    public void tour() {
        // Déplacement + Action + PrimeTime
    }

    public void ajoutBouffe() {
        // Choix quantité + type + random position
        // Vérifier case libre
        // utiliser ajoutElement()
    }

    public void ajoutElement(Element element, int posX, int posY) {
    }

    public void primeTime() {
        // Teste s'il y a primetime
        // Ajoute nourriture + neuneus
    }
}
