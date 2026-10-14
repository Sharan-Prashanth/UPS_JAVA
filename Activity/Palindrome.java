import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        boolean palindrome = true;

        for (int i = 0; i < text.length() / 2; i++) {
            char first = text.charAt(i);
            char last = text.charAt(text.length() - 1 - i);
            if (first >= 'A' && first <= 'Z') {
                first = (char) (first + 32);
            }
            if (last >= 'A' && last <= 'Z') {
                last = (char) (last + 32);
            }
            if (first != last) {
                palindrome = false;
                break;
            }
        }

        if (palindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}
