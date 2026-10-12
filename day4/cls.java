import java.util.Scanner;
class access{

        private String name;
        private int age;
        private int rollno;

        void setname(String name, int age, int rollno){
            this.name=name;
            this.age=age;
            this.rollno=rollno;
        }

        void display(){
            System.out.println("name "+name);
            System.out.println("age "+age);
            System.out.println("rollno "+rollno);
        }

        void changename(String name){
            this.name=name;
        }
        
        void changeage(int age){
            this.age=age;
        }

        void changeno(int rollno){
            this.rollno=rollno;
        }

        void getdetails(int idx){
            System.out.println("Student "+(idx+1));
            System.out.println("name "+name);
            System.out.println("age "+age);
            System.out.println("rollno "+rollno);
        }
    

}

class cls{
    
    public static void main(String[] args){


        // access obj1 = new access();
        // access obj2 = new access();
        // access obj3 = new access();
        // System.out.println("student 1");
        // obj1.setname("sharan", 20, 101);
        // obj1.display();
        // System.out.println("student 2");
        // obj2.setname("karthi", 22, 102);
        // obj2.display();
        // System.out.println("student 3");
        // obj3.setname("durai", 21, 103);
        // obj3.display();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int size = sc.nextInt();
        access arr[] = new access[size];
        for(int i=0;i<size;i++){
            arr[i] = new access();
            System.out.println("Enter the name,age and rollno student");
            String name = sc.next();
            int age = sc.nextInt();
            int rollno = sc.nextInt();
            arr[i].setname(name, age, rollno);
        }

        for(int i=0;i<size;i++){
            System.out.println("Student data : "+(i+1));
            arr[i].display();
        }

        System.out.println("Setting new object data: ");
        System.out.println("new id: ");
        int newid = sc.nextInt();
        System.out.println("new name: ");
        String newname = sc.next();
        System.out.println("new age: ");
        int newage = sc.nextInt();
        System.out.println("enter the object number: ");
        int idx = sc.nextInt();
        arr[idx-1].changeno(newid);
        arr[idx-1].changename(newname);
        arr[idx-1].changeage(newage);
        arr[idx-1].getdetails(idx-1);
    }
}