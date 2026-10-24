class anagram{
    public static void main(String[] a){
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        String one = "catee";
        String two = "tac";

        if(one.length() > two.length() || two.length() > one.length()){
            System.out.println("False");
        }
        for(int i = 0;i<one.length();i++){
            arr[one.charAt(i) - 97] += 1;
        }
        for(int i = 0;i<two.length();i++){
            arr2[two.charAt(i) - 97] += 1;
        }
        boolean flag = true;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != arr2[i]){
                System.out.println("False");
                flag = false;
            }
        }
        if(flag){
            System.out.print("True");
        }

    }
}