/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univfcomte.comp4.quadruplet;

/**
 *
 * @author Pierre
 */
public class SortEntier extends Sorte{

    public SortEntier() {
        type="int";
    }

	@Override
	public Valeur createValeur() {
		return new ValeurEntier(0);
	}
    
    
}
