public class Maximum{
        int[] t1;
        int n1;

        /*@ 
                requires t1.length >= 2;
                requires n1 >= 1 && n1 < t1.length;
                ensures (\forall int i; i >= 1 && i <= n1; t1[\result] >= t1[i]);
        @*/
        public int max(){
                int imax = 1;
                int k1 = 1;

                /*@ 
                        loop_invariant k1 >= 1 && k1 <= n1;
                        loop_invariant imax >= 1 && imax <= k1+1;
                        loop_invariant (\forall int j; j >= 1 && j <= k1; t1[imax] >= t1[j]);
                        assignable k1, imax;
                        decreases n1 - k1;
                @*/
                while (k1 < n1){
                        if(t1[imax] < t1[k1+1]){
                                imax = k1 + 1;
                        }
                        k1 = k1 + 1;
                }
                return imax;
        }
}

/*Nb rules: 982
Nb branches: 11
Time: 600ms 
*/