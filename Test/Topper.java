class Student{
    int rollno;
    String name;
    int[] marks = new int[5];
    float avg;
    int total;
    Student(int rollno,String name,int[] marks){
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
        int t = 0;
        for(int i = 0;i < marks.length;i++){
            t += marks[i];
        }
        this.total = t;
        this.avg = total / 5;
    }

    public int total(){
        return total;
    }

    public float avg(){
        return avg;
    }
    public String name(){
        return name;
    }
    public char grade(){
        if(avg >= 90){
            return 'A';
        }
        else if(avg >= 80){
            return 'B';
        }
        else if(avg >= 70){
            return 'C';
        }
        else if(avg >= 60){
            return 'D';
        }
        else{
            return 'F';
        }
    }
}

class Topper{
    public static void main(String[] a){
        Student obj1 = new Student(1,"Sharan", new int[]{1,2,3,4,5});
        Student obj2 = new Student(1,"Prashanth",new int[]{1,2,3,4,5});
        Student obj3 = new Student(1,"Karthi",new int[]{1,2,3,4,5});
        Student obj4 = new Student(1,"Kishore",new int[]{1,2,3,4,5});
        Student obj5 = new Student(1,"Mukesh",new int[]{1,2,3,4,5});
        Student arr[] = new Student[]{obj1,obj2,obj3,obj4,obj5};
        for(Student x: arr){
            System.out.println("name: " + x.name());
            System.out.println("total: " + x.total());
            System.out.println("grade: " + x.grade());
            System.out.println("average: " + x.avg());
        }
       
    }
}