import java.util.*;

class students {
    private static final class Student {
        private final int rollNumber;
        private final String name;
        private double mark;

        private Student(int rollNumber, String name, double mark) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.mark = mark;
        }

        @Override
        public String toString() {
            return "Roll: " + rollNumber + ", Name: " + name + ", Mark: " + mark;
        }
    }

    private final List<Student> list = new ArrayList<>();

    public void addStudent(int rollNumber, String name, double mark) {
        if (findStudent(rollNumber) != null) {
            throw new IllegalArgumentException("Roll number already exists.");
        }
        list.add(new Student(rollNumber, name, mark));
    }

    public Student findStudent(int rollNumber) {
        for (Student student : list) {
            if (student.rollNumber == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public boolean updateMark(int rollNumber, double newMark) {
        Student student = findStudent(rollNumber);
        if (student == null) {
            return false;
        }
        student.mark = newMark;
        return true;
    }

    public boolean removeStudent(int rollNumber) {
        Student student = findStudent(rollNumber);
        return student != null && list.remove(student);
    }

    public static void main(String[] args) {
        students management = new students();
        management.addStudent(1, "Asha", 82);
        management.addStudent(2, "Bala", 74);
        management.addStudent(3, "Chitra", 91);
        management.addStudent(4, "Dev", 68);
        management.addStudent(5, "Esha", 78);

        System.out.println("Students scoring above 75:");
        for (Student student : management.list) {
            if (student.mark > 75) {
                System.out.println(student);
            }
        }

        System.out.println("\nSearch roll number 3: " + management.findStudent(3));
        management.updateMark(2, 79);
        management.removeStudent(4);

        management.list.sort(Comparator.comparingDouble(
                (Student student) -> student.mark).reversed());
        System.out.println("\nStudents sorted by marks:");
        management.list.forEach(System.out::println);
    }
}
