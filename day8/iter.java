import java.util.*;
class iter{
    public static void main(String[] a){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        System.out.println(map);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0;i < 5;i++){
            q.offer(i);
        }
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q.peek());
    }   
}