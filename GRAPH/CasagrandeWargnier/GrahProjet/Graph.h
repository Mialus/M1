#include <stdlib.h>
#include <stdio.h>


typedef struct {
         int voisin;
         int* voisinSuivant;
         int* voisinprécédent;
} TypVoisins;

typedef struct {
         bool estOriente ; 
         int nbrSommet;
         TypVoisins* listesAdjacences;
} TypGraphe;

void afficheGraph (TypGraphe G);
void ajouteTransition(TypGraphe* Gdep,TypGraphe* Garr,int poids);
void creerGraph();

