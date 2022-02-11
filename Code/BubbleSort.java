import java.util.Arrays;
public class BubbleSort{

    /*
        -> Time Complexity : O(n^2)
        -> Auxiliary Space Complexity : O(1)
        -> Inplace ? Yes
        -> Stable ? Yes
    */

    public static int[] bubblesort(int[] arr){
        if(arr==null || arr.length<=1) return arr;
        int n = arr.length;
        // total swaps in worst case (sorted in descending order): n(n-1)/2
        int total_swaps = 0;
        // n-1 passes
        // ith pass will place ith largest element at its correct position in our case
        for(int i=0; i<n-1; i++){
            int swaps = 0;
            // Swapping elements on indices that are not yet sorted
            for(int j=0; j<(n-1)-i; j++){
                if(arr[j]>arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            // Optimization:
            // if no swaps took place, array is already sorted
            // if(swaps==0) break;
            total_swaps += swaps;
        }
        System.out.println("Total Swaps = " + total_swaps);
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {6,5,4,3,2,1};
        arr = bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

}