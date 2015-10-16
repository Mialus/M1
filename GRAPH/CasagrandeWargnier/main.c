#include "graph.h"
#include "list.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>


/*
* Fonction : 	flush
*
* Parametres : 	rien
*
* Retour : 		rien
*
* Description : Permet l'utilisation de scanf
*
*/
void flush(){
	while(getchar() != '\n')
		continue;
}


/*
* Fonction : 	main
*
* Parametres : 	rien
*
* Retour : 		Valeur de sortie : 0
*
* Description : Main du programme avec menu
*
*/
int main() {

  //Création des variables
  int choix;
  int boucle=0;
  int transition;
  int valeurArete;
  int sommetDepart;
  int sommetArrive;
  int suppSommet;
  int suppArete;
  //char nbSommet[10];
  int nbSommet;
  int continuer=1;
  char nomFichier[50]; /* Nom de fichier choisi par l'utilisateur */
  FILE *fichier; /* Fichier ouvert par l'utilisateur */
  Graph gr;
  
  
    //Menu
	while(boucle==0){  
            printf("\n -------- MENU ------ \n");
            printf("Creer un graphe                 tapez 1\n");
            printf("Lire un graphe dans un fichier  tapez 2\n");
            printf("Inserer un sommet               tapez 3\n");
            printf("Inserer une arete               tapez 4\n");
            printf("Supprimer un sommet             tapez 5\n");
            printf("Supprimer une arete             tapez 6\n");
            printf("Afficher un graphe              tapez 7\n");
            printf("Sauvegarder un graphe           tapez 8\n\n");
            printf("Quitter                         taper 0\n\n\n");
            scanf("%d",&choix);
		
		switch (choix)
		{
		case 1:
		    printf("combien d'état voulez vous créer ?\n");
            	    scanf("%d",&nbSommet);
	   	    flush();
            	    gr=creation(nbSommet);
                    
                    printf("Voulez-vous créer des Arete ? 0/1\n");
                    scanf("%d", &continuer);
                    
                    while(continuer==1){   
                        printf("Depuis quelle sommet ?\n");
                        scanf("%d",&sommetDepart);

                        printf("\nVers quelle sommet ?\n");
                        scanf("%d",&sommetArrive);

                        if(gr->estOriente==1){
                        printf("\nQuelle est le poids de l'arete ?\n");
                        scanf("%d",&valeurArete);
                        }else{
                            valeurArete=-1;
                        }
                        //fonction qui insère une arete
                        insertionArete(gr,sommetDepart,sommetArrive, valeurArete);

                        //printf("\n\n----- Graphe après ajout d'une arete ----\n");
                        //afficher le graphe
                                    //affichage(gr, stdout);
                       //affichage(gr);
                        printf("\nVoulez vous ajouter une arete au graphe ? (1/0)\n");
                       scanf("%d", &continuer);
                   }
			break;  
		case 2:
		    printf("Entrez le chemin d'accès au fichier a charger : \n");
            scanf("%s", nomFichier);
            //gr = lecture(nomFichier);
			//creationInitFin(gr);
			//getPoids(gr);
			printf("Fichier charger avec succes.\n");
			flush();
        	break;
		case 3:
			printf("\nDepuis quelle sommet ? ");
			scanf("%d",&sommetDepart);
			
			printf("\nVers quelle sommet ? ");
			scanf("%d",&sommetArrive);
			
			printf("\nQuelle valeur supprime t-on ?\n");
			scanf("%d",&valeurArete);
			
			//fonction qui insère un sommet
			//creationVoisinGraph(Graph gr, int voisin)
			//insertionVoisinGraph(gr, listeAdjacences voisin);
			
			//afficher le graphe
			//affichage(gr, stdout);
			break;
		case 4:
		    printf("Etes vous sur de vouloir ajouter une arete au graphe? (1/0)\n");
            scanf("%d",&continuer);
            printf("test : %d\n", continuer);
                    
            while(continuer==1){   
                printf("\nDepuis quelle sommet ?");
                scanf("%d",&sommetDepart);
                        
                printf("\nVers quelle sommet ?");
                scanf("%d",&sommetArrive);
                        
                printf("\nQuelle est le poids de l'arete ?");
                scanf("%d",&valeurArete);
                
                //fonction qui insère une arete
                //insertionDependance(gr,sommetDepart,sommetArrive, valeurArete);
                
                printf("\n\n----- Graphe après ajout d'une arete ----\n");
                //afficher le graphe
			    //affichage(gr, stdout);
                        
                printf("Voulez vous ajouter un arete au graphe ? (1/0)");
               scanf("%d", &continuer);
           }
                    
           break;            	
		case 5 :         
		  printf("Quel sommet supprime t-on ?");
		  scanf("%d",&suppSommet);
		  
		  //Fonction qui supprime un sommet du graphe
		  //suppressionVoisinGraph(gr, suppSommet);
			
		  printf("\n\n----- Graphe après suppression du sommet ----\n");
		  //afficher le graphe
	      //affichage(gr, stdout);  
		  break;
	    case 6 :
	      printf("\nDepuis quelle sommet ?");
          scanf("%d",&sommetDepart);
                        
          printf("\nVers quelle sommet ?");
          scanf("%d",&sommetArrive);
          
		  printf("Quelle arete supprime t-on ?");
		  scanf("%d",&suppArete);
		  
		  //focntion qui supprime une arete
		  //suppressionDependance(gr, sommetDepart,sommetArrive,suppArete);
			
		  printf("\n\n----- Graphe après suppression d'une arete ----\n");
		  
		  //afficher le graphe
	      //affichage(gr, stdout);
		  break;
	    case 7 :
		   //affichage(gr, stdout);
           break;
		case 8 :
		    printf("Entrez le nom du nom du fichier de sauvegarde : ");
            scanf("%s", nomFichier);
            flush();
            fichier = fopen(nomFichier, "w");
            //affichage(gr, fichier);
            fclose(fichier);
            printf("Fichier enregistre dans : %s", nomFichier);
            break;
		case 0 :
			printf("Merci d avoir utilise ce programme, a la prochaine !\n");
			boucle=1;
			break;
		default : break;
		}
		
	}
  return 0;
  
}

