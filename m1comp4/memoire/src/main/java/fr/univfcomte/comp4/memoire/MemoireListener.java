package fr.univfcomte.comp4.memoire;

public interface MemoireListener {
    void onMemoireChanged(Memoire memoire);
    void onInstruction(Memoire memoire, Object noeud);
    void onMemoireRetrait(Memoire memoire);
}
