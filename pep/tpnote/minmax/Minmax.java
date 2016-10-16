/* WARGNIER Pierre                            */

public class Minmax {
 int min, max;

 /*@ requires a.length > 0;
   @ ensures ((\exists int k; k >= 0 && k < a.length; a[k] == min) &&  (\exists int l; l >= 0 && l < a.length; a[l] == max));
   @ ensures (\forall int j; j >= 0 && j < a.length; (a[j] >= min && a[j]<= max)); 
   @ assignable min,max; */
 public void extremes(int[] a) {
  min = a[0];
  max = a[0];
  /*@ loop_invariant (i>=0 && i <= a.length);
    @ loop_invariant (max>=min);
    @ loop_invariant ((\exists int k; k >= 0 && k < i; a[k] == min) &&  (\exists int l; l >= 0 && l < i; a[l] == max));
    @ loop_invariant (\forall int j; j >= 0 && j < i; (a[j] >= min && a[j]<= max));
    @ assignable min,max,i; 
    decreases a.length-i;*/
  for (int i = 1; i < a.length; i++) {
   if (a[i] < min) min = a[i];
   if (a[i] > max) max = a[i];
  }
 } 

/*Nb rules: 936
Nb branches: 32
Time: 600ms 
*/

/*Nb rules: 2104
Nb branches: 42
Time: 1500ms 
*/

/*Nb rules: 3204
Nb branches: 54
Time: 2400ms 
*/

/*Nb rules: 3464
Nb branches: 55
Time: 3528ms 
*/

 
 /*@ requires a.length > 0;
 @ ensures (\exists int j; j >= 0 && j < a.length; a[j] == max);
 @ ensures (\forall int j; j >= 0 && j < a.length; a[j]<= max);
 @ assignable max;
 @*/
  public int /*@ pure */ max(int[] a){
      max = a[0];
/*@ loop_invariant i>=1 && i<= a.length;
  @ loop_invariant (\forall int j; j >= 0 && j < i;  a[j]<= max);
  @ loop_invariant  (\exists int l; l >= 0 && l < i; a[l] == max);
  @ assignable max, i;
  @ decreases a.length - i;
  @*/
      for(int i = 1; i<a.length; i++){
      if (a[i]>max){ max = a[i];}
      }
      return max;
  }
}

/*Nb rules: 1286
Nb branches: 25
Time: 2000ms 
*/