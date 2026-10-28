import java.util.*;

class stream{
    public static void main(String[] arg){
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);
        lst.add(7);
        lst.add(8);
        lst.stream().filter(n -> n % 2 == 0).forEach(s -> System.out.print("Even " + s));
        lst.stream().map(n -> n * n).forEach(s -> System.out.print("Mul: " + s));
        lst.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        lst.stream().sorted((a,b) -> b.compareTo(a)).forEach(s -> System.out.print("sort " + s));
        lst.stream().distinct().forEach(System.out::println);
    }
}