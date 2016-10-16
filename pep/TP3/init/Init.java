public class Init{
        /*@
                requires tab != null && tab.length > 0;
                ensures (\forall int i; i >= 0 && i < tab.length; tab[i] == val);
        @*/
        public void constant(int[] tab, int val){
                int k;
                k = 0;
                /*@ 
                        loop_invariant k >= 0 && k <= tab.length;
                        loop_invariant (\forall int j; j >= 0 && j < k; tab[j] == val);
                        assignable k, tab[*];
                        decreases tab.length - k;
                @*/
                while(k < tab.length) tab[k++] = val; 
        }
}

/*Nb rules: 487
   Nb branches: 11
   Time: 300ms 
*/