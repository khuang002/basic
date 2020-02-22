package Practices;
import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr){
        int key;
        for (int i=1; i<arr.length; i++){
            key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args){
        int[] ints = { 99, 12, 11, 13, 5, 6 };
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
