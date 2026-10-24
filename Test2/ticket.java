class ticket {
    private static final class Counter {
        private int tickets = 10;

        public synchronized int bookTickets(String customerName, int requestedTickets) {
            int bookedTickets = Math.min(requestedTickets, tickets);
            tickets -= bookedTickets;
            System.out.printf("%s booked %d ticket(s). Remaining: %d%n",
                    customerName, bookedTickets, tickets);
            return bookedTickets;
        }

        public synchronized int getAvailableTickets() {
            return tickets;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] customers = new Thread[3];

        for (int index = 0; index < customers.length; index++) {
            String customerName = "Customer-" + (index + 1);
            customers[index] = new Thread(
                    () -> counter.bookTickets(customerName, 4), customerName);
            customers[index].start();
        }
        for (Thread customer : customers) {
            customer.join();
        }
        System.out.println("Final remaining tickets: "
                + counter.getAvailableTickets());
    }
}
