#ifndef LIST_H
#define LIST_H

#include "stdlib.h"
#include "stdio.h"
#include "string.h"

typedef struct s_liste {
    int state;
    struct s_liste* suiv;
} liste;
  
void ajouteListe(liste** liste1, int st2);
void supprimeListe(liste** liste1, int st2);
void viderBuffer();
int lire(char *chaine, int longueur);
  
#endif
