#include "list.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void viderBuffer()
{
    int c = 0;
    while (c != '\n' && c != EOF)
    {
        c = getchar();
    }
}
 
int lire(char *chaine, int longueur)
{
    char *positionEntree = NULL;
 
    if (fgets(chaine, longueur, stdin) != NULL)
    {
        positionEntree = strchr(chaine, '\n');
        if (positionEntree != NULL)
        {
            *positionEntree = '\0';
        }
        else
        {
            viderBuffer();
        }
        return 1;
    }
    else
    {
        viderBuffer();
        return 0;
    }
}


void ajouteListe(liste** liste1, int st2) 
{
  liste* pt1;
  liste* tmp;
  pt1 = *liste1;
  if(!pt1) 
    {
    pt1 = (liste*) malloc(sizeof(liste));
    pt1->state = st2;
    pt1->suiv=NULL;
    *liste1 = pt1;
    return;
    }
  if(pt1->state == st2) 
    {
    return;
    }
  if(st2 < pt1->state) 
    {
      tmp = *liste1;
      *liste1 = (liste*) malloc(sizeof(liste));
      (*liste1)-> state = st2;
      (*liste1)->suiv = tmp;
      return;
    }
  while(pt1->suiv && pt1->suiv->state < st2) 
    {
      pt1 = pt1->suiv;
    }
  if(!pt1->suiv) 
    {
      pt1->suiv=(liste*) malloc(sizeof(liste));
      pt1=pt1->suiv;
      pt1->state = st2;
      pt1->suiv=NULL;
      return;
    }
  if(pt1->suiv->state == st2) 
    {
      return;
    }
  tmp = pt1->suiv;
  pt1->suiv=(liste*) malloc(sizeof(liste));
  pt1 = pt1->suiv;
  pt1->state = st2;
  pt1->suiv = tmp;
}

void supprimeListe(liste** liste1, int st2) 
{
  liste* interm1;
  liste* varSuppr;
  liste* interm2;
  
  interm1 = *liste1;
  if(interm1 == NULL) 
  {
    return;
  }
  if(interm1->state == st2) 
  {
    varSuppr = interm1;
    if(interm1->suiv != NULL)
    {
      interm1 = interm1->suiv;
      *liste1 = interm1;
    }
    else
    {
      *liste1 = NULL;
    }
    free(varSuppr);
  }
  else
  {
    interm2 = interm1->suiv;
    while(interm2 != NULL)
    {
      if(interm2->state != st2)
      {
        interm1 = interm1->suiv;
      }
      else
      {
        varSuppr = interm2;
        if(interm2->suiv != NULL)
        {
          interm2 = interm2->suiv;
          interm1->suiv = interm2;
        }
        else
        {
          interm1->suiv = NULL;
        }
        free(varSuppr);
      }
      interm2 = interm1->suiv;
    }
  }
}
