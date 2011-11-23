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
 * Instancier la fen√™tre une fois que le loft est instanci√©
 * Appeler createWindow() juste apr√®s
 * Appeler drawLoft() √† chaque tour.
 * @author tagazok
 */
public class Fenetre extends JFrame {
    /* Attributes */

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
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
        // Titre de la fen√™tre
        this.setTitle("Loft Story by 3K, Siau, Loulou");
        // Taille de la fen√™tre en pixels
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // La fen√™tre contient une grille
        this.setLayout(new GridLayout(this.largeurLoft, this.longueurLoft));

        // Intanciation des JLabel et on les met dans la grille de la fen√™tre
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
        Iterator<Neuneu> iteratorNeuneu;
        Nourriture nourriture;
        Neuneu currNeuneu;
        String label = new String();

        for (int i = 0; i < this.largeurLoft; i++) {
            for (int j = 0; j < this.longueurLoft; j++) {
                iteratorNeuneu = this.loft.getGrille()[i][j].getNeuneus().iterator();

                // On teste le type des Neuneu sur la case pour d√©terminer la lettre correspondante
                label = "";
                while (iteratorNeuneu.hasNext()) {
                    currNeuneu = iteratorNeuneu.next();
                    if (currNeuneu.getClass().equals(Erratique.class)) {
                        label += "E";
                    } else if (currNeuneu.getClass().equals(Lapin.class)) {
                        label += "L";
                    } else if (currNeuneu.getClass().equals(Vorace.class)) {
                        label += "V";
                    } else if (currNeuneu.getClass().equals(Cannibale.class)) {
                        label += "C";
                    }
                }
                if (this.loft.getGrille()[i][j].aNeuneu() && this.loft.getGrille()[i][j].aNourriture()) {
                    label += " ";
                }
                if (this.loft.getGrille()[i][j].aNourriture()) {
                    nourriture = this.loft.getGrille()[i][j].getNourriture();
                    if (nourriture.getType().equals("banane")) {
                        label += "b";
                    } else if (nourriture.getType().equals("chocolat")) {
                        label += "c";
                    } else if (nourriture.getType().equals("alcool")) {
                        label += "a";
                    } else if (nourriture.getType().equals("fromage")) {
                        label += "f";
                    } else if (nourriture.getType().equals("gateau")) {
                        label += "g";
                    }
                }

                // On affiche le label sur la case
                this.jLabelArray[i][j].setText(label);
                this.jLabelArray[i][j].repaint();
            }
        }
    }
}
