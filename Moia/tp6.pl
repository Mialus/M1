:- use_module(library(clpfd)).
:- use_module(library(lists)).
:- use_module(library(system)).
%GENERER

gt(L):-
        L=[S,E,N,D,M,O,R,Y],
        VT=[0,1,2,3,4,5,6,7,8,9],
        select(S,VT,VS),
        select(E,VS,VE),
        select(N,VE,VN),
        select(D,VN,VD),
        select(M,VD,VM),
        select(O,VM,VO),
        select(R,VO,VR),
        select(Y,VR,_),
        M\=0,
        T is 1000*S+100*E+10*N+D+1000*M+100*O+10*R+E,
        T is 10000*M+1000*O+100*N+10*E+Y.

%BACKTRACKING

bt(L):-
        L=[S,E,N,D,M,O,R,Y],
        VT=[0,1,2,3,4,5,6,7,8,9],
        
        select(D,VT,VS),
        select(E,VS,VE),
        addition(D,E,0,Y,R1),
        select(Y,VE,VN),
        
        select(N,VN,VD),
        select(R,VD,VM),
        addition(N,R,R1,E,R2),
        
        select(O,VM,VP),
        addition(E,O,R2,N,R3),
        
        select(S,VP,VL),
        select(M,VL,_),
        addition(S,M,R3,O,M),

        M \=0.

addition(OPD,OPG,RIN,Result,Rout):-
        Somme is OPD+OPG+RIN,
        Result is mod(Somme,10),
        Rout is Somme//10.

%CONTRAINTE

plc(L):-
        L=[S,E,N,D,M,O,R,Y],
        
        domain(L,0,9),
        all_different(L),
        10000*M+1000*O+100*N+10*E+Y#=1000*(S+M)+100*(E+O)+10*(N+R)+D+E,
        labeling([],L),
        M \=0.

%EXO2
%GENERER

gtReine(N,D):-
    listeN(N,L),
    generer(N,L,D),
    tester(D).
 
listeN(0, []) :- !.
listeN(N, [N|L]) :-
    N1 is N-1,

    listeN(N1,L).
 
generer(0,[],[]).
generer(N,L,[[N,Lig] | D]):-
    N1 is N-1,
    select(Lig, L, NL),
    generer(N1,NL,D).
 
tester([]).
tester([C|D]) :-
    testPrise1(D,C),
    tester(D).

testPrise1([],_).
testPrise1([[X1,Y1] | D], [X,Y]) :-
    % X1 \= X, ligne
    % Y1 \= Y, colone
    abs(X1-X) =\= abs(Y1-Y),
    testPrise1(D, [X,Y]).
 


%2. Bactracking

btReine(N,D) :-
    listeN(N,L),
    placer(N,L,[],D).

placer(0,[], D, D).
placer(N,L,Acc,D) :-
    N1 is N-1,
    select(Lig, L, NL),
    testPrise1(Acc, [N, Lig]),
    placer(N1,NL,[ [N,Lig] | Acc], D).

%3. PLC

plcReine(N,D) :-
    length(LV,N),
    domain(LV, 1, N),
    all_different(LV),
    contraintes(N,LV,D),
    labeling([], LV).

contraintes(0,[],[]).
contraintes(N,[Y|LV], [ [N,Y] | D]) :-
    N1 is N-1,
    contraintes(N1, LV, D),
    poseContrainte(D, [N,Y]).

poseContrainte([], _).
poseContrainte([ [X1,Y1] | D ], [X,Y]) :-
    abs(X1-X) #\= abs(Y1-Y),
    poseContrainte(D, [X,Y]).
    % X1 #\= X, inutile par construction des contraintes
    % Y1 #\= Y, inutiles car généré par all_diferent

%Gestion du temps

current_seconde(S) :-
    datime(datime(_Year,_Month,_Day,_H,_M,S)).

runAll(_):-
     current_seconde(S),
     gtReine(4,D),
     display(S,D).

runAll2(_):-
     current_seconde(S),
     btReine(4,D),
     display(S,D).

runAll3(_):-
     current_seconde(S),
     plcReine(4,D),
     display(S,D).

seconde(S,Depart,Seconde):- S >= Depart, !,Seconde is S-Depart.
seconde(S,Depart,Seconde):- Seconde is (Depart-(S-Depart)).

display(Depart,R):-
        current_seconde(S),
        seconde(S,Depart,Seconde),
        nl,
        write('R = '),
        write(R),
        nl,
        write('Execution Time: '),
        write(Seconde),
        write(' s '),
        nl,nl.


%EXO3
%Bactracking

amazones(N,D) :-
    listeN(N,L),
    placerC(N,L,[],D).

testPrise2([],_).
testPrise2([[X1,Y1] | D], [X,Y]) :-
    % X1 \= X, ligne
    % Y1 \= Y, colone
    abs(X1-X)+ abs(Y1-Y) =\= 3,
    abs(X1-X) =\= abs(Y1-Y),
    testPrise2(D, [X,Y]).

placerC(0,[], D, D).
placerC(N,L,Acc,D) :-
    N1 is N-1,
    select(Lig, L, NL),
    testPrise2(Acc, [N, Lig]),
    placerC(N1,NL,[ [N,Lig] | Acc], D).

%3. PLC

amazonesplc(N,D) :-
    length(LV,N),
    domain(LV, 1, N),
    all_different(LV),
    contraintesA(N,LV,D),
    labeling([], LV).

contraintesA(0,[],[]).
contraintesA(N,[Y|LV], [ [N,Y] | D]) :-
    N1 is N-1,
    contraintesA(N1, LV, D),
    poseContrainteA(D, [N,Y]).

poseContrainteA([], _).
poseContrainteA([ [X1,Y1] | D ], [X,Y]) :-
    abs(X1-X)+abs(Y1-Y) #\= 3,
    abs(X1-X) #\= abs(Y1-Y),
    poseContrainteA(D, [X,Y]).