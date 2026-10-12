import java.util.Scanner;

class atm{
    static int balance = 0;
    atm(int amount){
        System.out.println("ATM Machine");
        this.balance = amount;
    }

    void withdraw(int amount){
        if(amount>balance){
            System.out.println("Insufficient balance");
        }
        else{
            balance -= amount;
            System.out.println("Withdrawn: "+amount);
            System.out.println("Balance: "+balance);
        }
    }
}

class shared{
    public static void main(String[] args){
       atm obj = new atm(1000000);
        boolean flag = true;
        while(flag){
            Scanner sc = new Scanner(System.in);
            
            System.out.println("ATM Operations ");
            System.out.println("1. withdraw\n 2. balance\n 3. exit");
            int op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Enter the amount: ");
                    int wd = sc.nextInt();
                    obj.withdraw(wd);
                    break;
                case 2:
                    System.out.println("Balance: " + atm.balance);
                    break;
                case 3:    
                    flag = false;
                    break;
            }
        }
        
    }
}