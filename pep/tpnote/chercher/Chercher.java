/* WARGNIER Pierre                          */

public class Chercher {
	
	 /*@ requires t.length>0;
	   @ ensures -1 <= \result && \result < t.length; 
	   @ ensures \result == -1 <==> (\forall int k; 0 <= k && k < t.length; t[k] != a);
	   @ ensures (\forall int j; j >= 0 && j < \result; (t[j] != a)); 
	   @ ensures 0 <= \result && \result < t.length ==> t[\result] == a;
	   @ assignable \nothing; @*/
	 public static int recherche(int[] t, int a) {
	  /*@ loop_invariant 0 <= i && i <= t.length;
	    @ loop_invariant (\forall int j; 0 <= j && j < i; t[j] != a);
	    @ assignable i;
	    @ decreases t.length-i; */
	  for (int i = 0; i < t.length; i++) if (t[i] == a) return(i);
	  return(-1);
	 }
	 /*Nb rules: 577
	 Nb branches: 11
	 Time: 300ms 
	 */

	 /*Nb rules: 616
	 Nb branches: 12
	 Time: 375ms 
	 */
 
 /* Proved: 237 rules, 4 goals, 0.1 seconds. */
 /*@ public normal_behavior
   @ ensures \result == (a < b ? b - a : a - b); */
 public static int /*@ pure */ distance(int a, int b) {
  if (a < b) return(b-a); else return(a-b);
 }
 
 /** Recherche approchée dans un tableau d'entiers non vide.
  *  La méthode retourne un indice i tel que t[i] est la valeur du tableau t
  *  la plus proche de a. 
  *  La distance entre t[i] et a est mesurée avec la fonction pure 
  *  distance(int,int) fournie. */
 /*@ requires t.length > 0;
   @ ensures 0 <= \result && \result <= t.length-1;
   @ ensures (\forall int j; 0 <= j && j < t.length; distance(t[j],a) >= t[\result]);
   @ assignable \nothing; */
 public static int closest(int[] t, int a) {
  int indice = 0;            // returned index
  int d = distance(t[0],a);
  
  /*@ loop_invariant 1 <= i && i <= t.length;
    @ loop_invariant indice <= 1 && indice <= t.length;
    @ loop_invariant (\forall int j; 0 <= j && j < i; distance(t[j],a) >= d);
    @ assignable d,indice;
    @ decreases t.length-i	; */
  for (int i = 1; i < t.length; i++) {
   d = distance(t[i],a);
   if (d < distance(t[indice],a)) indice = i;
  }
  return(indice);
 }
}