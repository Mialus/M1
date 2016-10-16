public class BinarySearch {

    /*@ requires length>0;
        requires (\forall int j; 0 <= j && j < length ==> arr[j] <= arr[j+1]);
        assignable arr[*];
        ensures (-1 <= \result && \result < length &&
          (\result == -1 ==> (\forall int i; 0 <= i && i < length ==> arr[i] != query)) &&
          (\result >= 0 ==>  (\exists int j; 0 <= j && j < length && arr[j]==query && \result == j )));
    */
    int binary_search(int arr[], int length, int query) {
      int low = 0;
      int high = length - 1;
      /*@
        loop_invariant 0 <= low;
        loop_invariant low <= high+1;
        loop_invariant high < length;
        loop_invariant (\forall int k; 0 <= k && k < low ==> arr[k] != query);
        loop_invariant (\forall int k; high < k && k < length ==> arr[k]>query);
        assignable low,high;
        decreases high-low;
      */
      while (low <= high) {
        int mean = low + (high -low) / 2;
        if (arr[mean] == query) return mean;
        if (arr[mean] < query) low = mean + 1;
        else high = mean - 1;
      }
      return -1;
    }
}