import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class filesystem {
    static final String FILE_NAME = "data.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add student");
            System.out.println("2. View students");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = readNumber();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.print("Do you want to exit? (yes/no): ");
                    String exitChoice = sc.nextLine();
                    if (exitChoice.equalsIgnoreCase("yes")
                            || exitChoice.equalsIgnoreCase("y")) {
                        System.out.println("Thank you.");
                    } else {
                        choice = 0;
                        System.out.println("Exit cancelled.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = readNumber();
        System.out.print("Enter course: ");
        String course = sc.nextLine();

        ArrayList<Student> students = readStudents();
        int nextId = 1;
        for (Student student : students) {
            if (student.id >= nextId) {
                nextId = student.id + 1;
            }
        }

        students.add(new Student(nextId, name, rollNumber, course));
        saveStudents(students);
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        ArrayList<Student> students = readStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nID\tName\t\tRoll No\tCourse");
        for (Student student : students) {
            System.out.println(student.id + "\t" + student.name + "\t\t"
                    + student.rollNumber + "\t" + student.course);
        }
    }

    static void updateStudent() {
        ArrayList<Student> students = readStudents();
        System.out.print("Enter student ID to update: ");
        int id = readNumber();
        Student student = findStudent(students, id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        student.name = sc.nextLine();
        System.out.print("Enter new roll number: ");
        student.rollNumber = readNumber();
        System.out.print("Enter new course: ");
        student.course = sc.nextLine();
        saveStudents(students);
        System.out.println("Student updated successfully.");
    }

    static void deleteStudent() {
        ArrayList<Student> students = readStudents();
        System.out.print("Enter student ID to delete: ");
        int id = readNumber();
        Student student = findStudent(students, id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Are you sure you want to delete this student? (yes/no): ");
        String deleteChoice = sc.nextLine();
        if (deleteChoice.equalsIgnoreCase("yes")
                || deleteChoice.equalsIgnoreCase("y")) {
            students.remove(student);
            saveStudents(students);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    static Student findStudent(ArrayList<Student> students, int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    static ArrayList<Student> readStudents() {
        ArrayList<Student> students = new ArrayList<>();
        if (!new File(FILE_NAME).exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] values = line.split(",", -1);
                if (values.length == 4) {
                    students.add(new Student(Integer.parseInt(values[0]), values[1],
                            Integer.parseInt(values[2]), values[3]));
                } else if (line.startsWith("Name:")) {
                    String name = line.substring(5).trim();
                    String rollLine = reader.readLine();
                    if (rollLine != null && rollLine.startsWith("Roll No:")) {
                        int rollNumber = Integer.parseInt(rollLine.substring(8).trim());
                        students.add(new Student(students.size() + 1, name,
                                rollNumber, "Not provided"));
                    }
                }
            }
        } catch (IOException | NumberFormatException exception) {
            System.out.println("Could not read student data.");
        }

        return students;
    }

    static void saveStudents(ArrayList<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.println(student.id + "," + student.name + ","
                        + student.rollNumber + "," + student.course);
            }
        } catch (IOException exception) {
            System.out.println("Could not save student data.");
        }
    }

    static int readNumber() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a number: ");
            sc.nextLine();
        }
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }
}
