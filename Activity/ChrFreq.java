import java.util.*;

public class ChrFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        int[] frequency = new int[65536];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean alreadyShown = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    alreadyShown = true;
                    break;
                }
            }

            if (!alreadyShown) {
                if (ch == ' ') {
                    System.out.println("[space] = " + frequency[ch]);
                } else {
                    System.out.println(ch + " = " + frequency[ch]);
                }
            }
        }
    }
}


public class BubbleSortExample {
    public static void main(String[] args) {
        int[] arr = {35, 12, 8, 67, 21, 4};

        // Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}