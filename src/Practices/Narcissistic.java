package Practices;

public class Narcissistic {
    public static void main(String[] args){
        for (int i = 100; i<=999; i++){
            if (checkNarcissistic(i)){
                System.out.println(i);
            }
        }
    }
    private static boolean checkNarcissistic(int i){
        int hundreds = (int) i/100;
        int tens = (int) (i-100*hundreds)/10;
        int units = i-100*hundreds-10*tens;
        if ((Math.pow(hundreds,3)+Math.pow(tens,3)+Math.pow(units,3)) == i){
            return true;
        } else{
            return false;
        }
    }
}
