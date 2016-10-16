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
}

/*Nb rules: 577
Nb branches: 11
Time: 300ms 
*/

/*Nb rules: 616
Nb branches: 12
Time: 375ms 
*/