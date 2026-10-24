class rotate{
    public static void main(String[] a){
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        int[] res = new int[arr.length];
        int idx = 0;

        for(int i = k+1; i < arr.length;i++){
            res[idx++] = arr[i];
        }
        for(int i = 0; i < k+1;i++){
            res[idx++] = arr[i];
        }
        for(int i =0;i<res.length;i++){
            System.out.print(res[i]+ " ");
        }
    }
}