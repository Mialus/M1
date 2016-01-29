/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univfcomte.comp4.guid;

import fr.univfcomte.comp4.analyseur.MiniJaja;
import fr.univfcomte.comp4.analyseur.SimpleNode;
import fr.univfcomte.comp4.analyseur.MiniJajaException;
import fr.univfcomte.comp4.analyseur.ParseException;

import fr.univfcomte.comp4.analyseur_JajaCode.*;

import fr.univfcomte.comp4.compilateur.MiniJajaCompilateurVisitor;
import fr.univfcomte.comp4.compilateur.Paire;

import fr.univfcomte.comp4.controle_type.ControleTypeVisitor;
import fr.univfcomte.comp4.controle_type.DataControleType;

import fr.univfcomte.comp4.interpreteur_MiniJaja.ErreurListener;
import fr.univfcomte.comp4.interpreteur_MiniJaja.MiniJajaInterpreteurVisitor;

import fr.univfcomte.comp4.memoire.Memoire;
import fr.univfcomte.comp4.memoire.MemoireListener;
import fr.univfcomte.comp4.memoire_MiniJaja.*;

import fr.univfcomte.comp4.interpreteur_JajaCode.JajaCodeInterpreteurVisitor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;

import java.awt.Color;
import java.io.*;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Aymeric
 */
public class JFrameMain extends javax.swing.JFrame implements MemoireListener,
        MemoireMiniJajaListener, ErreurListener {

    // GRAPHIQUE
    private String miniJajaText;
    private String miniJajaPath;
    private boolean pasapas;
    private TextLineNumber miniJajaTextLines;

    //Surligner ligne
    DefaultHighlighter highlighterMiniJaja;
    DefaultHighlighter.DefaultHighlightPainter painterMiniJaja;
    
    DefaultHighlighter highlighterJajaCode;
    DefaultHighlighter.DefaultHighlightPainter painterJajaCode;
    
    int startHlMiniJaja=0;
    int endHlMiniJaja=0;
    
    int startHlJajaCode=0;
    int endHlJajaCode=0;
    
    // ANALYSE MINIJAJA
    private boolean mjjInitialiser;
    private InputStream miniJajaStream;
    private MiniJaja parseurMiniJaja;
    private fr.univfcomte.comp4.analyseur.SimpleNode arbreMiniJaja;
    private ControleTypeVisitor visiteurControleType;
    private DataControleType donneesControleType;

    // ANALYSE JAJACODE
    private boolean jjInitialiser;
    private fr.univfcomte.comp4.analyseur_JajaCode.SimpleNode arbreJajaCode;
    private JajaCode parseurJajaCode;
    private int adresseRetrait=-1;
    
    // COMPILATION
    private Paire jajaCode;
    private MiniJajaCompilateurVisitor visiteurCompilation;

    // INTERPRETATION MINIJAJA
    private MiniJajaInterpreteurVisitor visiteurInterpretationMiniJaja;
    private ThreadInterpretationMiniJaja threadInterprationMiniJaja;
    private int ligneMiniJaja; // ligne de l'instruction courante
    private boolean stop;
    // INTERPRETATION JAJACODE
    private JajaCodeInterpreteurVisitor visiteurInterpretationJajaCode;
    private ThreadInterpretationJajaCode threadInterpretationJajaCode;
    private HashSet<Integer> pointArrets;
    private int lignePauseJajaCode;
    private int ligneJajaCode; // ligne de l'instruction courante

    /**
     * Creates new form JFrameMain
     */
    public JFrameMain() {
        this.ligneJajaCode = 0;
        this.miniJajaText = "";
        this.mjjInitialiser = false;
        this.jjInitialiser = false;
        this.pasapas = false;
        this.stop = true;
        this.pointArrets = new HashSet<Integer>();
        this.lignePauseJajaCode = 0;

        this.donneesControleType = new DataControleType();
        this.visiteurControleType = new ControleTypeVisitor();
        this.visiteurCompilation = new MiniJajaCompilateurVisitor();
        this.visiteurInterpretationJajaCode = new JajaCodeInterpreteurVisitor(this);
        this.visiteurInterpretationMiniJaja = new MiniJajaInterpreteurVisitor(this);

        initComponents();
        this.miniJajaTextLines = new TextLineNumber(this.miniJajaSaisie);
        this.miniJajaScollPane.setRowHeaderView(this.miniJajaTextLines);
        this.miniJajaTextLines.setUpdateFont(true);

        this.miniJajaSaisie.addMouseListener(new CliqueDroitListener(this));

        highlighterMiniJaja =  (DefaultHighlighter)this.miniJajaSaisie.getHighlighter();
        highlighterMiniJaja.setDrawsLayeredHighlights(false);
        
        highlighterJajaCode = (DefaultHighlighter)this.jajaCodeTextAffichage.getHighlighter();
        highlighterJajaCode.setDrawsLayeredHighlights(false);
        
        { // DEVELOPPEMENT
            this.miniJajaPath = "D://1.mjj";
            this.boutonCompilation.setEnabled(true);
            this.boutonExe.setEnabled(true);
            this.boutonExePasAPas.setEnabled(true);

           
            
            try {
                this.miniJajaStream = new FileInputStream(this.miniJajaPath);
                InputStreamReader ipsr = new InputStreamReader(
                        this.miniJajaStream);
                BufferedReader br = new BufferedReader(ipsr);
                String ligne;
                while ((ligne = br.readLine()) != null) {
                    this.miniJajaText += ligne + "\n";
                }
                br.close();

                this.miniJajaSaisie.setText("");
                this.miniJajaSaisie.setText(this.miniJajaText);

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        miniJajaScollPane = new javax.swing.JScrollPane();
        miniJajaSaisie = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        boutonCompilation = new javax.swing.JButton();
        boutonExe = new javax.swing.JButton();
        boutonExePasAPas = new javax.swing.JButton();
        boutonSuivante = new javax.swing.JButton();
        boutonStop = new javax.swing.JButton();
        analyseScrollPane = new javax.swing.JScrollPane();
        analyseTexteAffichage = new javax.swing.JTextArea();
        ongletsMemoireMiniJaja = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jajaCodeTextAffichage = new javax.swing.JTextArea();
        ongletsMemoireJajaCode = new javax.swing.JTabbedPane();
        menu = new javax.swing.JMenuBar();
        menuFichier = new javax.swing.JMenu();
        ouvrirMenuItem = new javax.swing.JMenuItem();
        enregistrerMenuItem = new javax.swing.JMenuItem();
        enregisterSousMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        miniJajaSaisie.setColumns(20);
        miniJajaSaisie.setRows(5);
        miniJajaSaisie.setTabSize(3);
        miniJajaSaisie.setCursor(new java.awt.Cursor(
                java.awt.Cursor.TEXT_CURSOR));
        miniJajaSaisie.setDragEnabled(true);
        miniJajaScollPane.setViewportView(miniJajaSaisie);

        jToolBar1.setRollover(true);

        boutonCompilation.setText("Compiler");
        boutonCompilation.setEnabled(false);
        boutonCompilation.setFocusable(false);
        boutonCompilation
                .setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boutonCompilation
                .setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boutonCompilation
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        boutonCompilationActionPerformed(evt);
                    }
                });
        jToolBar1.add(boutonCompilation);

        boutonExe.setText("Exécuter");
        boutonExe.setEnabled(false);
        boutonExe.setFocusable(false);
        boutonExe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boutonExe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boutonExe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonExeActionPerformed(evt);
            }
        });
        jToolBar1.add(boutonExe);

        boutonExePasAPas.setText("Exécuter pas à pas");
        boutonExePasAPas.setEnabled(false);
        boutonExePasAPas.setFocusable(false);
        boutonExePasAPas
                .setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boutonExePasAPas
                .setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boutonExePasAPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonExePasAPasActionPerformed(evt);
            }
        });
        jToolBar1.add(boutonExePasAPas);

        boutonSuivante.setText("Instruction suivante");
        boutonSuivante.setEnabled(false);
        boutonSuivante.setFocusable(false);
        boutonSuivante
                .setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boutonSuivante
                .setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boutonSuivante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSuivanteActionPerformed(evt);
            }
        });
        jToolBar1.add(boutonSuivante);

        boutonStop.setText("Stop");
        boutonStop.setFocusable(false);
        boutonStop
                .setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boutonStop
                .setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boutonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonStopActionPerformed(evt);
            }
        });
        jToolBar1.add(boutonStop);


        analyseTexteAffichage.setEditable(false);
        analyseTexteAffichage.setColumns(20);
        analyseTexteAffichage.setRows(5);
        analyseScrollPane.setViewportView(analyseTexteAffichage);

        jajaCodeTextAffichage.setEditable(false);
        jScrollPane1.setViewportView(jajaCodeTextAffichage);

        menuFichier.setText("Fichier");

        ouvrirMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_O,
                java.awt.event.InputEvent.CTRL_MASK));
        ouvrirMenuItem.setText("Ouvrir...");
        ouvrirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirMenuItemActionPerformed(evt);
            }
        });
        menuFichier.add(ouvrirMenuItem);

        enregistrerMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_S,
                java.awt.event.InputEvent.CTRL_MASK));
        enregistrerMenuItem.setText("Enregistrer");
        enregistrerMenuItem
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        enregistrerMenuItemActionPerformed(evt);
                    }
                });
        menuFichier.add(enregistrerMenuItem);

        enregisterSousMenuItem.setAccelerator(javax.swing.KeyStroke
                .getKeyStroke(java.awt.event.KeyEvent.VK_S,
                        java.awt.event.InputEvent.SHIFT_MASK
                                | java.awt.event.InputEvent.CTRL_MASK));
        enregisterSousMenuItem.setText("Enregistrer sous...");
        enregisterSousMenuItem
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        enregisterSousMenuItemActionPerformed(evt);
                    }
                });
        menuFichier.add(enregisterSousMenuItem);

        menu.add(menuFichier);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                        analyseScrollPane,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        1009,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        miniJajaScollPane,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        544,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        jScrollPane1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        459,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                        ongletsMemoireMiniJaja,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        366,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        ongletsMemoireJajaCode,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        361,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addComponent(jToolBar1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        jScrollPane1)
                                                                                .addComponent(
                                                                                        miniJajaScollPane))
                                                                .addGap(6, 6, 6)
                                                                .addComponent(
                                                                        analyseScrollPane,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        217,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        ongletsMemoireMiniJaja,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        342,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        ongletsMemoireJajaCode,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        338,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ouvrirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ouvrirMenuItemActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Programme MiniJaja", "mjj");
        JFileChooser chooser = new JFileChooser();// création dun nouveau
        // filechosser

        chooser.setFileFilter(filter);
        chooser.setApproveButtonText("Choix d'un fichier..."); // intitulé du
        // bouton
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                this.miniJajaText = "";
                this.miniJajaPath = chooser.getSelectedFile().getAbsolutePath();
                this.miniJajaStream = new FileInputStream(this.miniJajaPath);
                InputStreamReader ipsr = new InputStreamReader(
                        this.miniJajaStream);
                BufferedReader br = new BufferedReader(ipsr);
                String ligne;
                while ((ligne = br.readLine()) != null) {
                    this.miniJajaText += ligne + "\n";
                }
                br.close();

                this.miniJajaSaisie.setText(this.miniJajaText);
                this.boutonCompilation.setEnabled(true);
                this.boutonExe.setEnabled(true);
                this.boutonExePasAPas.setEnabled(true);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }// GEN-LAST:event_ouvrirMenuItemActionPerformed

    private void enregistrerMenuItemActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_enregistrerMenuItemActionPerformed
        // TODO add your handling code here:
        try {
            PrintWriter writer = new PrintWriter(this.miniJajaPath, "UTF-8");
            writer.print(this.miniJajaSaisie.getText());
            writer.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // GEN-LAST:event_enregistrerMenuItemActionPerformed

    private void enregisterSousMenuItemActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_enregisterSousMenuItemActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Programme MiniJaja", "mjj");
        JFileChooser chooser = new JFileChooser();// création dun nouveau
        // filechosser

        chooser.setFileFilter(filter);
        chooser.setApproveButtonText("Enregistrer"); // intitulé du bouton
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                PrintWriter writer = new PrintWriter(chooser.getSelectedFile()
                        .getAbsolutePath(), "UTF-8");
                writer.print(this.miniJajaSaisie.getText());
                writer.close();

                this.miniJajaPath = chooser.getSelectedFile().getAbsolutePath();
                this.miniJajaStream = new FileInputStream(this.miniJajaPath);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }// GEN-LAST:event_enregisterSousMenuItemActionPerformed

    private void boutonCompilationActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boutonCompilationActionPerformed
        // TODO add your handling code here:
        compilerProgramme();

    }// GEN-LAST:event_boutonCompilationActionPerformed

    private void boutonExeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boutonExeActionPerformed
        // TODO add your handling code here:
        this.pasapas = false;
        executerProgramme();

    }// GEN-LAST:event_boutonExeActionPerformed

    private void boutonExePasAPasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boutonExePasAPasActionPerformed
        // TODO add your handling code here:
        this.pasapas = true;
        this.boutonSuivante.setEnabled(true);
        this.boutonStop.setEnabled(true);
        executerProgramme();
    }// GEN-LAST:event_boutonExePasAPasActionPerformed

    private void boutonSuivanteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boutonSuivanteActionPerformed
        // TODO add your handling code here:
            this.ongletsMemoireMiniJaja.removeAll();
            reprendreInterpretationMiniJaja();
    }// GEN-LAST:event_boutonSuivanteActionPerformed

     private void boutonStopActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boutonStopActionPerformed
         // TODO add your handling code here:
         stopperThread();
     }// GEN-LAST:event_boutonStopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed"
        // desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMain().setVisible(true);
            }
        });
    }

    @Override
    public void onErreur(String message) {
        stopperThread();
        this.analyseTexteAffichage.append(message);
    }

    public void onMemoireChanged(Memoire memoire) {
		/*
		 * this.nEtatMemoire++; String texte = memoire.toString();
		 * this.ajouterOngletMemoireJajaCode("m" + this.nEtatMemoire, texte);
		 */
    }
    
    public void onMemoireRetrait(Memoire memoire) {
    	this.ajouterOngletMemoireJajaCode("Après retrait", memoire.toString());
    }

    public void onMemoireChangedMain(MemoireMiniJaja memoire) {
        reprendreInterpretationJajaCode();
        String texte = "";
        texte += memoire.toString();
        this.ajouterOngletMemoireMiniJaja("Main", texte);
        this.boutonSuivante.setEnabled(false);
    }

    public void onMemoireChangedMainRetrait(MemoireMiniJaja memoire) {
        reprendreInterpretationJajaCode();
        String texte = "";
        texte += memoire.toString();
        this.ajouterOngletMemoireMiniJaja("Après retrait", texte);
    }

    public void onMemoireChangedAppelI(MemoireMiniJaja memoire, String nom) {
		/*String texte = "";
		texte += memoire.toString();
		this.ajouterOngletMemoireMiniJaja(nom, texte);*/
    }

    public void onInstruction(Memoire memoire, Object noeud) { // instruction JajaCode
        this.ligneJajaCode = ((fr.univfcomte.comp4.analyseur_JajaCode.SimpleNode)noeud).jjtGetFirstToken().beginLine;
      
        
        if(this.pasapas)
        {

	        if (this.ligneJajaCode == this.lignePauseJajaCode) {
	        	
	            if(this.ligneJajaCode < this.adresseRetrait) {
	                this.ongletsMemoireJajaCode.removeAll();
	                this.ajouterOngletMemoireJajaCode("Mémoire courante JajaCode", memoire.toString());
	            }
	            pauseInterpretationJajaCode();
	        }

	        if(noeud instanceof ASTinvoke)
	        {
	        	pauseInterpretationJajaCode();
	
	            if(this.ligneJajaCode < this.adresseRetrait) {
	                this.ongletsMemoireJajaCode.removeAll();
	                this.ajouterOngletMemoireJajaCode("Mémoire courante JajaCode", memoire.toString());
	            }
	        }
        }

        if(this.pointArrets.size() > 0) {
            if (this.ligneJajaCode == this.lignePauseJajaCode) {

                if(this.ligneJajaCode < this.adresseRetrait) {
                    this.ongletsMemoireJajaCode.removeAll();
                    this.ajouterOngletMemoireJajaCode("Mémoire courante JajaCode", memoire.toString());
                }
                pauseInterpretationJajaCode();
            }
        }

        if (this.ligneJajaCode == this.adresseRetrait) {
            this.ongletsMemoireJajaCode.removeAll();
            this.ajouterOngletMemoireJajaCode("Main", memoire.toString());
        }
    }

    public void onInstruction(MemoireMiniJaja memoire, Object noeud) { // instruction MiniJaja

        this.ligneMiniJaja = ((SimpleNode) noeud).jjtGetFirstToken().beginLine;
        int key = this.ligneMiniJaja*100+((SimpleNode) noeud).jjtGetFirstToken().beginColumn;
        
        HashMap<Integer, Integer[]> tableCorrespondance = this.visiteurCompilation.getTable();
        int ligneDebut = tableCorrespondance.get(key)[0]-1;
        int ligneFin = tableCorrespondance.get(key)[1]-1;
        
        this.miniJajaTextLines.setLineBold(this.ligneMiniJaja);

        try
        {
        	painterMiniJaja = new DefaultHighlighter.DefaultHighlightPainter( Color.white);
        	highlighterMiniJaja.addHighlight(startHlMiniJaja, endHlMiniJaja, painterMiniJaja );
        	painterMiniJaja = new DefaultHighlighter.DefaultHighlightPainter( Color.lightGray);
            startHlMiniJaja =  this.miniJajaSaisie.getLineStartOffset(this.ligneMiniJaja-1);
            endHlMiniJaja =   this.miniJajaSaisie.getLineEndOffset(this.ligneMiniJaja-1);
            highlighterMiniJaja.addHighlight(startHlMiniJaja, endHlMiniJaja, painterMiniJaja );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        if (this.pointArrets.size() > 0) {

        	
            for (Integer pointArret : this.pointArrets) {

                if (pointArret == this.ligneMiniJaja) {

                    
                    String texte = "";
                    texte += memoire.toString();
                    ajouterOngletMemoireMiniJaja("Mémoire courante MiniJaja", texte);

                    try
                    {
                    	
                    	painterJajaCode = new DefaultHighlighter.DefaultHighlightPainter( Color.white);
                    	highlighterJajaCode.addHighlight(startHlJajaCode, endHlJajaCode, painterJajaCode );
                    	painterJajaCode = new DefaultHighlighter.DefaultHighlightPainter( Color.lightGray);
                        startHlJajaCode =  this.jajaCodeTextAffichage.getLineStartOffset(ligneDebut);
                        endHlJajaCode =   this.jajaCodeTextAffichage.getLineEndOffset(ligneFin);
                        highlighterJajaCode.addHighlight(startHlJajaCode,endHlJajaCode, painterJajaCode );
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    
                    this.lignePauseJajaCode = tableCorrespondance.get(key)[0];

                    reprendreInterpretationJajaCode();
                    pauseInterpretationMiniJaja();
                }
            }
        }

        if (this.pasapas) {

            String texte = "";
            texte += memoire.toString();
            ajouterOngletMemoireMiniJaja("Mémoire courante MiniJaja", texte);
           

            try
            {
            	
            	painterJajaCode = new DefaultHighlighter.DefaultHighlightPainter( Color.white);
            	highlighterJajaCode.addHighlight(startHlJajaCode, endHlJajaCode, painterJajaCode );
            	painterJajaCode = new DefaultHighlighter.DefaultHighlightPainter( Color.lightGray);
                startHlJajaCode =  this.jajaCodeTextAffichage.getLineStartOffset(ligneDebut);
                endHlJajaCode =   this.jajaCodeTextAffichage.getLineEndOffset(ligneFin);
                highlighterJajaCode.addHighlight(startHlJajaCode,endHlJajaCode, painterJajaCode );
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            this.lignePauseJajaCode = tableCorrespondance.get(key)[0];

            reprendreInterpretationJajaCode();
            pauseInterpretationMiniJaja();
        }
    }

    public void ajouterOngletMemoireMiniJaja(String nom, String texte) {
        JScrollPane nouvelOnglet = new JScrollPane();
        JTextPane texteMemoire = new JTextPane();
        nouvelOnglet.setName(nom);
        texteMemoire.setText(texte);
        nouvelOnglet.setViewportView(texteMemoire);
        this.ongletsMemoireMiniJaja.add(nouvelOnglet);
    }

    public void ajouterOngletMemoireJajaCode(String nom, String texte) {
        JScrollPane nouvelOnglet = new JScrollPane();
        JTextPane texteMemoire = new JTextPane();
        nouvelOnglet.setName(nom);
        texteMemoire.setText(texte);
        nouvelOnglet.setViewportView(texteMemoire);
        this.ongletsMemoireJajaCode.add(nouvelOnglet);
    }

    public boolean analyserMiniJaja() {

        System.out.println("JavaCC Parser:  Reading from file "
                + this.miniJajaPath + " . . .");

        this.donneesControleType = new DataControleType();
        this.threadInterprationMiniJaja = new ThreadInterpretationMiniJaja(this, this.visiteurInterpretationMiniJaja);

        if (!this.mjjInitialiser) {
            try {
                this.parseurMiniJaja = new MiniJaja(
                        new java.io.FileInputStream(this.miniJajaPath));
                this.mjjInitialiser = true;
            } catch (java.io.FileNotFoundException e) {
                System.out.println("JavaCC Parser:  File " + this.miniJajaPath
                        + " not found.");
                return false;
            }
        } else {
            try {
                parseurMiniJaja.ReInit(new java.io.FileInputStream(
                        this.miniJajaPath));
            } catch (java.io.FileNotFoundException e) {
                System.out.println("JavaCC Parser:  File " + this.miniJajaPath
                        + " not found.");
                return false;
            }
        }

        // //////////////////
        // ANALYSE MINIJAJA//
        // //////////////////
        try {
            this.arbreMiniJaja = this.parseurMiniJaja.classe();
            this.threadInterprationMiniJaja.setNoeud(this.arbreMiniJaja);

            this.analyseTexteAffichage.setText("");
            this.analyseTexteAffichage
                    .append("Le programme MiniJaja a été parser avec succès.\n");

            try {
                this.arbreMiniJaja.jjtAccept(this.visiteurControleType, this.donneesControleType);
                this.threadInterprationMiniJaja.setTableSymbole(this.donneesControleType.getTableSymbole());
            } catch (MiniJajaException e) {
                onErreur(e.getMessage());
                return false;
            }
        } catch (ParseException e) {
            this.analyseTexteAffichage.setText(e.getMessage());
            this.analyseTexteAffichage
                    .append("JavaCC Parser:  Encountered errors during parse.");
            this.boutonSuivante.setEnabled(false);

            return false;
        }
        return true;
    }

    public boolean analyserJajaCode() {

        if (!this.jjInitialiser) {
            this.parseurJajaCode = new JajaCode(new ByteArrayInputStream(this.jajaCode.getInstructions().getBytes()));
            this.jjInitialiser = true;
        } else {
            this.parseurJajaCode.ReInit(new ByteArrayInputStream(this.jajaCode.getInstructions().getBytes()));
        }

        // //////////////////
        // ANALYSE JAJACODE//
        // //////////////////
        try {
            this.arbreJajaCode = this.parseurJajaCode.classe();

            this.visiteurInterpretationJajaCode = new JajaCodeInterpreteurVisitor(this);
            Memoire memoire = new Memoire(this.jajaCode.getAdresse());
            this.threadInterpretationJajaCode = new ThreadInterpretationJajaCode(this, this.visiteurInterpretationJajaCode, memoire);
            this.threadInterpretationJajaCode.setNoeud(this.arbreJajaCode);
            return true;

        } catch (fr.univfcomte.comp4.analyseur_JajaCode.ParseException e) {
            return false;
        }
    }

    public void compilerProgramme() {

        if (analyserMiniJaja()) {        // si l'analyse réussi : on compile
            // /////////////
            // COMPILATION//
            // /////////////
            try {
                this.jajaCode = (Paire) this.arbreMiniJaja.jjtAccept(visiteurCompilation, 1); // On commence à la ligne n = 1
                this.jajaCodeTextAffichage.setText(this.jajaCode.getInstructions());
                this.adresseRetrait = this.visiteurCompilation.getAdresseRetrait();
            } catch (MiniJajaException e) {
                onErreur(e.getMessage());
            }
        }
    }

    public void executerProgramme() {

        this.ligneJajaCode = 0;
        this.lignePauseJajaCode = -1;
        this.stop = false;

        compilerProgramme();

        this.ongletsMemoireMiniJaja.removeAll();
        this.ongletsMemoireJajaCode.removeAll();

        if (analyserJajaCode()) {

            this.threadInterprationMiniJaja.start(); // on lance l'interprétation du
            // MiniJaja
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            if(this.pasapas) this.lignePauseJajaCode = 1;
            this.threadInterpretationJajaCode.start(); // on lance l'interprétation si son analyse réussi
        }
    }

    public void ajouterPointArret() {
        if(this.pointArrets.add(this.miniJajaTextLines.getCurrentLine())) {
            this.miniJajaTextLines.addLineItalic(this.miniJajaTextLines
                    .getCurrentLine());
        }
    }

    public void supprimerPointArrets() {
        this.miniJajaTextLines.removeLinesItalic();
        this.pointArrets.clear();
    }

    private void pauseInterpretationJajaCode() {
        synchronized (this.threadInterpretationJajaCode) {

            try {
                this.threadInterpretationJajaCode.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void reprendreInterpretationMiniJaja() {
        synchronized (this.threadInterprationMiniJaja) {
            if(!this.stop) this.threadInterprationMiniJaja.notify();
        }
    }

    public void reprendreInterpretationJajaCode() {
        synchronized (this.threadInterpretationJajaCode) {
            if(!this.stop) this.threadInterpretationJajaCode.notify();
        }
    }

    public void pauseInterpretationMiniJaja() {

        this.boutonSuivante.setEnabled(true);
        this.boutonStop.setEnabled(true);

        synchronized (this.threadInterprationMiniJaja) {

            try {
                this.threadInterprationMiniJaja.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void stopperThread() {
        this.stop = true;
        this.ongletsMemoireMiniJaja.removeAll();
        this.ongletsMemoireJajaCode.removeAll();
        this.boutonSuivante.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane analyseScrollPane;
    private javax.swing.JTextArea analyseTexteAffichage;
    private javax.swing.JButton boutonCompilation;
    private javax.swing.JButton boutonExe;
    private javax.swing.JButton boutonExePasAPas;
    private javax.swing.JButton boutonSuivante;
    private javax.swing.JButton boutonStop;
    private javax.swing.JMenuItem enregisterSousMenuItem;
    private javax.swing.JMenuItem enregistrerMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextArea jajaCodeTextAffichage;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuFichier;
    private javax.swing.JTextArea miniJajaSaisie;
    private javax.swing.JScrollPane miniJajaScollPane;
    private javax.swing.JTabbedPane ongletsMemoireJajaCode;
    private javax.swing.JTabbedPane ongletsMemoireMiniJaja;
    private javax.swing.JMenuItem ouvrirMenuItem;

    // End of variables declaration//GEN-END:variables
}
