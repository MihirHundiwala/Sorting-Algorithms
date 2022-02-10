package Code;
import java.util.Arrays;
public class SelectionSort{

    /*
        -> Time Complexity : O(n^2)
        -> Auxiliary Space Complexity : O(1)
        -> Inplace ? Yes
        -> Stable ? No
    */

    public static int[] selectionsort(int[] arr){
        if(arr==null || arr.length<=1) return arr;
        int n = arr.length;
        int total_swaps = 0;
        // n-1 passes
        // ith pass will place the ith smallest element at its correct place in our case
        for(int i=0; i<n-1; i++){
            // get index of minimum element from i to n-1 and place it on i
            int min_index=i, min_elem=arr[i];
            for(int j=i; j<n; j++){
                if(arr[j]<min_elem){
                    min_elem = arr[j];
                    min_index = j;
                }
            }
            // swap
            if(min_index != i){
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
                total_swaps++;
            }
        }
        System.out.println("Total Swaps = " + total_swaps);
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {3,1,5,4,6,2};
        arr = selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }

}