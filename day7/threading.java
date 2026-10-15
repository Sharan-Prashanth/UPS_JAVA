class first extends Thread{
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread 1");
    }
}

class second extends Thread{
    public void run(){
        System.out.println("Thread 2");
    }

}


class threading extends Thread {
    public void run() {
        first a = new first();
        second b = new second();
        a.start();
        b.start();
    }

    public static void main(String args[]) {
        threading t1 = new threading();
        threading t2 = new threading();
        
        t1.start();
    }
}




