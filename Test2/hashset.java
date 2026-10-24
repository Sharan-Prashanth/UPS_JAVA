import java.util.A*;

class hashset {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 10, 30, 20, 40, 50, 30};
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }

        System.out.println("Input: " + Arrays.toString(numbers));
        System.out.println("Unique values: " + set);
        System.out.println("Number of unique elements: " + set.size());
        System.out.println("Contains 40: " + set.contains(40));
        System.out.println("HashSet does not guarantee insertion or sorted order.");
    }
}
