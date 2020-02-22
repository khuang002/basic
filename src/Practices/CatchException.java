package Practices;

public class CatchException {
    public static void main(String[] args){
        try{
            System.out.println("I'm try block.");
            Class<?> tempClass = Class.forName("");
            System.out.println("End of try block.");
        } catch (ClassNotFoundException e){
            System.out.println("I'm catch block.");
            e.printStackTrace();
            System.out.println("End of catch block.");
        } finally {
            System.out.println("I'm finally block.");
        }
    }
}
