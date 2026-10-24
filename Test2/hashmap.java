import java.util.*;

class hashmap {
    public static void main(String[] args) {
        countWords("java is easy and java is powerful");
        countWords("   ");
    }

    public static void countWords(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            System.out.println("The sentence is empty.");
            return;
        }

        for (String word : sentence.toLowerCase().trim().split("\\s+")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word counts: " + map);
        String most = null;
        int high = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > high) {
                most = entry.getKey();
                high = entry.getValue();
            }
        }
        System.out.println("Most frequent word: " + most + " (" + high + " times)");
    }
}
