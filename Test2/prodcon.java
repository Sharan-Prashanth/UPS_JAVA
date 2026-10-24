class prodcon {
    private static final class NumberBuffer {
        private Integer number;
        private boolean finished;

        public synchronized void produce(int nextNumber) throws InterruptedException {
            while (number != null) {
                wait();
            }
            number = nextNumber;
            System.out.println("Produced: " + nextNumber);
            notifyAll();
        }

        public synchronized Integer consume() throws InterruptedException {
            while (number == null && !finished) {
                wait();
            }
            if (number == null) {
                return null;
            }
            int consumedNumber = number;
            number = null;
            notifyAll();
            return consumedNumber;
        }

        public synchronized void finish() {
            finished = true;
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NumberBuffer numberBuffer = new NumberBuffer();
        Thread producer = new Thread(() -> {
            try {
                for (int number = 1; number <= 5; number++) {
                    numberBuffer.produce(number);
                }
                numberBuffer.finish();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            try {
                Integer consumedNumber;
                while ((consumedNumber = numberBuffer.consume()) != null) {
                    System.out.println("Consumed: " + consumedNumber);
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("Producer and consumer completed.");
    }
}
