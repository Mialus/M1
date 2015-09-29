package com.example.m1pwargnie.calculette;

/**
 * Created by m1pwargnie on 16/09/15.
 */


public class CalcApp {

    final int ETAT_0 = 0;
    final int ETAT_1 = 1;
    final int ETAT_2 = 2;
    final int ETAT_3 = 3;

    int etat=ETAT_0;

    String operandeTexte;
    double accumulateur;
    double operande;

    final int OP_PLUS = 0;
    final int OP_MOINS = 1;
    final int OP_MULT = 2;
    final int OP_DIV = 3;
    int operationPrecedente;

    MainActivity ma;

    public void setVue(MainActivity ma) {
        this.ma = ma;
    }

    /*private void miseAJourVue(String nombreAAfficher) {
        ma.miseAJour(nombreAAfficher);
    }*/

    public String point() {
        if (etat == ETAT_1) {
            operandeTexte = operandeTexte + '.';
            etat = ETAT_2;
            return operandeTexte;
        }
        return null;
    }

    public String chiffre(String chiffreTexte) {
        if (etat == ETAT_0) {
            operandeTexte = chiffreTexte;
            etat = ETAT_1;
            return operandeTexte;
        } else if (etat == ETAT_1 || etat == ETAT_3) {
            operandeTexte = operandeTexte + chiffreTexte;
            return operandeTexte;
        } else if (etat == ETAT_2) {
            operandeTexte = operandeTexte + chiffreTexte;
            etat = ETAT_3;
            return operandeTexte;
        }
        return null;
    }

    public String plus() {
        if (etat == ETAT_1 || etat == ETAT_3) {
            double operande = Double.valueOf(operandeTexte).doubleValue();
            switch (operationPrecedente) {
                case OP_PLUS:
                    accumulateur += operande;
                    break;
                case OP_MOINS:
                    accumulateur -= operande;
                    break;
                case OP_MULT:
                    accumulateur *= operande;
                    break;
                case OP_DIV:
                    accumulateur /= operande;
                    break;
            }
            operationPrecedente = OP_PLUS;
            etat = ETAT_0;
            return (new Double(accumulateur).toString());
        }
        return null;
    }

    public String moins() {
        if (etat == ETAT_1 || etat == ETAT_3) {
            double operande = Double.valueOf(operandeTexte).doubleValue();
            switch (operationPrecedente) {
                case OP_PLUS:
                    accumulateur += operande;
                    break;
                case OP_MOINS:
                    accumulateur -= operande;
                    break;
                case OP_MULT:
                    accumulateur *= operande;
                    break;
                case OP_DIV:
                    accumulateur /= operande;
                    break;
            }
            operationPrecedente = OP_MOINS;
            etat = ETAT_0;
            return (new Double(accumulateur).toString());
        }
        return null;
    }

    public String mult() {
        if (etat == ETAT_1 || etat == ETAT_3) {
            double operande = Double.valueOf(operandeTexte).doubleValue();
            switch (operationPrecedente) {
                case OP_PLUS:
                    accumulateur += operande;
                    break;
                case OP_MOINS:
                    accumulateur -= operande;
                    break;
                case OP_MULT:
                    accumulateur *= operande;
                    break;
                case OP_DIV:
                    accumulateur /= operande;
                    break;
            }
            operationPrecedente = OP_MULT;
            etat = ETAT_0;
            return (new Double(accumulateur).toString());
        }
        return null;
    }

    public String div() {
        if (etat == ETAT_1 || etat == ETAT_3) {
            double operande = Double.valueOf(operandeTexte).doubleValue();
            switch (operationPrecedente) {
                case OP_PLUS:
                    accumulateur += operande;
                    break;
                case OP_MOINS:
                    accumulateur -= operande;
                    break;
                case OP_MULT:
                    accumulateur *= operande;
                    break;
                case OP_DIV:
                    accumulateur /= operande;
                    break;
            }
            operationPrecedente = OP_DIV;
            etat = ETAT_0;
            return(new Double(accumulateur).toString());
        }
        return null;
    }

    public String egal() {
        if (etat == ETAT_1 || etat == ETAT_3) {
            double operande = Double.valueOf(operandeTexte).doubleValue();
            switch (operationPrecedente) {
                case OP_PLUS:
                    accumulateur += operande;
                    break;
                case OP_MOINS:
                    accumulateur -= operande;
                    break;
                case OP_MULT:
                    accumulateur *= operande;
                    break;
                case OP_DIV:
                    accumulateur /= operande;
                    break;
            }
            etat = ETAT_0;
            operationPrecedente = OP_PLUS;
            accumulateur = 0;
            return(new Double(accumulateur).toString());
        }
        return null;
    }

    private void terminer() {
        System.exit(0);
    }

    public void cloreVue() {
        terminer();
    }

    public void fin() {
        terminer();
    }

    public CalcApp(MainActivity ma) {

        accumulateur = 0;
        operationPrecedente = OP_PLUS;
        operandeTexte = "0";

        etat = ETAT_0;

        setVue (ma) ;

    }

}
