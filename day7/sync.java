class Shared {
    boolean ready = false;
    synchronized void consume() {
        while (!ready) {
            try {
                System.out.println("Consumer waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Consumer received data");
    }

    synchronized void produce() {
        ready = true;
        System.out.println("Producer sends data");
        notifyAll();
    }
}

class sync {
    public static void main(String[] args)
            throws InterruptedException {
        Shared obj = new Shared();
        Thread consumer = new Thread(() -> obj.consume());
        Thread producer = new Thread(() -> obj.produce());
        consumer.start();
        Thread.sleep(500);
        producer.start();
    }
}