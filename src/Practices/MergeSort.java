package Practices;
import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] arr, int start, int middle, int end){
            int temp[] = new int[end - start + 1];
            int i=start;
            int j=middle+1;
            int z=0;
            // compare the first items of the unsorted items in left and right arrays
            // write the smaller to the temp array
            while (i<=middle && j<=end){
                if(arr[i] < arr[j]){
                    temp[z++] = arr[i++];
                } else {
                    temp[z++] = arr[j++];
                }
            }
            // write the rest of the left array if any
            while (i<=middle){
                temp[z++] = arr[i++];
            }
            // write the rest of the right array if any
            while (j<=end){
                temp[z++] = arr[j++];
            }
            // write temp to the original array
            for(int x=0; x<temp.length; x++){
                arr[x+start] = temp[x];
            }
    }
    public static void sort(int[] arr, int start, int end){
        if(start < end){
            // where I made mistake: middle != end/2
            int middle = (start+end)/2;
            sort(arr, start, middle);
            sort(arr,middle+1, end);
            // where I made mistake: middle != end/2
            merge(arr, start, middle, end);
        }
    }

    public static void main(String[] args){
        int[] ints = { 99, 12, 11, 13, 5, 6, 101};
        sort(ints, 0, ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}
