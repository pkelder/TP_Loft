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
    protected static ArrayList<Nourriture> bouffeDispo;
    protected static int periodeTour;  // Timer qui lance chaque tour, en ms
    protected int nbNeuneuTotal;

    public Loft() {
        // Instanciation de la grille
        this.grille = new Case[Loft.largeurLoftX][Loft.longueurLoftY];
        // Instanciation des cases de la grille
        for (int i = 0; i < Loft.largeurLoftX; i++) {
            for (int j = 0; j < Loft.longueurLoftY; j++) {
                this.grille[i][j] = new Case(i, j);
            }
        }
    }

    public void tour() {

        // Un balayage de la grille pour marcher()
        for (int i = 0; i < Loft.largeurLoftX; i++) {
            for (int j = 0; j < Loft.longueurLoftY; j++) {
                Case currentCase = this.grille[i][j];

                if (currentCase.aNeuneu()) {
                    for (Neuneu neuneu : currentCase.neuneuSurCase) {
                        neuneu.marcher();
                    }
                }
            }
        }

        // un autre balayage pour action(), 
        for (int i = 0; i < Loft.largeurLoftX; i++) {
            for (int j = 0; j < Loft.longueurLoftY; j++) {
                Case currentCase = this.grille[i][j];
                currentCase.action();
            }
        }

        // un autre pour nettoyer les neuneus à zéro d'énergie (la bouffe est supprimée dans manger() )
        for (int i = 0; i < Loft.largeurLoftX; i++) {
            for (int j = 0; j < Loft.longueurLoftY; j++) {
                Case currentCase = this.grille[i][j];

                if (currentCase.aNeuneu()) {
                    for (Neuneu neuneu : currentCase.neuneuSurCase) {
                        if (neuneu.getEnergie() == 0) {
                            currentCase.supprimerNeuneu(neuneu);
                        }
                    }
                }

            }
        }

        // Random pour le nombre de bouffe et de neuneu à rajouter

        int nbBouffe = (int) (Math.random() * 5);
        int nbNeuneu = (int) (Math.random() * 2);

        for (int i = 0; i < nbBouffe; i++) {
            this.ajoutBouffe();
        }

        if (nbNeuneu == 1) {
            this.ajoutNeuneu();
        }


    }

    public void ajoutBouffe() {
        // random type 
        int typeRandom = (int) (Math.random() * Loft.bouffeDispo.size());
        Nourriture Bouffe = Loft.bouffeDispo.get(typeRandom);

        //random position + vérifier case libre
        boolean libre = false;
        int x = 0;
        int y = 0;

        while (!libre) {

            x = (int) (Math.random() * Loft.largeurLoftX);
            y = (int) (Math.random() * Loft.longueurLoftY);

            if (!this.grille[x][y].aNourriture()) {
                libre = true;
            }

        }

        // ajouter Bouffe dans la case sélectionnée
        this.grille[x][y].ajouterNourriture(Bouffe);

    }

    public void ajoutNeuneu() {
        // Choix du type de neuneu au hasard + random position
        // Utiliser ajoutNeuneu() de la case
    }

    public int getNbNeuneuTotal() {
        return this.nbNeuneuTotal;
    }

    public Case[][] getGrille() {
        return this.grille;
    }
}
