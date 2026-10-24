import java.io.*;
import java.nio.file.*;
import java.util.*;

class empmanager {
    private static final Path FILE = Path.of("employees.txt");
    private final List<Employee> employees = new ArrayList<>();
    private final Map<Integer, Employee> employeesById = new HashMap<>();
    private final Set<Integer> employeeIds = new HashSet<>();

    private static final class Employee {
        private final int id;
        private final String name;
        private final String department;
        private double salary;

        private Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        private String toFileLine() {
            return id + "|" + name + "|" + department + "|" + salary;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Department: "
                    + department + ", Salary: " + salary;
        }
    }

    public static void main(String[] args) {
        empmanager manager = new empmanager();
        try {
            manager.loadEmployees();
            manager.runMenu();
        } catch (IOException exception) {
            System.err.println("Could not load employee records: "
                    + exception.getMessage());
        }
    }

    private void runMenu() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();
                int choice = readInteger(scanner, "Choose an option: ");
                switch (choice) {
                    case 1 -> addEmployee(scanner);
                    case 2 -> searchEmployee(scanner);
                    case 3 -> updateSalary(scanner);
                    case 4 -> deleteEmployee(scanner);
                    case 5 -> displayEmployees();
                    case 6 -> {
                        saveEmployees();
                        System.out.println("Records saved. Goodbye.");
                        running = false;
                    }
                    default -> System.out.println("Please choose an option from 1 to 6.");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add Employee  2. Search Employee  3. Update Salary");
        System.out.println("4. Delete Employee  5. Display All  6. Save and Exit");
    }

    private void addEmployee(Scanner scanner) {
        int id = readInteger(scanner, "Employee ID: ");
        if (employeeIds.contains(id)) {
            System.out.println("An employee with that ID already exists.");
            return;
        }
        String name = readText(scanner, "Name: ");
        String department = readText(scanner, "Department: ");
        double salary = readNonNegativeDouble(scanner, "Salary: ");
        Employee employee = new Employee(id, name, department, salary);
        employees.add(employee);
        employeesById.put(id, employee);
        employeeIds.add(id);
        System.out.println("Employee added.");
    }

    private void searchEmployee(Scanner scanner) {
        Employee employee = employeesById.get(readInteger(scanner, "Employee ID: "));
        System.out.println(employee == null ? "Employee not found." : employee);
    }

    private void updateSalary(Scanner scanner) {
        Employee employee = employeesById.get(readInteger(scanner, "Employee ID: "));
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
        employee.salary = readNonNegativeDouble(scanner, "New salary: ");
        System.out.println("Salary updated.");
    }

    private void deleteEmployee(Scanner scanner) {
        int id = readInteger(scanner, "Employee ID: ");
        Employee employee = employeesById.remove(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
        employees.remove(employee);
        employeeIds.remove(id);
        System.out.println("Employee deleted.");
    }

    private void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    private void loadEmployees() throws IOException {
        if (!Files.exists(FILE)) {
            return;
        }
        try (BufferedReader reader = Files.newBufferedReader(FILE)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|", -1);
                if (fields.length != 4) {
                    throw new IOException("Invalid employee record: " + line);
                }
                Employee employee = new Employee(Integer.parseInt(fields[0]),
                        fields[1], fields[2], Double.parseDouble(fields[3]));
                if (employeeIds.contains(employee.id)) {
                    throw new IOException("Duplicate employee ID: " + employee.id);
                }
                employees.add(employee);
                employeesById.put(employee.id, employee);
                employeeIds.add(employee.id);
            }
        } catch (NumberFormatException exception) {
            throw new IOException("Employee file contains invalid numeric data.", exception);
        }
    }

    private void saveEmployees() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(FILE,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Employee employee : employees) {
                writer.write(employee.toFileLine());
                writer.newLine();
            }
        }
    }

    private static int readInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Enter a valid whole number.");
            }
        }
    }

    private static double readNonNegativeDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (Double.isFinite(value) && value >= 0) {
                    return value;
                }
            } catch (NumberFormatException exception) {
                // The common validation message below is shown for invalid input.
            }
            System.out.println("Enter a non-negative number.");
        }
    }

    private static String readText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && !input.contains("|")) {
                return input;
            }
            System.out.println("Value cannot be empty or contain '|'.");
        }
    }
}
