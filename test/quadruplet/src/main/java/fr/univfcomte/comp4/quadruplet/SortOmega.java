package fr.univfcomte.comp4.quadruplet;

public class SortOmega extends Sorte{

	public SortOmega()
	{
		this.type="omega";
	}

	@Override
	public Valeur createValeur() {
		return new ValeurVide();
	}
}
