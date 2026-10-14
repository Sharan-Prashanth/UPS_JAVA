import java.util.*;

public class NoSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ' && ch != '\t') {
                result = result + ch;
            }
        }

        System.out.println("String without spaces: " + result);
    }
}
