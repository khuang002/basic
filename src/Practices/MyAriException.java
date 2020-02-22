package Practices;

import java.util.Arrays;

public class MyAriException extends ArithmeticException {
    public MyAriException() {
    }

    public MyAriException(String s) {
        super(s);
    }
}

class ExceptionTest{
    public static void main(String[] args){
        int[] array = new int[5];
        Arrays.fill(array, 5);
        for (int i=4; i>-1; i--){
            if(i == 0){
                throw new MyAriException("There is an exception occurred");
            }
            System.out.println("Array[" + i + "]/" + i + " = " + array[i]/i);
        }
    }
}