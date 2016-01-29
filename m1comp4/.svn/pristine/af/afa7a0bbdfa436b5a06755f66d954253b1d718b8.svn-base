package fr.univfcomte.comp4.guid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aymeric on 01/12/2015.
 */
public class MenuCliqueDroit extends JPopupMenu {

    private JMenuItem ajoutPointArret;
    private JMenuItem supprimPointArrets;
    private JFrameMain frame;

    public MenuCliqueDroit(JFrameMain frame) {
        this.frame = frame;

        this.ajoutPointArret = new JMenuItem("Ajouter un point d'arrêt");
        this.ajoutPointArret.setFocusable(true);
        this.ajoutPointArret.setEnabled(true);
        this.ajoutPointArret.addActionListener(new AjoutPointArretActionListener());

        this.supprimPointArrets = new JMenuItem("Supprimer les points d'arrêts");
        this.supprimPointArrets.setEnabled(true);
        this.supprimPointArrets.setFocusable(true);
        this.supprimPointArrets.addActionListener(new SupprimPointArretActionListener());

        add(this.ajoutPointArret);
        add(this.supprimPointArrets);
    }

    public class AjoutPointArretActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.ajouterPointArret();
            setVisible(false);
        }
    }

    public class SupprimPointArretActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.supprimerPointArrets();
            setVisible(false);
        }
    }
}
