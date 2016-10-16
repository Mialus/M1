public class InsertionSort {
 /*@ requires 0 < tab.length;
   @ ensures (\forall int k; 0 <= k && k < tab.length; tab[k] <= tab[k+1]);
   @ assignable tab[*]; */
 public void insertionSort(int[] tab) {
  /*@ loop_invariant 1 <= i && i <= tab.length;
    @ loop_invariant (\forall int k,j; k>=0 && k< i && j>=1 && j<=i && k<j ==> tab[k]<=tab[j]);
    @ assignable i,tab[*];
    @ decreases (tab.length-i); */
  for (int i = 1; i < tab.length; i++) {
   decalage(tab,i);
  }
 }
 
 /** This function inserts tab[i] in tab[0..i-1]. */
 /*@ requires (i>0 && i< tab.length);
   @ requires (\forall int k,j; k>=0 && k< i-1 && j>=1 && j<i && k<j ==> tab[k]<=tab[j]); // tableau trié jusqu'à i 
   @ ensures (\forall int k; 0 <= k && k < i; tab[k] <= tab[k+1]);
   @ assignable tab[*]; */
 void decalage(int[] tab, int i) {
  int t = tab[i];
  int j;
  /*@ loop_invariant tab[j+1] >= t;
    @ loop_invariant -1 <= j && j <= tab.length-2;
    @ loop_invariant (j < i - 1 ==> (\forall int k; 0 <= k && k < i; tab[k] <= tab[k+1]));
    @ loop_invariant (\forall int k; 0 <= k && k < j; tab[k] <= tab[k+1]);
    @ assignable tab[*],j; 
    @ decreases (j+1); */
  for (j = i - 1; j >= 0; j--) {
   if (tab[j] <= t) break;
   tab[j+1] = tab[j];
  }
  tab[j+1] = t;
 }
}
