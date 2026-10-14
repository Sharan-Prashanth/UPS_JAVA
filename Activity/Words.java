import java.util.*;

public class Words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        int words = 0;
        boolean insideWord = false;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch != ' ' && ch != '\t' && ch != '\n') {
                if (!insideWord) {
                    words++;
                    insideWord = true;
                }
            } else {
                insideWord = false;
            }
        }

        System.out.println("Number of words: " + words);
    }
}
