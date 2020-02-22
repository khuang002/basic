package Practices;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr, int low, int high){
        int pi;
        if(low < high){
            pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        // i to keep track of index of elements smaller than pivot
        int i = low-1;
        // choose the last element as the pivot
        for (int j=low; j<high; j++){
            if (arr[j] < arr[high]){
                arraySwap(arr, j, ++i);
            }
        }
        arraySwap(arr, high, ++i);
        return i;
    }

    public static void arraySwap(int[] arr, int a, int b){
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args){
        int[] ints = { 99, 12, 11, 13, 5, 6, 101, 8};
        sort(ints, 0, ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}
