#include "Graph.h"

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

//Fonction qui insere une arrete dans un graphe
arrete* insertionArrete(arrete* liste, int sommet1, int sommet2)
{
	arrete* newElement = malloc(sizeof(arrete));
	newElement->sommet1 = sommet1;
    newElement->sommet2 = sommet2;
	newElement->suiv = liste;
	liste = newElement;
	return liste;
}

//Fonction intermédiaire permettant de faire passer une partie du graphe à la fonction ajoute liste.
void ajouteArete(TypGraphe* g1, int sommet1, int sommet2, int val){
    ajouteListe(&g1->trans[sommet1][val], sommet2); 
} 

void supprimeArete(TypGraphe* g1, int sommet1, int sommet2, int val){
    supprimeListe(&g1->trans[sommet1][val], sommet2); 
} 

//Fonction qui affiche un graphe
void afficheGraphe(TypGraphe* g1)
{
  int i, j;
  liste* transition;
  
  printf("\nLes transitions : \n---------------------------\n");
  for(i = 0; i < g1->nbrSommet; i++){
    printf("Depuis le sommet %d : \n", i);
    for(j = 0; j < g1->sizealpha; j++) {
      transition = g1->trans[i][j];
      
      if(transition != NULL) {
        printf("    Avec la valeur %d : \n", j);
      }
      
      while(transition != NULL) {
        printf("                 vers le sommet %d\n", transition->state);
        transition = transition->suiv;
      }
    }
  }
}

//Fonction qui affiche les arretes d'un graphe
void affichageArrete(arrete* liste)
{
    arrete* arreteActuelle = liste;

    while (arreteActuelle != NULL){
        printf("%d \n", arreteActuelle->sommet1);
		printf("%d \n", arreteActuelle->sommet2);
        arreteActuelle = arreteActuelle->suiv;
    }
}


//Fonction qui supprime un sommet 
void supprimeSommet(TypGraphe *g1, int sommet1)
{
  liste* interm1;
  int val;
  int i;
  for(val = 0; val < g1->sizealpha; val++){
	interm1 = g1->trans[sommet1][val];
    while(interm1 != NULL) {
      supprimeArete(g1, sommet1, interm1->state, val);
	  interm1 = g1->trans[sommet1][val];
    }
  }
  
  for(i = 0; i < g1->nbrSommet; i++){
	for(val = 0; val < g1->sizealpha; val++){
		interm1 = g1->trans[i][val];
		while(interm1 != NULL){
			if(interm1->state == sommet1){
				supprimeArete(g1, i, sommet1, val);
				interm1 = g1->trans[i][val];
			}
			else{
				interm1 = interm1->suiv;
			}
		}
	}
  }
}


//Fonction qui construit un graphe test avec des aretes et sommets déjà définis
TypGraphe* construitGrapheTest(){
  TypGraphe* g2 = (TypGraphe*) malloc(sizeof(TypGraphe));
  int i,j;
  g2->nbrSommet = 5;
  g2->sizealpha = 13;
  g2->trans = (liste***) malloc(g2->nbrSommet*sizeof(liste**));
  
  for(i = 0; i < g2->nbrSommet; i++) {
    g2->trans[i] = (liste**) malloc(g2->sizealpha*sizeof(liste*));
    for(j = 0; j < g2->sizealpha; j++){
      g2->trans[i][j] = NULL;
    }  
  }
  
  ajouteArete(g2, 0, 2, 2);
  ajouteArete(g2, 0, 1, 5);
  ajouteArete(g2, 1, 3, 1);
  ajouteArete(g2, 2, 3, 9);
  ajouteArete(g2, 3, 4, 12);
  ajouteArete(g2, 4, 1, 6);
  ajouteArete(g2, 4, 2, 8);
  return g2; 
}

TypGraphe* initGraphe(TypGraphe* g1,int nbSommet){
  
  int i,j;
  g1->nbrSommet = nbSommet;
  g1->sizealpha = 15;
  g1->trans = (liste***) malloc(g1->nbrSommet*sizeof(liste**));
  
  for(i = 0; i < g1->nbrSommet; i++) {
    g1->trans[i] = (liste**) malloc(g1->sizealpha*sizeof(liste*));
    for(j = 0; j < g1->sizealpha; j++){
      g1->trans[i][j] = NULL;
    }  
  }
  return g1;
}

TypGraphe* construitGraphe(TypGraphe* g1, int nbSommet, int sommet){
  int i,j;
  
  if(sommet<nbSommet-1){
    ajouteArete(g1, 0, 2, 2);
  }
  return g1; 
}
    


