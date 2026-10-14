import java.io.*;
import java.util.*;
class filesystem {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int rollno = sc.nextInt();
    try{
        FileWriter fw = new FileWriter("data.txt",true);
        fw.write("Name: " + name + "\n");
        fw.write("Roll No: " + rollno + "\n");
        fw.close();}
        
        catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }

        FileReader fr = new FileReader("data.txt");
        while(fr.hasnext()!=null){
            System.out.println(fr.nextLine());
        }
        fr.close();

    }
}