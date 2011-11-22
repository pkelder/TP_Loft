/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Instancier la fenêtre une fois que le loft est instancié
 * Appeler createWindow() juste après
 * Appeler drawLoft() à chaque tour.
 * @author tagazok
 */
public class Fenetre extends JFrame {
    /* Attributes */

    private int largeurLoft;
    private int longueurLoft;
    private Loft loft;
    private JLabel[][] jLabelArray;

    public Fenetre(int largeur, int longueur, Loft loft) {
        this.largeurLoft = largeur;
        this.longueurLoft = longueur;
        this.loft = loft;
        this.jLabelArray = new JLabel[this.largeurLoft][this.longueurLoft];
    }

    public void createWindow() {
        // Titre de la fenêtre
        this.setTitle("Loft Story by 3K, Siau, Loulou");
        // Taille de la fenêtre en pixels
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // La fenêtre contient une grille
        this.setLayout(new GridLayout(this.largeurLoft, this.longueurLoft));

        // Intanciation des JLabel et on les met dans la grille de la fenêtre
        for (int i = 0; i < this.largeurLoft; i++) {
            for (int j = 0; j < this.longueurLoft; j++) {
                this.jLabelArray[i][j] = new JLabel();
                this.jLabelArray[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.jLabelArray[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                this.jLabelArray[i][j].setVerticalAlignment(SwingConstants.CENTER);
                this.jLabelArray[i][j].setForeground(Color.RED);
                this.getContentPane().add(this.jLabelArray[i][j]);
            }
        }

        this.setVisible(true);
    }

    public void drawLoft() {
        Iterator<Neuneu> iterator;
        Neuneu currNeuneu;
        String label = new String();

        for (int i = 0; i < this.largeurLoft; i++) {
            for (int j = 0; j < this.longueurLoft; j++) {
                iterator = this.loft.getGrille()[i][j].getNeuneus().iterator();

                // On teste le type des Neuneu sur la case pour déterminer la lettre correspondante
                label = "";
                while (iterator.hasNext()) {
                    currNeuneu = iterator.next();
                    if (currNeuneu.getClass().equals(Erratique.class)) {
                        label += "I";
                    } else if (currNeuneu.getClass().equals(Lapin.class)) {
                        label += "L";
                    } else if (currNeuneu.getClass().equals(Vorace.class)) {
                        label += "V";
                    } else if (currNeuneu.getClass().equals(Cannibale.class)) {
                        label += "C";
                    }
                }

                // On affiche le label sur la case
                this.jLabelArray[i][j].setText(label);
                this.jLabelArray[i][j].repaint();
            }
        }
    }
}
