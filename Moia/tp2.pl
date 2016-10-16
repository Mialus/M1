/* -*- Mode:Prolog; coding:iso-8859-1; -*- */

premier(X,[A|_]):-
        X=A.

dernier(X,[X]).
dernier(X,[_|A]):-
             dernier(X,A).

ajout_debut(X,L,L1):-
        L1=[X|L].

ajout_fin(X,[],[X]).
ajout_fin(X,[A|L],[A,L1]):-
        ajout_fin(X,L,L1).


appartient(X,[X|_]).
appartient(X, [_|Y]):-
        appartient(X,Y).

inclus([],_).
inclus([X|L],Y):-
        appartient(X,Y),
        inclus(L,Y).

renverse_liste([],L2,L2).
renverse_liste([A|L],L1,R):-
        ajout_debut(A,L1,L2),
        renverse_liste(L,L2,R).
      
%sous_liste_gauche([],L1).
%sous_liste_gauche([X|L],L1):-
              % sous_liste_gauche([]).

%longueur([],A):- A is 0.
%longueur([_|L],A):-
 %       A1 is A + 1,
  %      longueur(L,A1).

longueur([],0).
longueur([_|R],N) :-
        longueur(R,N1),
        N is N1+1,
        N>0.

somme([],0).
somme([X|R],N) :-
        somme(R,N1),
        N is N1+X.
         