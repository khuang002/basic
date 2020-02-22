package Practices;

public class BinarySearch {

    public static int search(int[] arr, int key, int low, int high){
        int mid;
        if (low <= high){
            mid = (high + low)/2;
            if (arr[mid] == key){
                return mid;
            } else if (arr[mid] > key){
                return search(arr, key, low, mid-1);
            } else {
                return search(arr, key, mid+1, high);
                        }
                        }
                        return -1;
                        }

public static void main(String[] args){
        int[] ints = { 5, 6, 8, 11, 12, 13, 99, 101};
        int key = 10;
        int index = search(ints, key, 0, ints.length-1);
        if(index == -1){
        System.out.println(key+" doesn't exit in the array.");
        } else{
        System.out.println(key+" is in index "+index);
        }
        }
        }
