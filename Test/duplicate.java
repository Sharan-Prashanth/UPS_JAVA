import java.util.*;
class duplicate{
    public static void main(String[] args){
        // Scanner sc = new Scanner(System.in);
        // int[] arr = new int[10];
        // int[] freq = new int[65536];
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = sc.nextInt();
        // }
        // for (int i = 0; i < arr.length; i++) {
        //     freq[arr[i]]++;
        // }
        // int[] res = new int[10];
        // for(int i = 0;i < arr.length;i ++){
        //     if (freq[arr[i]] >= 2){
        //         res[i] = arr[i];
        //     }
        // }
        // for(int i = 0;i < res.length;i ++){
        //     if (res[i] != 0){
        //         System.out.println(res[i]);
        //     }
        // }

        int[] arr = {4,2,5,6,2};
        for(int i = 0;i < arr.length;i ++){
            for(int j = i + 1;j < arr.length;j ++){
                if (arr[i] == arr[j]){
                    System.out.println(arr[i]);
                }
            }
        }
        
    }   
}