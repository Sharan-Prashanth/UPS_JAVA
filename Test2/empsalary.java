class empsalary {
    private static abstract class Emp {
        private final int employeeId;
        private final String name;
        private final double basicSalary;

        protected Emp(int employeeId, String name, double basicSalary) {
            this.employeeId = employeeId;
            this.name = name;
            this.basicSalary = basicSalary;
        }

        public abstract double calculateSalary();

        protected double getBasicSalary() {
            return basicSalary;
        }

        public void displayDetails() {
            System.out.printf("ID: %d, Name: %s, Final salary: %.2f%n",
                    employeeId, name, calculateSalary());
        }
    }

    private static final class FullTime extends Emp {
        private FullTime(int employeeId, String name, double basicSalary) {
            super(employeeId, name, basicSalary);
        }

        @Override
        public double calculateSalary() {
            return getBasicSalary() * 1.20;
        }
    }

    private static final class PartTime extends Emp {
        private final double hoursWorked;
        private final double hourlyRate;

        private PartTime(int employeeId, String name,
                                 double hoursWorked, double hourlyRate) {
            super(employeeId, name, 0);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary() {
            return hoursWorked * hourlyRate;
        }
    }

    public static void main(String[] args) {
        Emp[] employees = {
                new FullTime(101, "Anita", 50000),
                new PartTime(102, "Rahul", 80, 400)
        };

        for (Emp emp : employees) {
            emp.displayDetails();
        }
    }
}
