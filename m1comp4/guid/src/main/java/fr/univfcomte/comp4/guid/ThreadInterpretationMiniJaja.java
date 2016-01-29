package fr.univfcomte.comp4.guid;

import fr.univfcomte.comp4.analyseur.MiniJajaException;
import fr.univfcomte.comp4.interpreteur_MiniJaja.ErreurListener;
import fr.univfcomte.comp4.analyseur.SimpleNode;
import fr.univfcomte.comp4.interpreteur_MiniJaja.MiniJajaInterpreteurVisitor;
import fr.univfcomte.comp4.memoire_MiniJaja.MemoireMiniJaja;
import fr.univfcomte.comp4.table_hachage.TableSymbole;

import java.io.ByteArrayInputStream;

/**
 * Created by aymeric on 17/11/2015.
 */
public class ThreadInterpretationMiniJaja extends Thread {

    private SimpleNode noeud;
    private MiniJajaInterpreteurVisitor visiteur;
    private MemoireMiniJaja memoire;
    private TableSymbole tableSymbole;
    private ErreurListener ecouteurErreur;

    public ThreadInterpretationMiniJaja(ErreurListener ecouteur, MiniJajaInterpreteurVisitor visiteur) {
        this.visiteur = visiteur;
        this.ecouteurErreur = ecouteur;
    }

    public void run() {

            ///////////////////////////
            //INTERPRETATION MINIJAJA//
            ///////////////////////////

            this.memoire = new MemoireMiniJaja(this.tableSymbole);
            try {
                this.noeud.jjtAccept(this.visiteur, memoire);
            } catch (MiniJajaException e) {
            	this.ecouteurErreur.onErreur("\n" + e.getMessage()+"\n");
            }
    }

    public void setNoeud(SimpleNode n) {
        this.noeud = n;
    }

    public void setTableSymbole(TableSymbole ts) { this.tableSymbole = ts; }

}
