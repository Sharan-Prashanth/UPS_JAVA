import java.util.*;
class b<T> {
    T obj;
    b(T obj) {
        this.obj = obj;
    }
    public T getObj() {
        return this.obj;
    }
}
class collect {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        System.out.println(al);
        List<b> list = new ArrayList<>();
        list.add(new b<Integer>(1));
        list.add(new b<String>("hello"));
        System.out.println(list);
    }
}