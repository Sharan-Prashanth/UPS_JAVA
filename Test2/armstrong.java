class armstrong {
    public static void main(String[] args) {
        System.out.print("Armstrong numbers between 1 and 1000: ");
        boolean first = true;

        for (int i = 1; i <= 1000; i++) {
            int og = i;
            int d = count(i);
            int sum = 0;
            int rem = i;

            while (rem > 0) {
                int digit = rem % 10;
                sum += power(digit, d);
                rem /= 10;
            }

            boolean flag = og == 1 || (og >= 10 && sum == og);
            if (flag) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(og);
                first = false;
            }
        }
        System.out.println();
    }

    private static int count(int num) {
        int d = 0;
        do {
            d++;
            num /= 10;
        } while (num > 0);
        return d;
    }

    private static int power(int base, int exp) {
        int res = 1;
        for (int i = 0; i < exp; i++) {
            res *= base;
        }
        return res;
    }
}
