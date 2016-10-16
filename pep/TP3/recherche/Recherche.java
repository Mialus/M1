public class Recherche{
        /*@
                requires t.length >= 1;
                ensures \result >= 0 && \result < t.length ==> t[\result] == x;
                ensures (\forall int i; i >= 0 && i < t.length; t[i] != x) <==> \result == -1;
        @*/
    public static int recherche(int[] t, int x){
                int i;
                /*@
                        loop_invariant i >= 0 && i <= t.length;
                        loop_invariant (\forall int j; j >= 0 && j < i; t[j] != x);
                        assignable i;
                        decreases t.length - i;
                @*/
        for(i = 0 ; i < t.length; i++){
            if(t[i] == x){
                return i;
            }
        }
        return -1;
    }
}

/*Nb rules: 582
Nb branches: 11
Time: 300ms 
*/