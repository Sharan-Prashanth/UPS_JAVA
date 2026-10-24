class InsufAmt extends RuntimeException{
    public InsufAmt(String msg){
        super(msg);
    }
}


class bankacc{
    private int balance;
    public bankacc(int b){
        balance = b;
    }
    public void deposit(int amt){
        balance += amt;
        System.out.println("Deposited amount: " + amt);
    }
    public void withdraw(int amt){
        if (amt > balance){
            throw new InsufAmt("Insufficient balance" + balance);
        }
        else{
            balance -=amt;
            System.out.println("Withdrawn Completed");
        }
    }
}

class Account{
    public static void main(String[] a){
        bankacc obj = new bankacc(5000);
        obj.deposit(999);
        try {
            obj.withdraw(6000);
        }
        catch(InsufAmt e){
            System.out.println(e.getMessage());
        }
    }
}