import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = sc.nextLine();
        System.out.print("Enter second string: ");
        String second = sc.nextLine();

        int[] firstCount = new int[26];
        int[] secondCount = new int[26];

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            if (ch >= 'a' && ch <= 'z') {
                firstCount[ch - 'a']++;
            }
        }

        for (int i = 0; i < second.length(); i++) {
            char ch = second.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            if (ch >= 'a' && ch <= 'z') {
                secondCount[ch - 'a']++;
            }
        }

        boolean anagram = true;
        for (int i = 0; i < 26; i++) {
            if (firstCount[i] != secondCount[i]) {
                anagram = false;
                break;
            }
        }

        if (anagram) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }
}
