public class InsertionSort {
 /*@ requires tab.length >=1;
   @ assignable tab[*];
   @ ensures (\forall int k ; k >= 0 && k <tab.length-1 ; tab[k] <= tab[k+1]);
 */
 public void insertionSort(int[] tab) {
  int i;

  /*@ loop_invariant ( i>=1 && i<=tab.length);
    @ loop_invariant (\forall int k ; k >= 0 && k <i-1 ; tab[k] <= tab[k+1]);
    @ assignable i,tab[*];
    @ decreases tab.length-i;  */
  for (i = 1; i < tab.length; i++) {
   decalage(tab,i);
  }
 }
 
 /** This function inserts tab[i] in tab[0..i-1]. */
 /*@ requires (\forall int k ; k >= 0 && k <i-1 ; tab[k] <= tab[k+1]); // tableau trié jusqu'à i-1
   @ requires( i>=1 && i<tab.length);
   @ ensures  (\forall int k ; k >= 0 && k <i ; tab[k] <= tab[k+1]);
   @ assignable tab[*]; 
   @*/
 void decalage(int[] tab, int i) {
  int t = tab[i];
  int j;

  /*@ loop_invariant j>=-1 && j<=i-1 && j+1 <= tab.length-1;
    @ loop_invariant tab[j+1] >=t;
    @ loop_invariant (\forall int k ; k >= 0 && k <j ; tab[k] <= tab[k+1]);
    @ loop_invariant (j < i - 1 ==> (\forall int k; 0 <= k && k < i; tab[k] <= tab[k+1]));
    @ assignable tab[0..i], j; 
    @ decreases j+1; */
  for (j = i - 1; j >= 0; j--) {
   if (tab[j] <= t) break;
   tab[j+1] = tab[j];
  }
  tab[j+1] = t;
 }
}

/*Nb rules: 4546
Nb branches: 57
Time: 4s 
*/