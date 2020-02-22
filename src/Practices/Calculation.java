package Practices;

// calculate a+aa+aaa+aaaa+aaa....aa where a and the number of values to add up is passed from arguments
public class Calculation {
    public static void main(String[] args){
        if (args.length != 2){
            System.out.println("Please enter the correct arguments");
            return;
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("a is "+a+" , b is "+b);
        if (a<0 || a>=10){
            System.out.println("a can only be 1-9.");
            return;
        }
        if (b<0){
            System.out.println("b must be greater than 0.");
            return;
        }
        int sum = 0;
        for (int j=1; j<=b;j++) {
            int value = 0;
            for (int i = 1; i <= j; i++) {
                value += (int) Math.pow(10, i - 1) * a;
            }
            //System.out.println(value);
            sum += value;
        }
        System.out.println("The result is: "+sum);
    }
}
