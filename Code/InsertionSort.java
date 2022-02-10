package Code;
import java.util.Arrays;
public class InsertionSort{

    /*
        -> Time Complexity : O(n^2)
        -> Auxiliary Space Complexity : O(1)
        -> Inplace ? Yes
        -> Stable ? Yes
    */

    public static int[] insertionsort(int[] arr){
        if(arr==null || arr.length<=1) return arr;
        int n = arr.length;
        int total_swaps = 0;
        // n-1 passes
        // ith pass will place the ith smallest element at correct place in our case
        for(int i=0; i<n-1; i++){
            // keep swapping until the element reaches its correct position
            for(int j=i+1; j>0; j--){
                if(arr[j]<arr[j-1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    total_swaps++;
                }
                else{
                    // Optimization:
                    // Since current element is not smaller than previous, 
                    // we dont need to compare further, so break the loop
                    break;
                }
            }
        }
        System.out.println("Total Swaps = " + total_swaps);
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {6,5,4,3,2,1};
        arr = insertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}