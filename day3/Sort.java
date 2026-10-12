import java.util.Scanner;
class sort{
    public static int getarr(int arr[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        return 0;
        
    }
    static int merge(int arr1[],int arr2[],int n){
        int arr3[]=new int[2*n];
        for(int i=0;i<n;i++){
            arr3[i]=arr1[i];
        }
        for(int i=0;i<n;i++){
            arr3[n+i]=arr2[i];
        }
        for(int i=0;i<2*n;i++){
            for(int j=i+1;j<2*n;j++){
                if(arr3[i]>arr3[j]){
                    int temp=arr3[i];
                    arr3[i]=arr3[j];
                    arr3[j]=temp;
                }
            }
        }
        System.out.println("The merged array in ascending order is:");
        for(int i=0;i<2*n;i++){
            System.out.print(arr3[i]+" ");
        }
        return 0;
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr1[]=new int[n];
        getarr(arr1);
        int arr2[]=new int[n];
        getarr(arr2);
        System.out.println("Merged array in ascending order is:");
        merge(arr1,arr2,n);

    }
}