import java.util.Scanner;
class Cases{
    public static void main(String[] args){
        int ticket = 1;
        boolean exit = false;
        while(!exit){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Ticket Number: " + ticket);
        ticket += 1;
        System.out.println("Enter the Theater No.: ");
        System.out.print("1. PVR\n2. Inox\n3. Rohini\n4. Exit\n");
        int theater = sc.nextInt();
        
        switch(theater){
            case 1:{
                System.out.println("You have selected PVR");
                System.out.println("Enter the Movie No.: ");
                System.out.print("1. MM2\n2. Baththa\n3. Jailer 2\n4. Exit\n");
                int movie = sc.nextInt();

                if (movie == 1){
                    System.out.println("Ticket booked for MM2");
                } 
                else if (movie == 2){
                    System.out.println("Ticket booked for Baththa");
                } 
                else if (movie == 3){
                    System.out.println("Ticket booked for Jailer 2");
                }
                else if(movie == 4){
                    System.out.println("exit");
                    break;
                }
                else {
                    System.out.println("Invalid Movie selection");
                }
                break;
            }

            case 2:
                 {  
                System.out.println("You have selected Inox");
                System.out.println("Enter the Movie No.: ");
                System.out.print("1. The Paradise\n2. Thug Life\n3. Toxic\n");
                int movie = sc.nextInt();
                
                if (movie == 1){
                    System.out.println("Ticket booked for The Paradise");
                } 
                else if (movie == 2){
                    System.out.println("Ticket booked for Thug Life");
                } 
                else if (movie == 3){
                    System.out.println("Ticket booked for Toxic");
                } 
                else if(movie == 4){
                    System.out.println("exit");
                    break;
                }
                else {
                    System.out.println("Invalid Movie selection");
                }
                break;
            }

            case 3:{
                System.out.println("You have selected Rohini");
                System.out.println("Enter the Movie No.: ");
                System.out.print("1. Leo\n2. Mersal\n3.  Gilli\n");
                int movie = sc.nextInt();

                if (movie == 1){
                    System.out.println("Ticket booked for Leo");
                } 
                else if (movie == 2){
                    System.out.println("Ticket booked for Mersal");
                } 
                else if (movie == 3){
                    System.out.println("Ticket booked for Gilli");
                } 
                else if(movie == 4){
                    System.out.println("exit");
                    break;
                }
             else {
                    System.out.println("Invalid Movie selection");
                }
                break;
            }
            case 4:{
                System.out.println("Exiting the program");
                exit = true;
                break;
            }
            default:{
                System.out.println("Invalid selection");
                }
        }}
    }
}