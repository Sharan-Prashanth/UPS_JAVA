import java.util.*;

public class FirstUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        if (text.length() > 0) {
            char first = text.charAt(0);
            if (first >= 'a' && first <= 'z') {
                first = (char) (first - 32);
            }
            String result = "";
            result = result + first;
            for (int i = 1; i < text.length(); i++) {
                result = result + text.charAt(i);
            }
            text = result;
        }

        System.out.println("Result: " + text);
    }
}
