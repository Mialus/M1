   public class Remplace {
	   /*@ requires true; 
	   @ ensures true;
	   @ assignable b[*]; @*/

  public void remplace(int[]b,  int x, int y){
	  /*@
	    @ loop_invariant i>=1 && i<= b.length;
	    @ loop_invariant (\forall int j; 1<=j && j < b.length;
	    @ assignable b[*], i;
	    @ decreases b.length - i;
	    @*/
    for(int i = 1; i<b.length; i++){
      if(b[i] == X) b[i] = y;
    }
  }


}