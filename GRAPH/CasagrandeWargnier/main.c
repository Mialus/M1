#include "Graph.h"
#include "list.h"

int menu(int* choix)
{
  printf("\n -------- MENU ------ \n");
  printf("Afficher graphe test          tapez 1\n");
  printf("Création d'un graphe          tapez 2\n");
  printf("Pour supprimer une arete      tapez 3\n");
  printf("Pour supprimer un sommet      tapez 4\n");
  printf("Afficher graphe               tapez 5\n");
       
  printf("Sinon taper 0\n");
  scanf("%d",&choix);
  
  return choix; 
}


int main() 
{
  //Initialisation du graphe
  TypGraphe* g1;
  TypGraphe* g2 = construitGrapheTest();
  
  //Création des variables
  int choix;
  int boucle=0;
  int transition;
  int valeurArete;
  int sommetDepart=0;
  int sommetArrive=0;
  int suppSommet;
  char *s = malloc (sizeof (*s) * 256);
  //char nbSommet[10];
  int nbSommet;
  int continuer=1;
  
    //Menu
	while(boucle==0){  
		choix=menu(choix); 
		
		switch (choix)
		{
		case 1:
			afficheGraphe(g2);
			break;  
		case 2:
			printf("Combien d'état voulez vous créer ?");
			//lire(nbSommet,10);
			nbSommet = 3;
			//strtoul(nbSommet,NULL,10));
			//printf("\n\n %s \n\n",nbSommet);
			g1 = initGraphe(g1,nbSommet);
			printf("Voulez vous ajoutez une arete au graphe? (1/0)");
			//scanf("%d\n",&continuer);
			while(continuer == 1){
			    
			    printf("\nDepuis quelle sommet ? ");
			    //scanf("%d",&sommetDepart);
			
			    printf("Vers quelle sommet ?");
			   // scanf("%d\n",&sommetArrive);
			
			    printf("Quelle valeur ajoute-t-on à l'arete ?");
			   // scanf("%d\n",&valeurArete);
			
			    ajouteArete(g1, sommetDepart, sommetArrive, valeurArete);
			    afficheGraphe(g1);
			    printf("Voulez vous ajoutez une arete au graphe? (1/0)");
			scanf("%d\n",&continuer);
			
			}
			    
			break;
		case 3:
			printf("\nDepuis quelle sommet ? ");
			//scanf("%d",&sommetDepart);
			
			printf("\nVers quelle sommet ? ");
			//scanf("%d",&sommetArrive);
			
			printf("\nQuelle valeur supprime t-on ?");
			//scanf("%d",&valeurArete);
			
			supprimeArete(g1,sommetDepart, sommetArrive,valeurArete);
			afficheGraphe(g1);
			break;
		
		case 4:
		    printf("Quel sommet supprime t-on ?");
			//scanf("%d",&suppSommet);
			
			//supprimeSommet(g2, suppSommet);
			
			printf("\n\n----- Graphe après suppression du sommet ----\n");
			afficheGraphe(g2);
			break;
		    	
		case 5 :
		    afficheGraphe(g1);
		case 0 :
			printf("Merci d avoir utilise ce programme, a la prochaine !");
			boucle=1;
			break;
		default : choix=menu(choix);
		}
		
	}
  return 0;
  
}

