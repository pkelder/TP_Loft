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
    protected static ArrayList<Neuneu> neuneuDispo;
    protected static int periodeTour;  // Timer qui lance chaque tour, en ms
    protected int nbNeuneuTotal;
    protected int nbAjoutMaxNeuneuParTour = 2;
    protected int nbAjoutMaxNouritureParTour = 5;

    public Loft() {
        // Instanciation de la grille
        this.grille = new Case[Loft.largeurLoftX][Loft.longueurLoftY];
        // Instanciation des cases de la grille
        for (int i = 0; i < Loft.largeurLoftX; i++) {
            for (int j = 0; j < Loft.longueurLoftY; j++) {
                this.grille[i][j] = new Case(i, j);
            }
        }
        // Remplissage de la liste de Neuneu dispo (codé en dur car la liste ne changera pas)
        Loft.neuneuDispo = new ArrayList<Neuneu>();
        Loft.neuneuDispo.add(new Erratique(this));
        Loft.neuneuDispo.add(new Lapin(this));
        Loft.neuneuDispo.add(new Vorace(this));
        Loft.neuneuDispo.add(new Cannibale(this));
    }

    public void tour() {

        // Un balayage de la grille pour marcher()
        for (int i = 0; i < Loft.largeurLoftX; i++) {
            for (int j = 0; j < Loft.longueurLoftY; j++) {
                Case currentCase = this.grille[i][j];

                if (currentCase.aNeuneu()) {
                    for (Neuneu neuneu : currentCase.getNeuneus()) {
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
                    for (Neuneu neuneu : currentCase.getNeuneus()) {
                        if (neuneu.getEnergie() == 0) {
                            currentCase.supprimerNeuneu(neuneu);
                        }
                    }
                }

            }
        }

        // Random pour le nombre de bouffe et de neuneu à rajouter
        int nbBouffe = (int) (Math.random() * this.nbAjoutMaxNouritureParTour);
        int nbNeuneu = (int) (Math.random() * this.nbAjoutMaxNeuneuParTour);

        for (int i = 0; i < nbBouffe; i++) {
            this.ajoutBouffe();
        }

        for (int i = 0; i < nbNeuneu; i++) {
            this.ajoutNeuneu();
        }


    }

    public void ajoutBouffe() {
        // random type 
        int typeRandom = (int) (Math.random() * Loft.bouffeDispo.size());
        Nourriture bouffe = Loft.bouffeDispo.get(typeRandom);

        //random position + vérifier case libre
        int[] position = this.randomPosition(bouffe);

        // ajouter Bouffe dans la case sélectionnée
        this.grille[position[0]][position[1]].ajouterNourriture(bouffe);

    }

    public void ajoutNeuneu() {
        // Choix du type de neuneu au hasard
        int typeRandom = (int) (Math.random() * Loft.neuneuDispo.size());
        Neuneu neuneu = Loft.neuneuDispo.get(typeRandom);
        
        // Random position
        int[] position = this.randomPosition(neuneu);
        
        // Ajoute le Neuneu à la case
        this.grille[position[0]][position[1]].ajouterNeuneu(neuneu);
    }
    
    private int[] randomPosition(Element element) {
        int[] result = new int[2];
        boolean libre = false;
        int x = 0;
        int y = 0;

        while (!libre) {
            x = (int) (Math.random() * Loft.largeurLoftX);
            y = (int) (Math.random() * Loft.longueurLoftY);

            if (element.getClass().equals(Nourriture.class) && !this.grille[x][y].aNourriture()) {
                libre = true;
            }
            else if (element.getClass().equals(Neuneu.class) && !this.grille[x][y].aNeuneu()) {
                libre = true;
            }
        }
        
        result[0] = x;
        result[1] = y;
        
        return result;
    }

    public int getNbNeuneuTotal() {
        return this.nbNeuneuTotal;
    }

    public Case[][] getGrille() {
        return this.grille;
    }
}
