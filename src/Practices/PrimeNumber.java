package Practices;

public class PrimeNumber {
    public static void main(String[] args){
        int count = 0;
        for (int i = 101; i<=200; i++){
            if(checkPrime(i)){
                System.out.println(i);
                count++;
            }
        }
        System.out.println("Total number of prime number is: "+count);
    }
    private static boolean checkPrime(int i){
        boolean isPrime = true;
        double sqrt = Math.sqrt(i);
        if (sqrt < 2){
            return isPrime;
        }
        for (int j = 2; j<=sqrt;j++){
            // use modulus function to check if it's prime number
            if (i%j == 0){
                isPrime = false;
            }
        }
        return isPrime;
    }
}
