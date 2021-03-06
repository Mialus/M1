/*
**********************************************************
*
* Programme : 	graphe.c
*
* ecrit par : 	Casagrande Anthony et Wargnier Pierre
*
* Descritpion : Permet de construire un graphe
*
***********************************************************
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "list.h"
#include "graph.h"


/*
* Fonction : 	creation
*
* Parametres :	Graph creation(int nbMaxSommets)
*
* Retour : 		gr (graphe crée)
*
* Description : Créé un Graph vide avec un nombre de sommet prédéfini en paramètre.
*
*/
Graph creation(int nbMaxSommets){
	int i;
	Graph gr;
	char x;

	gr = (Graph) malloc(sizeof(TypGraph));
	gr->listeVoisin = malloc(sizeof(listeAdjacences)*(nbMaxSommets+2));

	printf("Le Graph est-il orienté ? y/n");
	scanf("%c",&x);	
        //x = getchar();

	if(x == 'y'){
		gr->estOriente=1;
	}else{
		gr->estOriente=0;
	}
	gr->nbMaxSommets = nbMaxSommets;
        
	return gr;

}
/*
* Fonction : 	lecture
*
* Parametres : 	Graph lecture(char *urlFichierSource)
*
* Retour : 		Le projet lu
*
* Description : Permet de lire un projet contenu dans le fichier avec un url donné en paramètre pour retourner le graph correspondant.
*
*/
/*
Graph lecture(char *urlFichierSource){
	// Déclarations des varibales
	FILE	*fichier;		// Fichier de lecture
	Graph 	gr;			// Projet correspondant au fichier lu
	int 	i;			// Iterateur
	char 	line[128];		// Ligne lu dans le fichier
	int 	nbLine;			// Nombre de ligne
	int 	tmp;			// Entier temporaire
	int 	nbMaxSommets;		// Nombre de tache max du projet
	int 	currentSommet;		// Tache courant
	int 	currentSommetGraph=0;	// TacheProjet courant
	int 	currentpoids; 	// Duree du tache courant
	char 	*tok;			// Tokenisation de la ligne lu
	char 	*firstDelim;		// Premier separateur
	char 	*secDelim;		// Seconds separateurs
	int	firstLine;		// Booleen qui vaut true si on est a la premiere ligne
	int 	poids;			// Entier duree
	
	firstLine=1;
	tmp = 1;
	firstDelim=", \n -";
	secDelim = "'";
	tok = NULL;
	nbLine = 0;
	fichier = fopen(urlFichierSource, "r");
	gr = (Graph) malloc(sizeof(TypGraph));
	gr->estOriente = 1;
	listeAdjacences element = (listeAdjacences) malloc(sizeof(TypGraph));  
	if (fichier != NULL) {
	//compter le nbLine
		while (fgets(line, 128, fichier) != NULL) {
			nbLine++;
		}
		close(fichier);
		fichier = fopen(urlFichierSource, "r");
		nbLine-=2;
		gr=creation(nbLine);
		nbLine=0;
		while (fgets(line, 128, fichier) != NULL) {
			if (nbLine > 1) {
				//fprintf(stdout,line);
				tok = NULL;
				tmp = 1;
				
				// nom
				tok = strtok(line, firstDelim);
				char x = tok[0];
				
				currentSommetGraph = (int) x-'A';
				creationVoisinGraph(gr, currentSommetGraph);
				
				//Creer une libListe par ligne
				
				int nom = currentSommetGraph; 
				// Intitule;
				tok = strtok(NULL, firstDelim);
				char intitule[40]; // = del(tok, '\'');
				strcpy(intitule, tok);
				
				while (tok != NULL) {
					tok = strtok(NULL, firstDelim);

					if(tok != NULL) {
						if(firstLine){
							char x = tok[0];
							poids = (int) x-'0';
							firstLine = 0;
							//gr->listeVoisin[nom]=ajouterVoisinAfter(&gr->listeVoisin[nom], nom, poids);
						}else{
							char x = tok[0];
							int sommet = (int) x-'A';							
							gr->listeVoisin[nom]=ajouterVoisin(&gr->listeVoisin[nom], sommet, 0);
						}
					}			
				}
				firstLine = 1;
				
				
			}
			gr->listevoisin[currentSommetGraph]=ajouterVoisin(&gr->listeVoisin[currentSommetGraph], currentSommetGraph, poids);
			nbLine++;
		}
	}
	//projet->nbMaxTaches=nbLine;
	fclose(fichier);
	return gr;
}
*/


/*
* Fonction : 	creationVoisinGraph
*
* Parametres : 	void creationVoisinGraph(Graph gr, int voisin)
*
* Retour : 		rien
*
* Description : Permet de créer un sommet qui délimite la fin de la lsite.
*
*/
void creationVoisinGraph(Graph gr, int voisin){
		gr->listeVoisin[voisin] = (listeAdjacences) malloc(sizeof(TypVoisins));
		gr->listeVoisin[voisin]->voisin = -1;
		gr->listeVoisin[voisin]->poids = 0;
}


/*
* Fonction : 	insertionVoisinGraph
*
* Parametres : 	void insertionVoisinGraph(TypGraph *gr, listeAdjacences voisin)
*
* Retour : 		rien
*
* Description : Permet d'inserer un tache dans le projet passé en paramètre.
*
*/
void insertionVoisinGraph(TypGraph *Graph, listeAdjacences voisin){
	int i = 0;	/* Entier iterateur */
	
	while (Graph->listeVoisin[i]->voisin != -1) {
		i++;
	}
	Graph->listeVoisin[i] = voisin;

}


/*
* Fonction : 	insertionArete
*
* Parametres : 	void insertionArete(Graph gr, int sommet1, int sommet2, int poid)
*
* Retour : 		rien
*
* Description : Permet d'inserer une arete.
*
*/
void insertionArete(Graph gr, int sommet1, int sommet2, int poid){
	gr->listeVoisin[sommet1] = ajouterVoisin(&gr->listeVoisin[sommet1], sommet2,poid);
	gr->listeVoisin[sommet2] = ajouterVoisin(&gr->listeVoisin[sommet2], sommet1,poid);
}


/*
* Fonction : 	suppressionVoisin
*
* Parametres : 	void suppressionVoisin
*
* Retour : 		rien
*
* Description : Permet de supprimer une tache.
*
*/
void suppressionVoisin(Graph gr, int sommet){
    int i;	/* Iterateur */
    
    free(gr->listeVoisin[sommet - 1]);
    gr->listeVoisin[sommet - 1] = NULL;
    
    //Parcours le projet pour suppr le tache dans toute les liaison
    for (i = 0; i < gr->nbMaxSommets; ++i) {
        if (gr->listeVoisin[i] != NULL && gr->listeVoisin[i]->voisin != -1) {
            gr->listeVoisin[i] = supprimeVoisin(gr->listeVoisin[i], sommet);
        }
    }
}


/*
* Fonction : 	suppressionArete
*
* Parametres : 	void suppressionArete(Graph gr, int sommet1, int sommet2, int poid)
*
* Retour : 		rien
*
* Description : Permet de supprimer une arete et son poids.
*
*/
void suppressionArete(Graph gr, int sommet1, int sommet2, int poid){
    /* On fait appel à la fonction supprimeDependance de liste.c */
    gr->listeVoisin[sommet1] = supprimerDependance(gr->listeVoisin[sommet1 - 1], sommet2, poid);
}


/*
* Fonction : 	affichage
*
* Parametres : 	void affichage(Graph gr, FILE *fichier)
*
* Retour : 		rien
*
* Description : Permet d'écrire la description du graphe dans le fichier.
*
*/

void affichage(Graph gr){
    int i;
    
    for(i = 0; i < gr->nbMaxSommets; ++i){
        if(gr->listeVoisin[i] != NULL){
            printf("%i : ",i);
            afficher(gr->listeVoisin[i]);
        }
    }
}

/*
void affichage(Graph gr, FILE *fichier){
	int i;	// Iterateur 
	
	fprintf(fichier, "# nombre maximum de taches\n");
	fprintf(fichier, "%i\n", projet->nbMaxSommets);
	fprintf(fichier, "# taches : taches\n");

	for (i = 0; i < gr->nbMaxSommets; ++i) {
		if (gr->listeVoisin[i] != NULL) {
			fprintf(fichier, "%i : ", i);
			afficher(gr->listeVoisin[i], fichier);
		}
	}
}
*/

/*
* Fonction : 	sauvegarde
*
* Parametres : 	void sauvegarde(Graph gr, char *urlFichierDest)
*
* Retour : 		rien
*
* Description : Permet de sauvegarder les informations du graphe dans un fichier passé en paramètre.
*
*/
/*
void sauvegarde(Graph gr, char *urlFichierDest){
	FILE *fichier;	// Fichier a ouvrir
	fichier = fopen(urlFichierDest, "w");
	affichage(gr, fichier);
	fclose(fichier);
}
*/

/*
* Fonction : 	del
*
* Parametres : 	char* del(char str[], char ch)
*
* Retour : 		str1
*
* Description : 
*
*/
/*
char* del(char str[], char ch){
	int i;		//  iterateur 
	int j=0;	// iterateur 
	int size;	// Entier taille de la chaine
	char ch1;	// char temporaire 
	char str1[10];	// chaine de caractere resultat 

	size=strlen(str);

	for(i=0;i<size;i++)
		{
		if(str[i] != ch)
		   {
		   ch1 = str[i];
		   str1[j] = ch1;
		   j++;
		   }
		}


	return str1;
}
*/

/*
* Fonction : 	creationInitFin
*
* Parametres : 	void creationInitFin(TypGraph *gr)
*
* Retour : 		rien
*
* Description : Permet de creer un sommet initial et final pondere a 0.
*
*/
/*
void creationInitFin(TypGraph *Graph){
	int i=0;						// iterateur 
	int tabOccur[Graph->nbMaxSommets];			// tableau d'occurence 
	creationVoisinGraph(Graph, Graph->nbMaxSommets);	
	int sommetInit = Graph->nbMaxSommets;			// tache initial
	Graph->nbMaxSommets++;
	creationVoisinGraph(Graph, Graph->nbMaxTaches);
	int sommetFin = Graph->nbMaxSommets;			// tache final
	Graph->nbMaxSommets++;
	listeAdjacences element;					// maillon de liste pour le parcours 
	element = (listeAdjacences) malloc(sizeof(TypGraph));
	
	//Creer tache pour init et fin avec intitule
	Graph->listeVoisin[sommetInit]=ajouterVoisin(&Graph->listeVoisin[sommetInit], sommetInit, 0);
	Graph->listeVoisin[sommetFin]=ajouterVoisin(&Graph->listeVoisin[sommetFin], sommetFin, 0);
	
	//Parcourir la liste d'adjacence et ajouter le noeud init en dependance au noeud qui n'ont pas de dependance ///TODOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	
	for(i = 0; i < Graph->nbMaxSommets-2; i++) {
		if(Graph->listeAdjacences[i]->voisinSuivant->voisin == -1) {
			Graph->listeVoisin[i]=ajouterVoisinAfter(&Graph->listeVoisin[i], sommetInit, 0);
		}
	}
	for(i = 0; i < Graph->nbMaxSommets-2; i++){
		tabOccur[i]=0;
	}
	
	for(i = 0; i < gr->nbMaxSommets-2; i++){
		element = gr->listeVoisin[i];
		while(element->voisin != -1){
			tabOccur[element->voisin]++;
			element=element->voisinSuivant;
		}
	}
	for(i = 0; i < gr->nbMaxVoisin-2; i++){
		if(tabOccur[i] == 1){
			gr->listeVoisin[sommetFin]=ajouterVoisinAfter(&gr->listeVoisin[sommetFin], i, 0);
		}
	}
	
}
*/


/*
* Fonction : 	getPoids
*
* Parametres : 	void getPoids
*
* Retour : 	rien
*
* Description : Permet de recupere les poids (valeurs) de chaques listes
*
*/
/*
void getPoids(Graph gr){
	int i;					// iterateur
	int tabPoids[gr->nbMaxSommets];	// tableau de duree
	listeAdjacences element;			// maillon de liste pour le parcours
	
	i = 0;
	element = (listeAdjacences) malloc(sizeof(TypGraph));
	for(i = 0; i < gr->nbMaxSommets; i++){
		tabPoids[i]=0;
	}
	
	for(i = 0; i < gr->nbMaxSommets; i++){
		element = gr->listeVoisin[i];
		while(element->Voisin != -1){
			if(element->poids > 0){
				tabPoids[element->voisin] = element->poids;
			}
			element=element->voisinSuivant;
		}
	}
	for(i = 0; i < gr->nbMaxSommets; i++){
		element = gr->listeVoisin[i];
		while(element->voisin != -1){
			element->poids = tabPoids[element->voisin];
			element = element->voisinSuivant;
		}
	}

}
*/


/*
* Fonction : 	poidsPetit
*
* Parametres : 	int poidsPetit(Graph gr, int debut, int fin)
*
* Retour : 	int
*
* Description : permet de retourner le poids min pour aller au dernier sommet
*
*/
/*
int poidsPetit(Graph gr, int debut, int fin) {
	listeAdjacences sommetCourant;	// maillon de liste tache courante
	listeAdjacences element;		// maillon de liste pour le parcours
	int min;			// entier minimum temporaire
	int poids;		// Entier la duree de la tache courante
	int elementMin;			// le numero de l'element min
	
	sommetCourant = (listeAdjacences) malloc(sizeof(TypGraph));
	
	sommetCourant = gr->listeVoisin[fin];
	poids = sommetCourant->poids;
	element = sommetCourant;
	
	min = 100000;
	
	while(element->voisin != -1) {
		if(element->voisin != fin && element->voisin != debut) {
			elementMin = poidsPetit(gr, debut, element->voisin);
			//printf("\nCourant: %d Element: %d  duree: %d, elementMin: %d\n", tacheCourante->tache, element->tache, element->dureeTache, elementMin);
			if(elementMin < min) min = elementMin;
		}
		element = element->voisinSuivant;
	}

	if(sommetCourant->sommetSuivant->voisin == debut) {
		return poids;
	} else {
		//printf("%d MIN: %d\n",fin,  min);
		return min + poids;
	}
}
*/

/*
* Fonction : 	poidsGrand
*
* Parametres : 	int poidsGrand(Graph gr, int debut, int fin) 
*
* Retour : 	int 
*
* Description : permet de retourner le poids maximum pour accomplir le sommet fin
*
*/
/*
int poidsGrand(Graph gr, int debut, int fin) {
	listeAdjacences sommetCourant;	// maillon de liste tache courante
	listeAdjacences element;		// maillon de liste pour le parcours
	int max;			// entier maximum temporaire
	int poids;		// Entier la duree de la tache courante
	int elementMax;			// le numero de l'element max
	
	sommetCourant = (listeAdjacences) malloc(sizeof(Graph));
	
	sommetCourant = gr->listeVoisin[fin];
	poids = sommetCourant->poids;
	element = sommetCourant;
	
	max = -1;
	
	while(element->voisin != -1) {
		if(element->voisin != fin && element->voisin != debut) {
			elementMax = poidsGrand(gr, debut, element->voisin);
			if(elementMax > max) max = elementMax;
		}
		element = element->voisinSuivant;
	}

	if(sommetCourant->voisinSuivant->voisin == debut) {
		return poids;
	} else {
		return max + poids;
	}
}
*/


/*
* Fonction : 	poidsCheminPlusCourt
*
* Parametres : 	int poidsCheminPlusCourt(Graph gr, int debut, int fin)
*
* Retour : 	int
*
* Description : permet de retourner la valeur minimum que mettra le graphe
*
*/
/*
int poidsCheminPlusCourt(Graph gr, int debut, int fin) {
	listeAdjacences sommetCourant;	// maillon de liste tache courante
	listeAdjacences element;		// maillon de liste pour le parcours
	int max;			// entier maximum temporaire
	int elementMax;			// le numero de l'element max
	int critique;			//le numero de l'element du chemin critique
	
	sommetCourant = (listeAdjacences) malloc(sizeof(Graph));
	
	sommetCourant = gr->listeVoisin[fin];
	element = sommetCourant;
	max = -1;
	
	while(element->voisin != -1) {
		if(element->voisin != fin && element->voisin != debut) {
			elementMax = poidsPetit(gr, debut, element->voisin);
			//printf(">%d\n", elementMax);
			if(elementMax > max) {
				max = elementMax;
				critique = element->voisin;
			}
		}
		element = element->voisinSuivant;
	}
	
	printf("Tache critique: %d\n", critique);
	return max;
}
*/


/*
* Fonction : 	dureeProjetPlusCourt
*
* Parametres : int poidsCheminPlusLong(Graph gr, int debut, int fin)
*
* Retour : 	int
*
* Description : permet de retourner la valeur maximum que mettra le graphe
*
*/
/*
int poidsCheminPlusLong(Graph gr, int debut, int fin) {
	listeAdjacences 	sommetCourant;	// maillon de liste tache courante
	listeAdjacences 	element;	// maillon de liste pour le parcours
	int 		max;		// le numero de l'element max
	int 		elementMax;	// le numero de l'element max
	int 		critique;	// le numero de l'element du chemin critique
	
	sommetCourant = (listeAdjacences) malloc(sizeof(TypGraph));
	
	sommetCourant = gr->listeVoisin[fin];
	element =sommetCourant;
	max = -1;
	
	while(element->voisin != -1) {
		if(element->voisin != fin && element->voisin != debut) {
			elementMax = poidsGrand(gr, debut, element->voisin);
			//printf(">%d\n", elementMax);
			if(elementMax > max) {
				max = elementMax;
				critique = element->voisin;
			}
		}
		element = element->voisinSuivant;
	}
	
	printf("Tache critique: %d\n", critique);
	return max;
}
*/



/*
* Fonction : 	dureeProjetPlusCourt
*
* Parametres : int cheminCritique(Graph gr, int debut, int fin, ListeAdjacences chemin)
*
* Retour : 	int
*
* Description : permet d'afficher le chemin critique
*
*/
/*
int cheminCritique(Graph gr, int debut, int fin, ListeAdjacences chemin) {
	listeAdjacences 	sommetCourant;		// maillon de liste tache courante
	listeAdjacences 	element;		// maillon de liste pour le parcours
	listeAdjacences		tmp;			// maillon de liste temporaire
	int 		max;			// le numero de l'element max
	int 		poids;			// Entier la duree de la tache courante
	int 		elementMax;		// le numero de l'element max
	
	
	sommetCourant = (listeAdjacences) malloc(sizeof(TypTache));
	
	sommetCourant = 	gr->listeVoisin[fin];
	poids = 	sommetCourant->poids;
	element = 		sommetCourant;
	
	max = -1;
	
	while(element->voisin != -1) {
		if(element->voisin != fin && element->voisin != debut) {
			elementMax = cheminCritique(gr, debut, element->voisin, chemin);
			if(elementMax > max) {
				max = elementMax;
				//tmp = element;
				//tmp->tacheSuivant = chemin;
				//chemin = tmp;
				printf(">Chemin: %d\n", element->voisin);
			}
		}
		element = element->voisinSuivant;
	}

	if(sommetCourant->voisinSuivant->voisin == debut) {
		return poids;
	} else {
		return max + poids;
	}
}
*/


/*
* Fonction : 	sommeDuree
*
* Parametres : 	int sommePoids(Graph gr)
*
* Retour : 	int
*
* Description : permet de faire la somme des poids du graphe 
*
*/
/*
int sommePoids(Graph gr){
	int res;	// Entier resultat de la somme
	int i;		// iterateur
	
	res = 0;
	
	for(i=0;i<gr->nbMaxSommets; i++){
		res=res+gr->listeVoisin[i]->poids;
	}
	return res;
}
*/


/*
* Fonction : 	cheminCritiqueLong
*
* Parametres : 	int cheminCritiqueLong(Graph gr, int debut, int fin) 
*
* Retour : 	int
*
* Description :	permet d'afficher le poids le plus long pour un chemin critique
*
*/
/*
int cheminCritiqueLong(Graph gr, int debut, int fin) {
	listeAdjacences 	sommetCourant;		// maillon de liste tache courante
	listeAdjacences 	element;		// maillon de liste pour le parcours
	listeAdjacences 	tmp;			// maillon de liste temporaire
	int 		max;			// Entier maximum temporaire
	int 		poids;	// Entier correspondant a la tache courante
	int 		elementMax;		// Entier element Maximum
	int 		loop;			// Entier pour la boucle while
	int 		critique;		// Entier correspondant a la tache du chemin critique
	
	tmp = 		(listeAdjacences) malloc(sizeof(TypGraph));
	sommetCourant = (listeAdjacences) malloc(sizeof(TypGraph));
	
	sommetCourant =	 	gr->listeVoisin[fin];
	poids = 	sommetCourant->poids;
	element = 		sommetCourant;
	
	critique = 	fin;
	max = 		-1;
	loop = 		1;
	
	sommetCourant = gr->listeVoisin[critique];
	element = 	sommetCourant;

	printf("[%d]", gr->nbMaxSommets-1);
	printf(" <= [%d]", fin);

	while(loop == 1) {
		//tacheCourante = (ListeTaches) malloc(sizeof(TypTache));
		//printf("Courant: %d\n", element->tache);
		
		max = -1;
		
		while(element->voisin != -1) {
			if(element->voisin != fin && element->voisin != debut) {
				elementMax = poidsGrand(gr, debut, element->voisin);
				//printf(">%d\n", elementMax);
				if(elementMax > max) {
					max = elementMax;
					critique = element->voisin;
					tmp = element;
				}
			}
			element = element->voisinSuivant;
		}
		
		printf(" <= [%d]", critique);
		tmp=ajouterVoisinAfter(&tmp, critique, gr->listeVoisin[critique]->poids);
		
		element = gr->listeVoisin[critique]->voisinSuivant;
		//printf(" Suivant: %d\n", element->tache);
		if(element->voisin == -1 || element->voisin == debut) loop=0;
	}
		printf(" <= [%d]", debut);
	return 0;
}
*/


/*
* Fonction : 	cheminCritiqueCourt
*
* Parametres : 	int cheminCritiqueCourt(Graph gr, int debut, int fin)
*
* Retour : 	int
*
* Description :	permet d'afficher le poids le plus court pour un chemin critique
*
*/
/*
int cheminCritiqueCourt(Graph gr, int debut, int fin) {
	listeAdjacences 	sommetCourant;		// maillon de liste tache courante
	listeAdjacences 	element;		// maillon de liste pour le parcours
	listeAdjacences 	tmp;			// maillon de liste temporaire
	listeAdjacences 	chemin;
	int 		max;			// Entier maximum temporaire
	int 		poids;	/* Entier correspondant a la tache courante
	int 		elementMax;		// Entier element Maximum
	int 		loop;			// Entier pour la boucle while 
	int 		critique;		// Entier correspondant a la tache du chemin critique
	
	sommetCourant = (listeAdjacences) malloc(sizeof(TypGraph));
	chemin = 	(ListeAdjacences) malloc(gr->nbMaxSommets * sizeof(TypGraph));
	
	critique = 	fin;
	loop = 1;
	
	sommetCourant = gr->listeVoisin[critique];
	element = sommetCourant;
	printf("[%d]", gr->nbMaxSommets-1);
	printf(" <= [%d]", fin);
	//chemin = ajouterTache(chemin, projet->tacheProjet[fin]->tache, 0);
	while(loop == 1) {
		//tacheCourante = (ListeTaches) malloc(sizeof(TypTache));
		//printf("Courant: %d\n", element->tache);
		
		max = 100000;
		
		while(element->voisin != -1) {
			if(element->voisin != fin && element->voisin != debut) {
				elementMax = poidsPetit(gr, debut, element->voisin);
				//printf(">Element %d | Duree: %d\n", element->tache, elementMax);
				if(elementMax < max) {
					max = elementMax;
					critique = element->voisin;
					//printf(" -%d|%d- ", element->tache, max);
				}
			}
			element = element->voisinSuivant;
		}
		
		//chemin = ajouterTache(chemin , tmp->tache,tmp->dureeTache);
		printf(" <= [%d]", critique);
		element = gr->listeVoisin[critique]->voisinSuivant;
		//printf(" Suivant: %d\n", element->tache);
		if(element->voisin == -1 || element->voisin == debut) loop=0;
	}
	printf(" <= [%d]", debut);
	return 0;
}
*/
