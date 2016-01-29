package fr.univfcomte.comp4.interpreteur_MiniJaja;

import fr.univfcomte.comp4.memoire_MiniJaja.MemoireMiniJaja;
import fr.univfcomte.comp4.memoire_MiniJaja.MemoireMiniJajaListener;

public class EcouteurVideMiniJaja implements MemoireMiniJajaListener{

	//Ecouteur vide pour les test
	@Override
	public void onMemoireChangedMain(MemoireMiniJaja memoire) {
	}

	@Override
	public void onMemoireChangedMainRetrait(MemoireMiniJaja memoire) {
	}

	@Override
	public void onMemoireChangedAppelI(MemoireMiniJaja memoire, String nom) {
	}

	@Override
	public void onInstruction(MemoireMiniJaja memoire, Object noeud) {
	}

}
