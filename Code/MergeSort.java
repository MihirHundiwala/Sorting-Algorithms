import java.util.Arrays;

class MergeSort{

    /*
        Divide and Conquer technique

        -> Time Complexity : O(nlogn)
        -> Space Complexity : O(n)
                            : it is not O(nlogn) because we are doing depth first search, i.e,
                              we always fully expand only one branch at a time thus the stack is
                              bounded by O(n)
        -> Inplace? Yes (in this implementation)
        -> Stable? Yes (in this implementation)
    */

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end-start];
        int i = start;
        int j = mid;
        int k = 0;
        // Fill merged array with smaller elements first
        while(i<mid && j<end){
            // if the below condition is 'arr[i]<arr[j]' then the algo is unstable
            if(arr[i]<=arr[j]){
                merged[k] = arr[i];
                i++;k++;
            }
            else{
                merged[k] = arr[j];
                j++;k++;
            }
        }
        // if one array gets exhausted blindly copy the elements from other,
        // because we know the other half is already sorted
        while(i<mid){
            merged[k] = arr[i];
            i++;k++;
        }
        while(j<end){
            merged[k] = arr[j];
            j++;k++;
        }
        // reflect the changes in original array
        for (i = 0; i < merged.length; i++) {
            arr[start+i] = merged[i]; 
        }
    }

    // end is exclusive i.e the range is [start,end)
    public static void mergesort(int[] arr, int start, int end) {       
        if(end-start<=1) return;     
        int mid = start + (end-start)/2;
        mergesort(arr, start, mid);
        mergesort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        mergesort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}