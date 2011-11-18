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
	/* Attributes */
	protected Case[][] grille;
	protected int largeurLoftX;
	protected int longueurLoftY;
	protected ArrayList<Nourriture> bouffeDispo;
	protected int periodePrimeTime;
	protected int tempsJusquaPrimeTime;

	/* Constructors */
	public Loft() {
		// getConf() : longueur, largeur, listeBouffe, p√©riodePrimeTime
	}

	public Loft(int largeur, int longueur) {
		this.largeurLoftX = largeur;
		this.longueurLoftY = longueur;
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				this.grille[i][j] = new Case();
			}
		}
	}

	/* Methods */
	public void tour() {
		// J'ai oublié ce que fais PrimeTime, à rajouter donc.

		// 1er parcours des cases
		for (int i = 0; i < this.largeurLoftX; i++) {
			for (int j = 0; j < this.longueurLoftY; j++) {
				Case currentCase = this.grille[i][j];

				// Pour chaque Neuneu: détermination d'une cible puis un pas
				// vers elle
				if (!currentCase.neuneuSurCase.isEmpty()) {
					for (Neuneu neuneu : currentCase.neuneuSurCase) {
						int[] cible = neuneu.determineCaseCible();
						neuneu.marcher(cible[0], cible[1]);
					}
				}
			}
		}

		// Second parcours des cases
		for (int i = 0; i < this.largeurLoftX; i++) {
			for (int j = 0; j < this.longueurLoftY; j++) {
				Case currentCase = this.grille[i][j];
				// Pour chaque Neuneu: action
				if (!currentCase.neuneuSurCase.isEmpty()) {
					for (Neuneu neuneu : currentCase.neuneuSurCase) {
						neuneu.action();
					}
				}

			}
		}

		// Dernier parcours: suppression des Neuneu sans vie
		for (int i = 0; i < this.largeurLoftX; i++) {
			for (int j = 0; j < this.longueurLoftY; j++) {
				Case currentCase = this.grille[i][j];
				if (!currentCase.neuneuSurCase.isEmpty()) {
					for (Neuneu neuneu : currentCase.neuneuSurCase) {
						if (neuneu.energie == 0) {
							currentCase.supprimerNeuneu(neuneu);
						}
					}
				}
			}
		}

		// Ajout de nourriture et/ou Neuneu aléatoirement
		// si le nombre obtenu est congru à 0 modulo 3: on rajoute de la bouffe
		// si le nombre obtenu est congru à 1 modulo 3: on rajoute un neuneu
		// si le nombre obtenu est congru à 2 modulo 3: rien ne se passe
		int random = (int) Math.random();

		if (random % 3 == 0) {
			// à modifier avec fichier config: choisir le type de nourriture
			// aléatoirement

			Nourriture newbouffe = new Nourriture("Fraises", 400);
			this.ajoutBouffe(newbouffe);
		} else {
			if (random % 3 == 1) {
				int EM = (int) Math.random();
				Neuneu newNeuneu = new Neuneu(EM, (int) Math.random() % EM,
						(int) Math.random() % EM, (int) Math.random() % EM, 2,
						new ArrayList<Nourriture>(), this);
			}
		}

	}

	public void ajoutBouffe(Nourriture bouffe) {
		// où fait-on le random choix bouffe+quantité?
		int posX = (int) Math.random() % this.largeurLoftX;
		int posY = (int) Math.random() % this.longueurLoftY;

		Case currentCase = this.grille[posX][posY];
		currentCase.ajoutBouffe(bouffe);

	}

	public void ajoutNeuneu(Neuneu neuneu) {

		int posX = (int) Math.random() % this.largeurLoftX;
		int posY = (int) Math.random() % this.longueurLoftY;

		Case currentCase = this.grille[posX][posY];
		currentCase.ajoutNeuneu(neuneu);

	}

	public void primeTime() {
		// Teste s'il y a primetime
		// Ajoute nourriture + neuneus
	}
}
