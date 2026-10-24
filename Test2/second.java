class second {
    public static void main(String[] args) {
        int[] numbers = {12, 45, 7, 45, 32, 18};
        Integer largest = null;
        Integer second = null;

        for (int number : numbers) {
            if (largest == null || number > largest) {
                second = largest;
                largest = number;
            } else if (number != largest
                    && (second == null || number > second)) {
                second = number;
            }
        }

        if (second == null) {
            System.out.println("No second-largest distinct element exists.");
        } else {
            System.out.println("Second largest: " + second);
        }
    }
}
