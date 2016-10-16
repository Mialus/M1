:- use_module(library(lists)).
:- set_prolog_flag(toplevel_print_options,[max_depth(0)]).

%////// Fonction de BASE

depart([b,b,b,e,n,n,n]).
arrivee([n,n,n,e,b,b,b]).


deplace(L,N):-
        glissementDroit(L,N).
deplace(L,N):-
        glissementGauche(L,N).
deplace(L,N):-
        sautDroit(L,N).
deplace(L,N):-
        sautGauche(L,N).


%/////// PROFONDEUR //////////////////////////////////

glissementDroit([A],[A]):- fail.
glissementDroit([b,e|C],[e,b|C]).
glissementDroit([Y|C],[Y|R]):-
        glissementDroit(C,R).

glissementGauche([A],[A]):- fail.
glissementGauche([e,n|C],[n,e|C]).
glissementGauche([Y|C],[Y|R]):-
        glissementGauche(C,R).

sautDroit([A],[A]):- fail.
sautDroit([b,n,e|C],[e,n,b|C]).
sautDroit([Y|C],[Y|R]):-
       sautDroit(C,R).

sautGauche([A],[A]):- fail.
sautGauche([e,b,n|C],[n,b,e|C]).
sautGauche([Y|C],[Y|R]):-
        sautGauche(C,R).

profondeur([[n,n,n,e,b,b,b]|L1],[[n,n,n,e,b,b,b]|L1]).
profondeur([X|L1],Sol):-
        deplace(X,X1),
        nonmember(X1,L1),
        profondeur([X1,X|L1],Sol).

cmP(L):-
        depart(D),
        profondeur([D],L1),
        reverse(L1,L).

%/////// LARGEUR //////////////////////////////////

etageSuivant([],Acc,Acc).
etageSuivant([Ch|Lch],Acc,LLR):-
        parcoursSuivant(Ch,[],NLch),
        append(NLch,Acc,NAcc),
        etageSuivant(Lch,NAcc,LLR).

deplace2([X|CH],[E,X|CH]):-
        deplace(X,E).
        
parcoursSuivant(Ch,_,NL):-
        findall(Noch,deplace2(Ch,Noch),NL).

etatFinal([X|_],X):-
        X=[A|_],
        arrivee(A).                
etatFinal([_|LL],R):-
        etatFinal(LL,R).
        
                 
largeur([],_):-!,fail.
largeur(LL,LR):-
        etatFinal(LL,LR).
largeur(LL,LR):-
        etageSuivant(LL,[],LL2),
        largeur(LL2,LR).

cmL(L):-
        depart(D),
        largeur([[D]],L1),
        reverse(L1,L).



%/////// HEURISTIQUE NON FONCTIONNEL//////////////////////////////////
deplaceH(Ch, [A|Ch], Cout):-
        deplace2(Ch, [A|Ch]),
        heuristique(A, Cout1),
        size([A|Ch], Cout2),
        Cout is Cout1 + Cout2.

parcoursSuivantH(_,Acc,Acc).
parcoursSuivantH(X,Acc,R):-
        deplaceH(X,Nvch,Cout),
        nonmember([Cout,Nvch],Acc),
        parcoursSuivantH(X,[[Cout,Nvch]|Acc],R).

size([],0).
size([_|L],A):-
        size(L,A2),
        A is A2+1.
size(Ch,G):-
        length(Ch,G).

insere(L,[],L).
insere(L,[Ch|Q],S):-
        insereC(Ch,L,R),
        insere(R,Q,S).

insereC([Cout,Ch],[[Q,Ch2]|Q],[[Cout,Ch],[Co2,Ch2]|Q]):-
        cout = Co2.
/*insereC([Cout,Ch],[[Q,Ch2]|Q],[[Cout,Ch],[Co2,Ch2]|Q]):-
        size(Ch,Sir),
        size(Ch1,Sir2),
        Sir>= Sch2.*/

heuristique([], _):-fail,!.
heuristique([C,Ch|_], [C,Ch]):-
        etatFinal(C,Ch).
heuristique([A|L],Ch):-
        parcoursSuivantH(A,[],LCh2),
        insere(LCh2,L,Nl),
        heuristiqueh(Nl,Ch).

heuristiqueh(C, Cout):-
        cmL(X),
        nth0(I, X, C),
        Cout is I+1.

cmH(Sol):-
        depart(D),
        heuristique(D,C),
        heuristique([C, [D]],[_, _]),
        reverse([_, [D]],Sol).

%////// TEST /////

/*parcoursSuivant(X,Acc,Lparcours):-
        deplace(X,Parcours),
        nonmember(Parcours,Acc),!,
        parcoursSuivant(X,[Parcours|Acc],Lparcours).
parcoursSuivant(_,Acc,Acc).
*/
/*parcoursFinal([_,Parcours]):-
      arrivee(A),
      Parcours=[A|_].

etatFinal([Parcours|_],Parcours):-
     parcoursFinal(Parcours).
etatFinal([_|LParcours],R):-
        etatFinal(LParcours,R).

ajouter([],_,_,Acc,Acc).
ajouter([[I|P]|LP],I,Parcours,Acc,R):- !,
        ajouter(LP,I,Parcours,[[I|P]|Acc],R).
ajouter([[T|_]|LP],I,Parcours,Acc,R):-
        T>I,
        nonmember(Parcours,Acc),!,
        ajouter(LP,I,Parcours,[Parcours|Acc],R).
ajouter([_|LP],I,Parcours,Acc,R):-
        ajouter(LP,I,Parcours,Acc,R).
*/        
/*etageSuivant([],_,Acc,Acc):-!.
etageSuivant([Parcours|LP],I,Acc,LParcours):-
        parcoursFinal(Parcours),!,
        etageSuivant(LP,I,Acc,LParcours).
etageSuivant([Parcours|LP],I,Acc,LParcours):-
        parcoursSuivant(Parcours,[],LP1),
        ajouter(LP1,I,Parcours,Acc,Acc1),
        etageSuivant(LP,I,Acc1,LParcours).
*/

/*largeur([],_,_):- !, fail.
largeur(L,_,R):-
      etatFinal(L,R).
largeur(L,I,R):-
        I1 is I+1,
        etageSuivant(L,I1,[],NL),
        largeur(NL,I1,R).
        
        /*parcoursSuivant(_,Acc,Acc).
parcoursSuivant(Ch,Acc,Lch):-
        deplace(ch,Noch),
        nonmember(Noch,Acc),
        parcoursSuivant(Ch,[Noch|Acc],Lch),!.
*/