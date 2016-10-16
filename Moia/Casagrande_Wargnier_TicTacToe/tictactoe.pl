/* -*- Mode:Prolog; coding:iso-8859-1; -*- */
:- use_module(library(lists)).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                                   TIC-TAC-TOE ULTIMATE GAME 2.0
%                                       CASAGRANDE ANTHONY
%                                         WARGNIER Pierre
%                                           PROJET MOIA
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                                       MENU DU JEU 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% tictactoe
% Pour commencer a jouer au jeu.
tictactoe :-
        nl,
        write('================================='), nl,
        write('= TIC-TAC-TOE ULTIMATE GAME 2.0 ='), nl,
        write('================================='), nl, nl,
        write('Bienvenu au jeu Tic Tac Toe, un jeu de reflexion '), nl, nl,
        choixDuSymbole. % L'utilisateur choisi son symbole de depart

        
    
% choixSymbole
% On demande à l'utilisateur qu'elle symbole il veut pour la partie (Croix ou Rond)
choixDuSymbole :-
        nl, write('Quel symbole voulez vous ? (x ou o)'), nl,
        read(Joueur), nl,
        (
           % Si le symbole n'est pas bon -> erreur
           % On redemande a l'utilisateur de rechoisir le symbole
           Joueur \= o, Joueur \= x, !,     
           write('Erreur sur le symbole !'), nl,
           choixDuSymbole                     
           ;
           
           % On initialise le tableau à vide pour commencer
           PlateauVide = [[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0]],
           
           % Une fois le symbole choisi, on affiche le Plateau et la partie peut commencer 
           afficherPlateau(PlateauVide), nl,   
           jouer([x, play, 0, PlateauVide], Joueur)
        ).


% jouer(+Position, +JoueurHomme)
% Choix du coup de l'humain
jouer([Joueur, play, DernierCoup, Plateau], Joueur) :- !,
        nl,
        % On regarde si c'est le 1er coup, l'utilisateur choisi le sous-plateau et sa case
        (
           DernierCoup = 0,   
           !,
           
           % Dans un 1er temps on demande de choisir sur quelle sous-plateau jouer.
           write('Quel plateau ?'), nl,   
           read(PetitPlateau), nl
        ;
           nth1(DernierCoup,Plateau,PetitPlateau),
           petitPlateauPlein(PetitPlateau),
           
           % Ensuite, on choisi sur quel case jouer dans le petit plateau.
           write('Quel plateau ?'), nl,   
           read(PetitPlateau), nl
        ;
           PetitPlateau = DernierCoup
        ),
        
        % Si ce n'est pas le 1er coup, alors on lui demande de selectionner directement la case
        nl, write('Ou voulez vous jouer ?'),nl,  
        read(Case), nl,                             
        (
           deplacementHumain([Joueur, play, PetitPlateau, Plateau], [JoueurSuivant, Etat, CoupSuivant, PlateauSuivant], PetitPlateau, Case), !,
           afficherPlateau(PlateauSuivant),
           (
              % Si le joueur gagne, on l'affiche et on arrte a partie !
              Etat = win, !,                            
              nl, write('FIN DE PARTIE : '),
              write(Joueur), write(' GAGNE !'), nl, nl
           ;
              
              Etat = nul, !,                           
              nl, write('FIN DE PARTIE : '),
              write(' NUL !'), nl,
              
              % On compte le nombre de plateau gagné
              cpt_Plateau_gagne(Joueur, PlateauSuivant, ValJoueur),
              write(Joueur), write(' : '), write(ValJoueur), write(' Plateau'), nl,
              cpt_Plateau_gagne(JoueurSuivant, PlateauSuivant, ValNext),  
              write(Joueur), write(' : '), write(ValNext), write(' Plateau'), nl
           ;
              % Sinon on continue la partie
              jouer([JoueurSuivant, play, CoupSuivant, PlateauSuivant], Joueur)
           )
        ;
           % Si la case chois n'est pas bonne, on affiche une erreur et il doit choisir une nouvelle case
           write('-> Mauvaise case !'), nl,                
           jouer([Joueur, play, DernierCoup, Plateau], Joueur)
        ).


% jouer(+Position, +JoueurHomme)
% Lorsque l'IA joue.
% L'IA choisi le meilleure coup grace à min max.
jouer([Joueur, play, DernierCoup, Plateau], JoueurHumain) :-
            nl, write('En attente....IA joue '), nl, nl,
            
            % L'IA choisi la meilleure case possible
            meilleurCoup([Joueur, play, DernierCoup, Plateau], [JoueurSuivant, Etat, CoupSuivant, PlateauSuivant]),
            
            % On affiche ensuite la plateau avec le meilleure coup de l'IA
            afficherPlateau(PlateauSuivant),
            (
               % Si l'IA gagne, on l'affiche et on arrete a partie !
               Etat = win, !,                                 
               nl, write('FIN DE PARTIE : '),
               write(Joueur), write(' GAGNE !'), nl, nl
            ;
               Etat = nul, !,                               
               nl, write('FIN DE PARTIE : '), write(' nul !'), nl, nl
            ;
               % Sinon on continue la partie
               jouer([JoueurSuivant, play, CoupSuivant, PlateauSuivant], JoueurHumain)  
        ).



% deplacementHumain
% Quand l'humain joue
deplacementHumain([X1, play, PetitPlateau, Plateau], [X2, Etat, Case, PlateauSuivant], PetitPlateau, Case) :-
    joueurSuivant(X1, X2),
    
    % Remplace dans le Plateau par le o ou x(x1) que si c'est un 0 avant
    setPlateau(PetitPlateau, Case, X1, Plateau, PlateauSuivant),
    (
      gagnerPetitPlateau(X1, PlateauSuivant), !, Etat = win ;
      dessinerGrandPlateau(PlateauSuivant), !, Etat = nul ;
      Etat = play
    ).
    

setPlateau(1, Cell, Joueur, [PetitPlateau|Plateau], [PetitPlateauSuivant|Plateau]) :-
        !,
        setPetitPlateau(Cell,Joueur,PetitPlateau,PetitPlateauSuivant).

setPlateau(NbPlateau, Cell, Joueur, [PetitPlateau|Plateau], [PetitPlateau|PlateauSuivant]) :-
        NewNbB is NbPlateau - 1,
        setPlateau(NewNbB, Cell, Joueur, Plateau, PlateauSuivant).    


setPetitPlateau(1, Joueur, [0|PetitPlateau], [Joueur|PetitPlateau]):-
        !.
setPetitPlateau(Nb, Joueur, [X|PetitPlateau], [X|PetitPlateauSuivant]):-
        Nb > 1,
        NbSuivant is Nb - 1,
        setPetitPlateau(NbSuivant, Joueur, PetitPlateau, PetitPlateauSuivant).







%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                                       AFFICHAGE DU JEU
%
% L'affichage du jeu se fera en 2 partie, l'une pour le grand plateau du tic tac toe, 
% et l'autre pour afficher les cases du sous plateau. Une fonction fonction ecrira le symbole dans plateau
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% afficherPlateau(+Plateau)
% On affiche le plateau dans son ensemble. Et les case sont gerer dans la fonction afficherPetitPlateau.
afficherPlateau([X1,X2,X3,X4,X5,X6,X7,X8,X9]) :-
        nl,
        write('   '), 
        afficherPetitPlateau(X1,1), 
        write(' | '), 
        afficherPetitPlateau(X2,1), 
        write(' | '), 
        afficherPetitPlateau(X3,1), nl,
        write('   '), 
        afficherPetitPlateau(X1,2), 
        write(' | '), 
        afficherPetitPlateau(X2,2), 
        write(' | '), 
        afficherPetitPlateau(X3,2), nl,
        write('   '), 
        afficherPetitPlateau(X1,3), 
        write(' | '), 
        afficherPetitPlateau(X2,3), 
        write(' | '), 
        afficherPetitPlateau(X3,3), nl,
        write('  -----------------------'), nl,
        write('   '), 
        afficherPetitPlateau(X4,1), 
        write(' | '), 
        afficherPetitPlateau(X5,1), 
        write(' | '), 
        afficherPetitPlateau(X6,1), nl,
        write('   '), 
        afficherPetitPlateau(X4,2), 
        write(' | '), 
        afficherPetitPlateau(X5,2), 
        write(' | '), 
        afficherPetitPlateau(X6,2), nl,
        write('   '), 
        afficherPetitPlateau(X4,3), 
        write(' | '), 
        afficherPetitPlateau(X5,3), 
        write(' | '), 
        afficherPetitPlateau(X6,3), nl,
        write('  -----------------------'), nl,
        write('   '), 
        afficherPetitPlateau(X7,1), 
        write(' | '), 
        afficherPetitPlateau(X8,1), 
        write(' | '), 
        afficherPetitPlateau(X9,1), nl,
        write('   '), 
        afficherPetitPlateau(X7,2), 
        write(' | '), 
        afficherPetitPlateau(X8,2), 
        write(' | '), 
        afficherPetitPlateau(X9,2), nl,
        write('   '), 
        afficherPetitPlateau(X7,3), 
        write(' | '), 
        afficherPetitPlateau(X8,3), 
        write(' | '), 
        afficherPetitPlateau(X9,3), nl.

% afficherLilPlateau(+LilPlateau, +N)
% Write the N-line of the LilPlateau to current outupt
% Remplace le 0 par ' '.
afficherPetitPlateau([X1,X2,X3,_,_,_,_,_,_],1) :-
        ecrireSymbole(X1),write(' '),ecrireSymbole(X2),write(' '),ecrireSymbole(X3).
afficherPetitPlateau([_,_,_,X1,X2,X3,_,_,_],2) :-
        ecrireSymbole(X1),write(' '),ecrireSymbole(X2),write(' '),ecrireSymbole(X3).
afficherPetitPlateau([_,_,_,_,_,_,X1,X2,X3],3) :-
        ecrireSymbole(X1),write(' '),ecrireSymbole(X2),write(' '),ecrireSymbole(X3).


% ecrireSymbole(+X)
% On ecrit le symbole du joueur dans la case ou vide ' ' à l'inialisation
ecrireSymbole(X):-
        X = 0, !,
        write(' ').

ecrireSymbole(X) :-
        write(X).





%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%ù
%                                      GESTION DE LA VICTOIRE  
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% On verifie si il y a un gagnant sur le grand Plateau. pour chaque victoire possible
gagnerGrandPlateau(Joueur,[X1, X2, X3,_,_,_,_,_,_]) :-
    gagnerPetitPlateau(Joueur,X1),
    gagnerPetitPlateau(Joueur,X2),
    gagnerPetitPlateau(Joueur,X3).

gagnerGrandPlateau(Joueur,[_,_,_,X4,X5,X6,_,_,_]) :-
    gagnerPetitPlateau(Joueur,X4),
    gagnerPetitPlateau(Joueur,X5),
    gagnerPetitPlateau(Joueur,X6).
    
gagnerGrandPlateau(Joueur,[_,_,_,_,_,_,X7,X8,X9]) :-
    gagnerPetitPlateau(Joueur,X7),
    gagnerPetitPlateau(Joueur,X8),
    gagnerPetitPlateau(Joueur,X9).

gagnerGrandPlateau(Joueur,[X1,_,_,_,X5,_,_,_,X9]) :-
    gagnerPetitPlateau(Joueur,X1),
    gagnerPetitPlateau(Joueur,X5),
    gagnerPetitPlateau(Joueur,X9).

gagnerGrandPlateau(Joueur,[_,X2,_,_,X5,_,_,X8,_]) :-
    gagnerPetitPlateau(Joueur,X2),
    gagnerPetitPlateau(Joueur,X5),
    gagnerPetitPlateau(Joueur,X8).

gagnerGrandPlateau(Joueur,[_,_,X3,_,_,X6,_,_,X9]) :-
    gagnerPetitPlateau(Joueur,X3),
    gagnerPetitPlateau(Joueur,X6),
    gagnerPetitPlateau(Joueur,X9).

gagnerGrandPlateau(Joueur,[X1,_,_,X4,_,_,X7,_,_]) :-
    gagnerPetitPlateau(Joueur,X1),
    gagnerPetitPlateau(Joueur,X4),
    gagnerPetitPlateau(Joueur,X7).

gagnerGrandPlateau(Joueur,[_,_,X3,_,X5,_,X7,_,_]) :-
    gagnerPetitPlateau(Joueur,X3),
    gagnerPetitPlateau(Joueur,X5),
    gagnerPetitPlateau(Joueur,X7).

% gagnerPetitPlateau(+Joueur, +Plateau)
% Vrai si le Joueur gagne un petit plateau.
gagnerPetitPlateau(Joueur,[X1, X2, X3, X4, X5, X6, X7, X8, X9]) :-
    egalite(X1, X2, X3, Joueur) ;    % 1ère ligne
    egalite(X4, X5, X6, Joueur) ;    % 2ème ligne
    egalite(X7, X8, X9, Joueur) ;    % 3ème ligne
    egalite(X1, X4, X7, Joueur) ;    % 1ère colone
    egalite(X2, X5, X8, Joueur) ;    % 2ème colone
    egalite(X3, X6, X9, Joueur) ;    % 3ème colone
    egalite(X1, X5, X9, Joueur) ;    % 1ère diagonale
    egalite(X3, X5, X7, Joueur).     % 2ème diagonale


% partieGagner(+A,+B,+C,+P)
% Vrai si il y a 3 plateau de gagner par le joueur Joueur
partieGagner(A,B,C,Joueur):-
        gagnerPetitPlateau(Joueur,A),
        gagnerPetitPlateau(Joueur,B),
        gagnerPetitPlateau(Joueur,C).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%ù
%                                       ECRITURE DES COUPS  
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


% dessinerGrandPlateau(+Plateau)
% Vrai si le le grand plateau est déssiné.
dessinerGrandPlateau([C1,C2,C3,C4,C5,C6,C7,C8,C9]) :-
    \+ gagnerGrandPlateau(o,[C1, C2, C3, C4, C5, C6, C7, C8, C9]),
    \+ gagnerGrandPlateau(x,[C1, C2, C3, C4, C5, C6, C7, C8, C9]),
    petitPlateauPlein(C1),
    petitPlateauPlein(C2),
    petitPlateauPlein(C3),
    petitPlateauPlein(C4),
    petitPlateauPlein(C5),
    petitPlateauPlein(C6),
    petitPlateauPlein(C7),
    petitPlateauPlein(C8),
    petitPlateauPlein(C9).


% petitPlateauPlein(+PetitPlateau)   
% Vrai si le petit Plateau est plein
petitPlateauPlein(PetitPlateau):-
        gagnerPetitPlateau(_,PetitPlateau),
        !.
petitPlateauPlein(PetitPlateau):-
        petitPlateauDessine(PetitPlateau),
        !.


% petitPlateauDessine(+Plateau)
% Vrai si le petit plateau est dessine
petitPlateauDessine(Plateau):-
        \+gagnerPetitPlateau(_,Plateau),
        \+member(0,Plateau).

% egalite(+W, +X, +Y, +Z)
% True if W = X = Y = Z
egalite(X,X,X,X):-
        dif(X,0).


% joueurSuivant(+X1, -X2)
% Vrai si est x est différent de o.
joueurSuivant(x,o).
joueurSuivant(o,x).






%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%ù
%                                       GESTION DES COUPS 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% deplacement(+Case,-CaseSuivante)
% Vrai si il y a un mouvement de Case vers CaseSuivante.
% Il exite un coup qui fait gagner
deplacement([X1,play,DernierCoup,Plateau],[X2,win,NewPlay,PlateauSuivant]):- 
        joueurSuivant(X1,X2),
        deplacement_suivant(X1,DernierCoup,Plateau,NewPlay,PlateauSuivant),
        gagnerPetitPlateau(X1,PlateauSuivant)
        %% ,!
        .
%Il existe un coup possible
deplacement([X1,play,DernierCoup,Plateau],[X2,nul,NewPlay,PlateauSuivant]):-  
        joueurSuivant(X1,X2),
        deplacement_suivant(X1,DernierCoup,Plateau,NewPlay,PlateauSuivant),
        dessinerGrandPlateau(PlateauSuivant)
        .
deplacement([X1,play,DernierCoup,Plateau],[X2,play,NewPlay,PlateauSuivant]):- 
        joueurSuivant(X1,X2),
        deplacement_suivant(X1,DernierCoup,Plateau,NewPlay,PlateauSuivant).


% Le dernier coup n'est pas n'est pas possible dans le petit plateau
% Pour cela, on verifie la presence de Plateau dans petitPlateau dans DernierCoup
deplacement_suivant(Joueur,DernierCoup,Plateau,CoupSuivant,PlateauSuivant):-  
        nth1(DernierCoup,Plateau,PetitPlateau),
        petitPlateauPlein(PetitPlateau),
        !,
        deplacement_tout_le_plateau(Joueur,Plateau,CoupSuivant,PlateauSuivant).

% Cas ou le coup suivant est le premier coup
deplacement_suivant(Joueur, 0, Plateau, CoupSuivant, PlateauSuivant):-      
        deplacement_tout_le_plateau(Joueur, Plateau, CoupSuivant, PlateauSuivant).

% Cas ou le dernier coup est possible
deplacement_suivant(Joueur,DernierCoup,Plateau,CoupSuivant,PlateauSuivant):-
        deplacementPlateau(Joueur,DernierCoup,Plateau,CoupSuivant,PlateauSuivant).
        
        
deplacement_tout_le_plateau(Joueur,Plateau,CoupSuivant,PlateauSuivant):-
        deplacementPlateau(Joueur,1,Plateau,CoupSuivant,PlateauSuivant);
        deplacementPlateau(Joueur,2,Plateau,CoupSuivant,PlateauSuivant);
        deplacementPlateau(Joueur,3,Plateau,CoupSuivant,PlateauSuivant);
        deplacementPlateau(Joueur,4,Plateau,CoupSuivant,PlateauSuivant);
        deplacementPlateau(Joueur,5,Plateau,CoupSuivant,PlateauSuivant);
        deplacementPlateau(Joueur,6,Plateau,CoupSuivant,PlateauSuivant);
        deplacementPlateau(Joueur,7,Plateau,CoupSuivant,PlateauSuivant);
        deplacementPlateau(Joueur,8,Plateau,CoupSuivant,PlateauSuivant);
        deplacementPlateau(Joueur,9,Plateau,CoupSuivant,PlateauSuivant).


deplacementPlateau(Joueur,DernierCoup,Plateau,CoupSuivant,PlateauSuivant):-      
        nth1(DernierCoup,Plateau,PetitPlateau),
        \+petitPlateauPlein(PetitPlateau),
        deplacementPlateau_aux(Joueur,PetitPlateau,CoupSuivant,PetitPlateauSuivant),
        verification(PetitPlateauSuivant,DernierCoup,Plateau,PlateauSuivant).


% deplacementPlateau_aux(+Joueur, +PetitPlateau, -CoupSuivant, -PetitPlateauSuivant)
deplacementPlateau_aux(Joueur, [0|PetitPlateau], CoupSuivant, [Joueur|PetitPlateau]):-
        length(PetitPlateau,L),
        CoupSuivant is 9 - L.

deplacementPlateau_aux(Joueur, [Color|PetitPlateau], CoupSuivant, [Color|PetitPlateau2]) :-
        deplacementPlateau_aux(Joueur, PetitPlateau, CoupSuivant, PetitPlateau2).



% verification(+NouveauElement, +Indice, +Liste, -NouvelleListe)        
% Vrai si le nouvelle liste est la même que la liste à l'element à l'indice donné (l'Indice commence à 1)
verification(NouveauElement, 1, [_|Liste], [NouveauElement|Liste]):-
        !.
verification(NouveauElement, Indice,[A|Liste],[A|NouvelleListe]):-
        Indice > 1,
        NouvelleIndice is Indice - 1,
        verification(NouveauElement, NouvelleIndice, Liste, NouvelleListe).
     




%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%ù
%                                               MIN MAX 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%



% meilleurCoup(+Case, -CaseSuivante)
% L'IA choisi la meilleure case en fonction de l'adversaire
% Pour cela on utilise min max avec une profondeur de 4 pour rester sous les 6s.
meilleurCoup([x, play, 0, [[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0]]], [o, play, 5, [[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, x, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0, 0]]]):-!.
meilleurCoup(Case, CaseSuivante) :-
    minimax(Case, 4, CaseSuivante, _). 


% deplacement_minimum(+Case)
% Vrai si le prochain joueur à jouer est celui qui vise le minimum
deplacement_minimum([x, _, _, _]).

% deplacement_maximum(+Case)
% Vrai si le prochain joueur à jouer est celui qui vise le maximum
deplacement_maximum([o, _, _, _]).

% Cas ou la profondeur est de 0
minimax(Case, 0, _, Val):-                      
        heuristique(Case,Val),
        !.
        
% Lorsque le sucesseur et la profondeur ne sont pas égale à 0
minimax(Case, Profondeur, MeilleureCaseSuivante, Val) :-       
        bagof(CaseSuivante, deplacement(Case, CaseSuivante), CaseSuivanteListe),
        NProfondeur is Profondeur - 1,
        meilleurChoix(CaseSuivanteListe, NProfondeur, MeilleureCaseSuivante, Val),!.

% Cas ou il n'y a pas de successeur dans l'arbre
minimax(Case, _, _, Val) :-              
        heuristique(Case, Val).


meilleurChoix([Case], Profondeur, Case, Val) :-
        minimax(Case, Profondeur, _, Val), !.

meilleurChoix([Case1 | CaseListe], Profondeur, MeilleureCase, MeilleureValeur) :-
        minimax(Case1, Profondeur, _, Val1),
        meilleurChoix(CaseListe, Profondeur, Case2, Val2),
        betterOf(Case1, Val1, Case2, Val2, MeilleureCase, MeilleureValeur).


% Lorsque le case0 est mieux que le case1
betterOf(Case0, Val0, _, Val1, Case0, Val0) :- 
    % deplacement minimum pour la case0
    deplacement_minimum(Case0),                         
    
    % Le max choisi la valeur la plus petite 
    Val0 > Val1, !                             
    ;
    
    % deplacement maximum pour la case0
    deplacement_maximum(Case0),     
    
    % Le min choisi la valeur la plus petite           
    Val0 < Val1, !.                            

betterOf(_, _, Case1, Val1, Case1, Val1).    




%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                                       HEURISTIQUE 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% egale_a_zero(+P, +B1, +B2, +B3)
% Vrai si c'est égale à 0 
egale_a_zero(P, P, P, 0):-!.
egale_a_zero(P, P, 0, P):-!.
egale_a_zero(P, 0, P, P).


% gagner_dun_coup(+Joueur, +PetitPlateau)
% Vrai si le joueur peut gagner le petit en un seul coup
gagner_dun_coup(Joueur, [X1,X2,X3,X4,X5,X6,X7,X8,X9]):-
        egale_a_zero(Joueur,X1,X2,X3) ;    % 1ère ligne
        egale_a_zero(Joueur,X4,X5,X6) ;    % 2ème ligne
        egale_a_zero(Joueur,X7,X8,X9) ;    % 3ème ligne
        egale_a_zero(Joueur,X1,X4,X7) ;    % 1ère colone
        egale_a_zero(Joueur,X2,X5,X8) ;    % 2ème colone
        egale_a_zero(Joueur,X3,X6,X9) ;    % 3ème colone
        egale_a_zero(Joueur,X1,X5,X9) ;    % 1ème diagonale
        egale_a_zero(Joueur,X3,X5,X7).     % 2ème diagonale


% cpt_plateau_gagne(+Joueur, +Plateau, -Val, -Val2)
% Le résultat est vrai si la valeur estégale au numero du sous petit sous palteau gagné
% Pour la 2ème valeur, elle est égale au numéro du petit plateau qui gagne un coup
cpt_plateau_gagne(Joueur,[PetitPlateau|Plateau],Val,Val2):-
        gagner_dun_coup(Joueur,PetitPlateau),
        !,
        cpt_plateau_gagne(Joueur,Plateau,Val,NVal2),
        Val2 is NVal2 + 1.

cpt_plateau_gagne(Joueur,[PetitPlateau|Plateau],Val,Val2):-
        gagnerGrandPlateau(Joueur,PetitPlateau),
        !,
        cpt_plateau_gagne(Joueur,Plateau,NVal,Val2),
        Val is NVal + 1.

cpt_plateau_gagne(P,[_|Plateau],Val,Val2):-
        cpt_plateau_gagne(P,Plateau,Val,Val2).

cpt_plateau_gagne(_,[],0,0).  


% cpt_Plateau_gagne(+Joueur, +Plateau, -Val)
% Cpt Vrai si la valeur est égale au nombre de petit plateau gagné par un joueur
cpt_Plateau_gagne(Joueur,[PetitPlateau|Plateau],Val):-
        gagnerGrandPlateau(Joueur,PetitPlateau),
        !,
        cpt_Plateau_gagne(Joueur,Plateau,NVal),
        Val is NVal + 1.
cpt_Plateau_gagne(Joueur,[_|Plateau],Val):-
        cpt_Plateau_gagne(Joueur,Plateau,Val).
cpt_Plateau_gagne(_,[],0).  

                                  

% heuristique(+Case, -Val)
% On obtient la valeur du resutlat en évaluant la fonction de la case dans val.
heuristique([o, win, _, _], -100).  % x win
heuristique([x, win, _, _], 100).   % o win
heuristique([_, nul, _, _], 0).    % 
heuristique([Joueur, play, _, Case],Val):-
        heuristique_aux(Joueur,Case,Val).

heuristique_aux(Joueur,Plateau,Val):-
        cpt_plateau_gagne(Joueur,Plateau,NbPlateauGagne,NbPlateauAGagner),
        joueurSuivant(Joueur,JSuivant),
        cpt_plateau_gagne(JSuivant,Plateau,NbPlateauPerdu,NbPlateauAPerdre),
        TmpVal is NbPlateauGagne*10 + NbPlateauAGagner*4 - NbPlateauPerdu*10 - NbPlateauAPerdre*4,
        (
           Joueur = x,
           Val is -TmpVal
        ;
           Joueur = o,
           Val is TmpVal
        ).








%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%ù
%                                       ALPHA BETA  
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Alpha-Beta
/*
alphabeta(_, Position, _, _, 0, -1000):-
  partie_perdu(Position), !.
alphabeta(Profondeur, Position, Alpha, Beta, meilleurCoup, Valeur):-
  Profondeur > 0,
  meilleur_coup(Position, Deplacement),
  Deplacement = [_|_], !,
  ProfondeurSuivante is Profondeur - 1,
  Alpha2 is -Beta,
  Beta2 is -Alpha,
  meilleurCoup(Deplacement, Position, ProfondeurSuivante, Alpha1, Beta1, 0, meilleurCoup, Valeur).


alphabeta(_, Position, _, _, 0, Valeur):-
  Valeur(Position, Valeur). % Profondeur de base est de 0
*/

%