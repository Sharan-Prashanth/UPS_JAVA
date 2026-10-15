import java.util.Scanner;

public class Fact {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        long fact = 1;

        if (num < 0) {
            System.out.println("fact is not possible for a negative number.");
        } else {
            for (int i = 1; i <= num; i++) {
                fact = fact * i;
            }
            System.out.println("fact: " + fact);
        }
    }
}
