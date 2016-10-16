public class PlusGrandPrefixeCommun{

	/*@ requires a!= b && a != c && b != c && c.length >= a.length && c.length >= b.length;
	  @ ensures \result >= 0 && \result <= a.length && \result <= b.length;
	  @ ensures (\forall int j; j>=0 && j<\result; a[j] == c[j] && b[j] == c[j]);
	  @ assignable c[*];
	*/
	public int commonPrefix(int[] a, int[] b, int[] c){
		int i;
		/*@ loop_invariant i >= 0 && i <= a.length && i <= b.length;
		  @ loop_invariant (\forall int j; j>=0 && j<i; a[j] == b[j] && a[j] == c[j]);
		  @ assignable c[*], i;
		  @ decreases c.length - i;
		*/
		for(i=0; i<a.length && i<b.length; i++){
			if(a[i]==b[i]){
				c[i] = a[i];			
			} else {
				return i;
			}
		}
		return i;
	}


}

/* Nb rules: 1406
   Nb branches: 29
   Time: 2.8s */
