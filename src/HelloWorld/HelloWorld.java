package HelloWorld;

import java.util.*;

public class HelloWorld {
        public static class superclass
        {
            void print()
            {
                System.out.println("print in superclass.");
            }
        }
        public static class subclass extends superclass
        {
            void print()
            {
                System.out.println("print in subclass.");
            }
        }

        public static void main(String[] args)
        {
            superclass A = new superclass();
            superclass B = new subclass();
            A.print();
            B.print();
        }
}
