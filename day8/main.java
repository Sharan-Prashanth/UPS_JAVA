
import java.util.*;
class student{
    int roll;
    String name;
    int age;
    student(String n,int r,int a){
        name = n;
        roll = r;
        age = a;
    }

    void display(){
        System.out.println("Name: " + name + " roll: " + roll + " age: " + age);
    }
}

class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<student> arr = new ArrayList<>();
        boolean flag = true;
        
        while(flag){
            System.out.println("Enter the choice");
            System.out.println("1. Add Students\n 2. View the \n3. Exit");
            int ch = sc.nextInt();
            switch(ch){
                case 1:{
                    System.out.println("Enter the Name, roll, age");
                    String name = sc.next();
                    int roll = sc.nextInt();
                    int age = sc.nextInt();
                    student obj = new student(name,roll,age);
                    arr.add(obj);
                    break;
                }
                case 2:{
                    System.out.println("Student list");
                    for(student x : arr){
                        x.display();
                    }
                    break;
                }
                case 3:{
                    flag = false;
                    break;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        System.out.print("Hashset :");
       System.out.println(set);

       TreeSet<Integer> tset = new TreeSet<>();
        tset.add(1);
        tset.add(2);
        tset.add(2);
        System.out.print("TreeSet :");
        for(int i: set) System.out.println(tset);
    }
}