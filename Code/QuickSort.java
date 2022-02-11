import java.util.Arrays;

public class QuickSort {

    /*
        -> Time Complexity : O(nlogn) in avg and O(n^2) in worst
        -> Space Complexity : O(logn) in avg and O(n) in worst because no other container was made by the recursion calls
        -> Inplace ? Yes
        -> Stable ? No
    */

    public static void quicksort(int[] arr, int start, int end) {
        if(start>=end) return;
        // Select a random pivot
        // It can be the last element or first element or mid elemnt
        // or a random pivot (Randomized QuickSort)
        int mid = start + (end-start)/2;
        int pivot = arr[mid];
        // Put elements smaller than pivot on the left
        // Put elements greater than pivot on the right
        // In short put pivot on its correct position relative to other elements
        int s=start, e=end;
        while(s<=e){
            while(arr[s]<pivot) s++;
            while(arr[e]>pivot) e--;
            // swap
            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++; e--;
            }
        }
        // Recursion Calls
        quicksort(arr, start, e);
        quicksort(arr, s, end);
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
