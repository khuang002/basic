package Practices;
import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr){
        int temp;
        for (int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] ints = { 99, 12, 11, 13, 5, 6 };
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
