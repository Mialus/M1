/*
* Par Pierre Wargnier et Anthony Casagrande
* Décrit les fontions de list.h
*/

#include "stdlib.h"
#include "stdio.h"
#include "string.h"
#include "list.h"

/*
* Fonction : 	ajouterVoisin
*
* Parametres : 	listeAdjacences ajouterVoisin(listeAdjacences *liste, int voisin, int poid)
*
* Retour : 	
*
* Description : permet d'ajoute un element ou voisin dans une liste.
*
*/
listeAdjacences ajouterVoisin(listeAdjacences *liste, int voisin, int poid){
	/* Création d'un élement à ajouter */
	listeAdjacences element;	
	
	element = (listeAdjacences) malloc(sizeof(TypVoisins));
	element->voisin = voisin;
	element->poids = poid;
	element->voisinSuivant = *liste;
	
	 //return element;
	
}


/*
* Fonction : 	ajouterVoisinAfter
*
* Parametres : 	ListeAdjacences ajouterVoisinAfter(ListeAdjacenes *liste, int voisin, int poid)
*
* Retour : 		element
*
* Description : focntion qui permet d'ajoute un element à la fin de la liste.
*
*/
listeAdjacences ajouterVoisinAfter(listeAdjacences *liste, int voisin, int poid){
	
	/* Créaton de 2 elements dont un qui sera à la fin de la liste*/
	listeAdjacences element;	
	listeAdjacences element2;
	
	element = (listeAdjacences) malloc(sizeof(TypVoisins));
	element2 = (listeAdjacences) malloc(sizeof(TypVoisins));
	
	element = *liste;
	if(element->voisin!=-1){
		while(element->voisinSuivant->voisin != -1) {
			element = element->voisinSuivant;
		}	
		element2->voisinSuivant = element->voisinSuivant;
		element->voisinSuivant = element2;
		element2->voisin = voisin;
		element2->poids = poid;
	}

	//element->tacheSuivant = *liste;
	
	return element;
	
}


/*
* Fonction : 	supprimeVoisin
*
* Parametres : 	listeAdjacences supprimeVoisin(listeAdjacences liste, int voisin)
*
* Retour : 		prem
*
* Description : Permet de supprimer l'element dans une liste.
*
*/
listeAdjacences supprimeVoisin(listeAdjacences liste, int voisin){
	/* Declaration des elements et variable*/
	listeAdjacences precedent;	/* Sommet precedent */
	listeAdjacences	prem;		/* Premier sommet */
	listeAdjacences todelete;	/* Sommet a supprimer */
	int flag;		/* Curseur permetant de savoir ou l'on se situe dans la liste */
	
	flag = 0;
	//precedent = (listeAdjacences) malloc(sizeof(TypVoisins));
	//prem = (listeAdjacences) malloc(sizeof(TypVoisins));
	prem = liste;
	
	while (liste->voisin != -1) {
		if (liste->voisin == voisin) {
			todelete = liste;
			if (flag == 1) {			/* On est pas sur la tete de liste */
				precedent->voisinSuivant = liste->voisinSuivant;
			}
			else {
				prem = liste->voisinSuivant;
			}
			free(todelete);
		}
		else {
			precedent = liste;
			flag = 1;
		}
		if (liste->voisin != -1) {
			liste = liste->voisinSuivant;
		}
	}
	
	return prem;
}


/*
* Fonction : 	supprimerDependance
*
* Parametres : 	listeAdjacences supprimerDependance(listeAdjacences liste, int voisin, int poid)
*
* Retour : 		prem
*
* Description : Permet de supprime l'arete rentrée en paramètre avec son poids
*/
listeAdjacences supprimerDependance(listeAdjacences liste, int voisin, int poid){
    /* Declaration des elements et variable*/
	listeAdjacences precedent;	/* Sommet precedent */
	listeAdjacences	prem;		/* Premier sommet */
	listeAdjacences todelete;	/* Sommet a supprimer */
	int flag;		/* Curseur permetant de savoir ou l'on se situe dans la liste */
	
	flag = 0;
	//precedent = (listeAdjacences) malloc(sizeof(TypVoisins));
	//prem = (listeAdjacences) malloc(sizeof(TypVoisins));
	prem = liste;
	
	
	while (liste->voisin != -1) {
		if (liste->voisin == voisin && liste->poids == poid) {
			todelete = liste;
			if (flag == 1) {			/* On est pas sur la tete de liste */
				precedent->voisinSuivant = liste->voisinSuivant;
			}
			else {
				prem = liste->voisinSuivant;
			}
			free(todelete);
		}
		else {
			precedent = liste;
			flag = 1;
		}
		if (liste->voisin != -1) {
			liste = liste->voisinSuivant;
		}
	}
	return prem;
}


/*
* Fonction : 	afficher
*
* Parametres : 	void afficher(listeAdjacences liste, FILE *file)
*
* Retour : 		rien
*
* Description : Permet d'écrire la liste définie dans le fichier
*
*/
/*void afficher(listeAdjacences liste, FILE *file){	
	while (liste->voisin != -1) {
	
		fprintf(file, "(%d/%d)", liste->voisin, liste->poids);
		if (liste->voisinSuivant->voisin != -1) {
			fprintf(file, ", ");
        }
		liste = liste->voisinSuivant;
	}
    fprintf(file, "\n");
 }
    */
    void afficher(listeAdjacences liste){	
	while (liste->voisin != -1) {
	
		printf("(%d/%d)", liste->voisin, liste->poids);
		if (liste->voisinSuivant->voisin != -1) {
			printf(", ");
        }
		liste = liste->voisinSuivant;
	}
    printf("\n");
}
