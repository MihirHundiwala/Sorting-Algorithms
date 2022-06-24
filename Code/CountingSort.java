import java.util.Arrays;
public class CountingSort {
    
    /*  
        -> We count the occurences of each element and store it in an array
        -> Find cumulative sum of the array in order,
           to get the indices of elements in output array (this is 1-based indexing).
        -> Use cumulative sum to place elements in output array
           Note that here we subtract 1 to convert the above to 0-based indexing.


        -> Time Complexity : O(n)
        -> Auxiliary Space Complexity : O(n)
        -> Inplace? Indirectly Yes
        -> Stable? Yes in this version
    */

    public static int[] countingsort(int[] arr){
        if(arr==null || arr.length<=1) return arr;
        int n = arr.length;

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // Number of elements between min and max including both
        int range = max - min + 1;

        int count[] = new int[range];
        int output[] = new int[n];

        // min is used as an offset

        // Increase count
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }
  
        // Cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Starting from i=0 to end is an unstable version
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
  
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
        return arr;
    }

    public static void main(String[] args){
        // SUppose our range is [1,n]
        int[] arr = {5,4,3,4,5,5,2,3,1,1,2,4,1};
        arr = countingsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}