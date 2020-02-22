package Practices;

import java.util.Arrays;

public class LambdaPractice {
    public static void main(String[] args) {
        int[] arr = {3, 23, 4, 4, 22, 34, 45, 1, 33};
        System.out.println("Min is："+Arrays.stream(arr).min().getAsInt());
        System.out.println("Result is：" + Arrays.stream(arr).distinct().map((i) -> i * 2).sum());
    }
}
