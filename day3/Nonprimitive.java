import java.util.*;
import java.lang.Math;
class Nonprimitive{

// Function to find the sum of even numbers in an array
    public static int val(int arr[]){
        int sum = 0;
        for(int i: arr){
            if (i % 2 == 0){
                sum += i;
            } 
        }
        return sum;
    }

// User input for Matrix creation
    public static int[][] input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Row :  ");
        int r = sc.nextInt();
        System.out.print("Enter the column: ");
        int c = sc.nextInt();

        int arr[][] = new int[r][c];
        for(int i = 0; i < r;i++){
            for(int j = 0;j < c;j++){
                System.out.println("Enter the value for the cell" + i + j);
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

// Function to find the two sum in an array
    public static int[] twosum(int arr[],int target){
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr.length;j++){
                if (arr[i]+arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

// Function to find the target element in an array using linear search
    public static int bs(int grid[],int target){
        for(int i = 0;i < grid.length;i ++){
            if(grid[i] == target){
                return i;
            }
        }
        return -1;
    }

// Function to display the matrix
    public static void display(int matrix[][]){
        for(int i = 0; i < matrix.length ;i++){
            for(int j = 0;j < matrix[i].length ;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String []agr){
    
//Array creation and then displaying the values in the array
        int arr[] = new int[10];
        for(int i = 0; i < 10;i++){
            arr[i] = i+1;
        }

        for(int i = 0; i < 10;i++){
            System.out.println(arr[i]);
        }

        
        System.out.print("Enter the value :  ");

// Array creation and then displaying the values in the array using user input
        int size = sc.nextInt();
        int user[] = new int[size];

        for(int i = 0; i < size;i++){
            user[i] = sc.nextInt();
        }
        for(int i = 0; i < size;i++){
            System.out.println("values in the array  " + user[i]);
        }
        System.out.print("Sum of the value: " + val(user));


        int[][] matrix1 = input();
        int[][] matrix2 = input();



        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int user1[] = new int[size1];

        for(int i = 0; i < size1;i++){
            user1[i] = sc.nextInt();
        }

        int f1 = 0;
        int f2 = 0;

        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;

// Finding Minimum and Maximum in the array Using a Single Loop at O(N)

        for(int i = 0; i < size1; i++){
            if(user1[i] > f1){
                if(f2 < f1){
                    f2 = f1;
                }
                f1 = user1[i];
            }
            else{
                if(f2 <= user1[i]){
                    f2 = user1[i];
                }
            }

            if(user1[i] < m1){
                if(m2 > m1){
                    m2 = m1;
                }
                m1 = user1[i];
            }
            else{
                if(m2 >= user1[i]){
                    m2 = user1[i];
                }
            }
        }

        System.out.println("first max " + f1+" second max " +f2+ " Max");
        System.out.println("fisrt min " + m1+ " second min " +m2+ " Min");

        int size2 = sc.nextInt();
        char user2[] = new char[size2];

        for(int i = 0; i < size2;i++){
            user2[i] = sc.next().charAt(0);
        }

//Merging two char arrays
        boolean flag = true;
        char array[] = new char[size1+size2];
        int j = 0;

        for(int i = 0; i < size1 + size2; i ++){
            if(flag) { 
                array[i] = user1[j];
                j += 1;

                if (j == size1){
                flag = false;
                j = 0;
            }
            }
            else{
                array[i] = user2[j];
                j += 1;
            }
            
        }
        for(int i = 0; i < size1 + size2; i ++){
            System.out.print(array[i]+ " ");
        }

// Finding target element in the arrray using linear search
        int target = sc.nextInt();

        int[] value = twosum(user,target);
        if (value[0] == -1){
            System.out.println("Target Not found");
        }
        else{
            System.out.println("Target found" + " "+value[0]+" "+value[1]);
        }
    


// Finding Matrix Sum of two N x N matrix

        System.out.println("Matrix Sum");

        for(int i = 0;i < matrix1.length;i++){
            for(int j = 0;j < matrix1[0].length ;j++){
                matrix1[i][j] += matrix2[i][j];
            }
        }

        display(matrix1);

    }
}