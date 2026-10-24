class nonreap{
    public static void main(String[] a){
        int[] arr = new int[26];
        String s = "swiss";
        for(int i = 0;i <s.length();i++){
            arr[s.charAt(i) - 97] += 1;
        }

        boolean flag=true;
        for(int i = 0;i < s.length();i++){
            if(arr[s.charAt(i) - 97] == 1){
                System.out.println(s.charAt(i));
                flag = false;
                break;
            } 
        }
        if (flag){
            System.out.println("Not single chr");
        }
    }
}