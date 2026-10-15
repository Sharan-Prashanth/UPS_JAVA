import java.util.Scanner;

public class ArrSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        int[] num = new int[size];
        int sum = 0;

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            num[i] = sc.nextInt();
            sum = sum + num[i];
        }

        System.out.println("Sum of array elements: " + sum);
    }
}
