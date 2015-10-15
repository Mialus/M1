﻿#ifndef GRAPH_H
#define GRAPH_H

#include "list.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

typedef int bool;
enum { false, true };

typedef struct {
         int voisin;
         int* voisinSuivant;
         int* voisinprecedent;
} TypVoisins;

typedef struct {
         bool estOriente ; 
         int nbrSommet;
         TypVoisins* listesAdjacences;
         int sizealpha;
         liste*** trans;
} TypGraphe;

typedef struct arretes{
    int sommet1;
	int sommet2;
    struct arretes* suiv;
} arrete;

typedef struct listeSom{
    int sommet;
    struct listeSom* suiv;
} listeSommets;

TypGraphe* creerGraphe();
  
arrete* insertionArrete(arrete* liste, int sommet1, int sommet2);
void ajouteArete(TypGraphe* g1,int sommet1,int sommet2,int val);
void supprimeArete(TypGraphe* g1,int sommet1,int sommet2,int val);
void afficheGraphe(TypGraphe* g1);
void affichageArrete(arrete* liste);
void supprimeSommet(TypGraphe* g1, int sommet1);
TypGraphe* construitGrapheTest();
TypGraphe* initGraphe(TypGraphe* g1,int nbSommet);
TypGraphe* construitGraphe(TypGraphe* g1, int nbSommet, int sommet);



#endif
