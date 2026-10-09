import java.util.Scanner;
class Methods {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        return (double) a / b;
    }

    public static boolean odd(int a) {
        return a % 2 == 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int a = sc.nextInt();
        int b = a % 2;
        switch(b){
            case 1:
                System.out.println("odd");
                break;
            case 0:
                System.out.println("even");
                break;
        }


        // while (flag){
        //     System.out.println("Choose an operation: 1. Add\n 2. Subtract\n 3. Multiply\n 4. Divide\n 5. Exit");
        //     int op = sc.nextInt();
        //     if(op == 5){
        //         flag= false;
        //         break;
        //     }
        //      System.out.println("Enter the first number: ");
        //     int a = sc.nextInt();
        //     System.out.println("Enter the second number: ");
        //     int b = sc.nextInt();
        //     if(op == 1){
        //         System.out.println("Result: " + add(a, b));
        //     } 
        //     else if(op == 2){
        //         System.out.println("Result: " + subtract(a, b));
        //     }
        //      else if(op == 3){
        //         System.out.println("Result: " + multiply(a, b));
        //     }
        //      else if(op == 4){
        //         System.out.println("Result: " + divide(a, b));
        //     }
        //      else if(op == 5){
        //         flag = false;
        //     }
        // else {
        //         System.out.println("Invalid operation");
        //     }

            
        // }
    }

}