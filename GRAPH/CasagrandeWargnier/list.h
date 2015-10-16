#ifndef LIST_H
#define LIST_H

#include <stdio.h>

typedef struct TypVoisins TypVoisins;
struct TypVoisins{
         int voisin;
	 int poids;
         TypVoisins * voisinSuivant;
};

typedef TypVoisins * listeAdjacences;

listeAdjacences ajouterVoisin(listeAdjacences * voisin, int sommet,int  poid);
listeAdjacences supprimeVoisin(listeAdjacences voisin, int sommet);
listeAdjacences 	ajouterVoisinAfter(listeAdjacences *voisin, int sommet, int poid);
listeAdjacences 	supprimerDependance(listeAdjacences voisin, int sommet, int poid);
//void 			afficher(listeAdjacences voisin, FILE* file);
void 			afficher(listeAdjacences voisin);


  
#endif
