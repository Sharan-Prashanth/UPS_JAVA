import java.util.*;

public class zerodivisible {
    public static void validate(int age) 
      throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
        System.out.println("Valid age: " + age);
    }

    public static void main(String[] args) {
        try {
            validate(12);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}


        // try {
        //     int a = 10;
        //     int b = 0;
        //     int arr[] = {1, 2, 3};
        //     int c = a / b;

            
        // } 
        // catch (Exception e) {
        //     System.out.println("Zero cannot be a divisor" + e);
//}