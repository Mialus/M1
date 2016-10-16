/* -*- Mode:Prolog; coding:iso-8859-1; -*- */

passagers_bateau(M,C):-
        M=1,
        C=1;
        M=2,
        C=0;
        M=0,
        C=2;
        M=1,
        C=0;
        M=0,
        C=1.

deplacement_par_bateau([M,C,0],M1,C1):-
        passagers_bateau(X,Y),
        M1 is M - X,
        C1 is C - Y.

deplacement_par_bateau([M,C,1],M1,C1):-
        passagers_bateau(X,Y),
        M1 is M + X,
        C1 is C + Y.

deplacement_legal(M,C):-
        M>0,
        C>0,
        M<4,
        C<4.

missionnaires_sauf(M,C):-
        M>=C,
        M1 is 3-M,
        C1 is 3-C,
        M1>=C1.
        
traversee([M,C,1],[M1,C1,B1]):-
        deplacement_par_bateau([M,C,1],M1,C1),
        deplacement_legal(M1,C1),
        missionnaires_sauf(M1,C1),
        B1=0.

traversee([M,C,0],[M1,C1,B1]):-
        deplacement_par_bateau([M,C,0],M1,C1),
        deplacement_legal(M1,C1),
        missionnaires_sauf(M1,C1),
        B1=1.

profondeur([[0,0,1]|L1],[[0,0,1]|L1]).
profondeur([X|L1],Sol):-
        traversee(X,X1),
        profondeur([X1,X|L1],Sol).

cm(L):-
       profondeur([[3,3,0]],L1),
       inverse(L1,L).

