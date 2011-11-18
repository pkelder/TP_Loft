//CLASSE OK

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

import java.util.*;

abstract class Neuneu extends Element {

	/*** Attributes ***/

	public static int HOMME = 1;
	public static int FEMME = 0;

	protected String nom;
	protected int sexe;
	protected int energie;
	protected int depenseMarcher;
	protected int depenseSexe;
	protected int valeurEnergetique;
	protected int estMature; // Décrémente à chaque tour. Peut copuler à 0.
	protected int energieMax;
	protected int positionX;
	protected int positionY;

	protected Element cible;
	protected ArrayList<Nourriture> listeNourriture;
	protected Loft loft;

	/*** Constructors ***/

	protected Neuneu(Loft loft) {
		// Appelle setNom()
		this.setNom();

		// choix du sexe aléatoire
		int r = (int) Math.random();
		this.sexe = (r % 2);

	}

	public Neuneu(int EM, int DM, int DS, int VE, int eM,
			ArrayList<Nourriture> lB, Loft loft) {
		// en attendant de faire appelle au fichier de config

		this.energieMax = EM;
		this.depenseMarcher = DM;
		this.depenseSexe = DS;
		this.valeurEnergetique = VE;
		this.estMature = eM;
		this.listeNourriture = lB;
		this.loft = loft;

	}

	/*** Methods ***/

	public void setNom() {

		// choix aléatoire de 3 lettres pour former le nom
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String nom = "";
		for (int x = 0; x < 3; x++) {
			int i = (int) Math.floor(Math.random() * 52); // Si tu supprimes des
															// lettres tu
															// diminues ce nb
			nom += chars.charAt(i);
		}
		this.nom = nom;

	}

	public void marcher(int caseCibleX, int caseCibleY) {
		// vérification de l'énergie suffisante pour marcher
		if (this.energie > this.depenseMarcher) {
			// dépense son énergie pour marcher
			this.energie = this.energie - this.depenseMarcher;

			// voir si on rajoute un test de sortie de Loft ou si on considère
			// que caseCible est tjs dans le loft

			float ratio = caseCibleX / caseCibleY;

			Case currentCase = loft.grille[this.positionX][this.positionY];
			currentCase.neuneuSurCase.remove(this);

			if (ratio == 1) {

				this.positionX++;
				this.positionY++;
				Case nextCase = loft.grille[this.positionX][this.positionY];
				nextCase.neuneuSurCase.add(this);
			} else {
				if (ratio < 1) {
					this.positionY++;
					Case nextCase2 = loft.grille[this.positionX][this.positionY];
					nextCase2.neuneuSurCase.add(this);
				} else {

					this.positionX++;
					Case nextCase3 = loft.grille[this.positionX][this.positionY];
					nextCase3.neuneuSurCase.add(this);
				}

			}

		}

	}

	public void manger(Nourriture bouffe) {

		// test de la présence de ce type de bouffe dans la liste de ce qu'il
		// peut manger
		if (this.listeNourriture.contains(bouffe)) {
			// test de la conso maximale
			int EnergieManquante = energieMax - energie;
			int consoPossible = bouffe.consommation(bouffe.valeurEnergetique);

			Case currentCase = loft.grille[this.positionX][this.positionY];
			if (EnergieManquante < consoPossible) {
				// ajout de la valeur énergétique possible
				this.energie = energieMax;
				// enlever valeur sur case
				currentCase.bouffe.valeurEnergetique = currentCase.bouffe.valeurEnergetique
						- EnergieManquante;

			} else {
				this.energie = this.energie + consoPossible;
				// enlever valeur sur case: on supprime la présence de
				// nourriture sur cette case
				currentCase.bouffe = null;
			}
		}

	}

	public void copuler(Neuneu partenaire) {
		// test si assez d'énergie
		if ((this.energie > this.depenseSexe)
				&& (partenaire.energie > partenaire.depenseSexe)) {
			// perte de l'énergie de copulation
			this.energie = this.energie - this.depenseSexe;
			partenaire.energie = partenaire.energie - partenaire.depenseSexe;

			// vérification des sexes
			if (this.sexe != partenaire.sexe) {
				// création d'un nouveau Neuneu de type aléatoire
				int random = (int) Math.random();
				switch (random % 4) {
				case 1:
					Neuneu bebe = new Erratique(loft);
					break;
				case 2:
					Neuneu bebe2 = new Lapin(loft);
					break;
				case 3:
					Neuneu bebe3 = new Vorace(loft);
					break;
				case 4:
					Neuneu bebe4 = new Cannibale(loft);
					break;
				}
			}
		}
	}

	public abstract void action();

	public abstract int[] determineCaseCible();

	/***** Getters ******/

	public int getPositionX() {
		return this.positionX;
	}

	public int getPositionY() {
		return this.positionY;
	}

}
