package fr.univfcomte.comp4.guid;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Aymeric on 01/12/2015.
 */
public class CliqueDroitListener extends MouseAdapter {

    private MenuCliqueDroit menu;

    public CliqueDroitListener(JFrameMain frame) {
        super();
        this.menu = new MenuCliqueDroit(frame);
    }

    public void mousePressed(MouseEvent e) {

        if(SwingUtilities.isRightMouseButton(e)) {
            this.menu.setLocation(e.getXOnScreen(), e.getYOnScreen());
            this.menu.setVisible(true);
        }
        else this.menu.setVisible(false);
    }
}
