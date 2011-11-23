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
public class Case {

    protected ArrayList<Neuneu> neuneuSurCase;
    protected Nourriture bouffe;
    protected int X;
    protected int Y;

    public Case() {
        this.neuneuSurCase = new ArrayList<Neuneu>();
        this.bouffe = null;
    }

    public Case(int x, int y) {
        this.X = x;
        this.Y = y;
        this.neuneuSurCase = new ArrayList<Neuneu>();
        this.bouffe = null;
    }

    public boolean ajouterNeuneu(Neuneu neuneu) {
        boolean isAdded;
        if (this.neuneuSurCase.size() < 2) {
            this.neuneuSurCase.add(neuneu);
            isAdded = true;
        } else {
            isAdded = false;
        }
        return isAdded;
    }

    public void supprimerNeuneu(Neuneu neuneu) {
        this.neuneuSurCase.remove(neuneu);
    }

    public void ajouterNourriture(Nourriture nourriture) {
        if (this.bouffe == null) {
            this.bouffe = nourriture;
        }
    }

    public void supprimerNourriture() {
        this.bouffe = null;
    }

    public boolean aNourriture() {
        return this.bouffe != null;
    }

    public boolean aNeuneu() {
        return !this.neuneuSurCase.isEmpty();
    }

    public boolean fullNeuneu() {
        return (this.neuneuSurCase.size() == 2) ? true : false;
    }

    public void action() {
        // Appelle les action de la liste de Neuneu.
        // S'il y a deux Neuneu : aléatoire pour déterminer lequel fait l'action
        if (this.aNeuneu()) {
            if (this.fullNeuneu()) {
                int random = (int) (Math.random() * 2);
                this.neuneuSurCase.get(random).action();
            } else {
                this.neuneuSurCase.get(0).action();
            }
        }
    }

    public ArrayList<Neuneu> getNeuneus() {
        return this.neuneuSurCase;
    }

    public Nourriture getNourriture() {
        return this.bouffe;
    }

    public int getPosX() {
        return this.X;
    }

    public int getPosY() {
        return this.Y;
    }
}
