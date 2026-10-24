import java.io.*;
import java.nio.file.*;
import java.util.*;

class studentfile {
    private static final Path FILE = Path.of("students.txt");

    private static final class StudentRecord {
        private final int studentId;
        private final String name;
        private final double marks;

        private StudentRecord(int studentId, String name, double marks) {
            this.studentId = studentId;
            this.name = name;
            this.marks = marks;
        }

        private String toFileLine() {
            return studentId + "|" + name + "|" + marks;
        }

        @Override
        public String toString() {
            return "ID: " + studentId + ", Name: " + name + ", Marks: " + marks;
        }
    }

    public static void main(String[] args) {
        List<StudentRecord> initialRecords = new ArrayList<>();
        initialRecords.add(new StudentRecord(1, "Asha", 88));
        initialRecords.add(new StudentRecord(2, "Bala", 76));
        initialRecords.add(new StudentRecord(3, "Chitra", 94));
        initialRecords.add(new StudentRecord(4, "Dev", 81));
        initialRecords.add(new StudentRecord(5, "Esha", 90));

        try {
            writeRecords(initialRecords);
            displayRecords(readRecords());
            appendRecord(new StudentRecord(6, "Farhan", 86));
            System.out.println("\nAfter appending a new student:");
            displayRecords(readRecords());
        } catch (IOException | IllegalArgumentException exception) {
            System.err.println("Unable to process student records: "
                    + exception.getMessage());
        }
    }

    private static void writeRecords(List<StudentRecord> records) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(FILE)) {
            for (StudentRecord record : records) {
                writer.write(record.toFileLine());
                writer.newLine();
            }
        }
    }

    private static void appendRecord(StudentRecord record) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(FILE,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(record.toFileLine());
            writer.newLine();
        }
    }

    private static List<StudentRecord> readRecords() throws IOException {
        List<StudentRecord> records = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(FILE)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|", -1);
                if (fields.length != 3) {
                    throw new IOException("Invalid record: " + line);
                }
                records.add(new StudentRecord(Integer.parseInt(fields[0]),
                        fields[1], Double.parseDouble(fields[2])));
            }
        }
        return records;
    }

    private static void displayRecords(List<StudentRecord> records) {
        StudentRecord highestMarksStudent = null;
        for (StudentRecord record : records) {
            System.out.println(record);
            if (highestMarksStudent == null
                    || record.marks > highestMarksStudent.marks) {
                highestMarksStudent = record;
            }
        }
        if (highestMarksStudent != null) {
            System.out.println("Highest marks: " + highestMarksStudent);
        }
    }
}
