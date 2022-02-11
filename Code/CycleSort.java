import java.util.Arrays;
public class CycleSort {
    
    /*
        *** Use this sorting algorithm only when n array elements are given with a range of [1,n] or [0,n] ***
        For zero-based indexing:
        For range [1,n]: value at index i should be i+1
        For range [0,n]: value at index i should be i

        -> Time Complexity : O(n)
        -> Auxiliary Space Complexity : O(1)
        -> Inplace? Yes
        -> Stable? No
    */

    public static int[] cyclesort(int[] arr){
        if(arr==null || arr.length<=1) return arr;
        int n = arr.length;
        int total_swaps = 0;
        // n passes
        // Each pass will place an element on its correct index one by one
        
        int i=0;
        while(i<n){
            int value = arr[i];
            int index = value-1;
            //swap
            if(index<n  &&  arr[i]!=arr[index]){
                int temp = arr[index];
                arr[index] = value;
                arr[i] = temp;
                total_swaps++;
            }
            else{
                i++;
            }
        }

        System.out.println("Total Swaps = " + total_swaps);
        return arr;
    }

    public static void main(String[] args){
        // SUppose our range is [1,n]
        int[] arr = {5,3,1,2,4};
        arr = cyclesort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
