#ifndef GRAPH_H
#define GRAPH_H

#include "list.h"

/*
* Par Pierre Wargnier et Anthony Casagrande
* Décrit les fontions de Graph.h
*/
typedef struct TypGraph TypGraph;
struct TypGraph {
	int nbMaxSommets;		/* Nombre de tacheProjet maximum */
	int estOriente;			/* 0 si le projet est pas oriente, 1 si oui*/
	listeAdjacences * listeVoisin;	/* Liste des tacheProjets taches */
};

typedef TypGraph *Graph;

Graph 	creation(int nbMaxSommets);
//Graph 	lecture(char *urlFichierSource);
void 	creationVoisinGraph(Graph graph, int voisin);
void 	insertionVoisinGraph(TypGraph *Graph, listeAdjacences voisin);
void 	insertionArete(Graph gr, int sommet1, int sommet2, int poid);
void 	suppressionVoisinGraph(Graph gr, int voisin);
void 	suppressionDependance(Graph gr, int sommet1, int sommet2, int poid);
void    affichage(Graph gr);
//void 	affichage(Graph gr, FILE *file);
//void 	sauvegarde(Graph gr, char* urlFichierDest);
//char* 	del(char str[], char ch);
//void 	creationInitFin(TypGraph *Graph);

//void 	getPoids(Graph gr);
//int 	poidsPetit(Graph gr, int debut, int fin);
//int 	poidsGrand(Graph gr, int debut, int fin);
//int 	sommePoids(Graph gr);
//int 	poidsCheminPlusCourt(Graph gr, int debut, int fin);
//int 	poidsCHeminPlusLong(Graph gr, int debut, int fin);
//int 	cheminCritique(Graph gr, int debut, int fin, listeAdjacences chemin);
//int	cheminCritiqueLong(Graph gr, int debut, int fin);
//int	cheminCritiqueCourt(Graph gr, int debut, int fin);

#endif
